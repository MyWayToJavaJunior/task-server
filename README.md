# Task-server

This is a test task.

## Task description

Design and implement a task-server. It must provide the following REST API.

* Method to execute one of the three task types on n-workers:
 * Task which always fail execution.
 * Task which waits for 3 seconds and return a value.
 * task which immediately returns a PI value.

## Requirements

* Java8
* Maven3
* Multi-module project (to have an ability to add a new task handler w/o touching the code of executor).
* Back-pressure (skipped due a complexity of the implementation)

## Implementation details

I chose a simple implementation based on the Spring Framework [async request support](https://spring.io/blog/2012/05/10/spring-mvc-3-2-preview-making-a-controller-method-asynchronous/).
When a new HTTP-request is submitted, the controller method returns a callable which is executed in a separate thread pool, thus, a jetty request thread is freed to serve others API requests.
When the execution of the method call() is completed it restores the request context and flushes a result to a client.
So, from the server point of view the execution is asynchronous, but from a client side is synchronous.

But, can we make better? Yes, of course!

In a real world, it's a completely bad idea to have a task executor in the same JVM.
A better approach, to split it to separate processes and turn it into a fully asynchronous pattern.
The frontend server (API) receives a task and submits it to a message broker (rabbitmq, kafka).
The backend server (task executor) consumes tasks and executes it.
When a task is completed it can notify a client via another channel (e.g. websocket, push).
Another option (if a push approach is impossible) to expose API on frontend which can say a client that a job is completed.
It's option often called as a pull approach.

### How to add a new handler

* Add a new maven module (see examples of pi-handler, sleep-handler)
* Add the new module as dependency to the server module

How does it work?

TaskHandlerConfiguration class autowire all implementations of TaskHandler which are available in the classpath.
When TaskExecutionService is initialized it registers the implementations inside yourself.

### Basic platform, frameworks.
* Spring boot (easy REST API, configuration, DI)
* Jetty server
* Guava
* Testng/mockito/springockito

### API (json format)

* Post a task: curl -X POST -d '{"type": 1, "created": 42}' -H "Content-Type: application/json"  http://localhost:8080/api/tasks/
```
{"error":{"code":"EXECUTION_FAILED","message":"Something went wrong"}}
```

Depending on a task id a result can vary.






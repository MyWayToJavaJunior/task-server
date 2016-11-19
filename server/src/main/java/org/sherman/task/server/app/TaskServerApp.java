package org.sherman.task.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
@SpringBootApplication(scanBasePackages = "org.sherman.task.server")
public class TaskServerApp {
    public static void main(String[] args) {
        SpringApplication.run(TaskServerApp.class, args);
    }
}

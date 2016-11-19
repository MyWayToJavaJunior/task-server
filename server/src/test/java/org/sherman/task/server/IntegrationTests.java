package org.sherman.task.server;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.sherman.task.server.app.TaskServerApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.testng.Assert.assertEquals;

/**
 * @author Denis Gabaydulin
 * @since 18.11.16
 */
public class IntegrationTests extends AbstractTestNGSpringContextTests {
    private static final Logger log = LoggerFactory.getLogger(IntegrationTests.class);

    private AsyncHttpClient httpClient;

    @Test
    public void postInvalidTask() throws InterruptedException, ExecutionException {
        String json = "{\"type\": 4, \"created\": 42}";

        Response response = httpClient.preparePost("http://localhost:8080/api/tasks/")
                .setBody(json)
                .addHeader("Content-Type", APPLICATION_JSON_VALUE)
                .execute()
                .get();

        assertEquals(response.getResponseBody(), "{\"error\":{\"code\":\"EXECUTION_FAILED\",\"message\":\"Can't find handler for type NOT_IMPLEMENTED\"}}");
    }

    @Test
    public void getPi() throws ExecutionException, InterruptedException {
        String json = "{\"type\": 3, \"created\": 42}";

        Response response = httpClient.preparePost("http://localhost:8080/api/tasks/")
                .setBody(json)
                .addHeader("Content-Type", APPLICATION_JSON_VALUE)
                .execute()
                .get();

        assertEquals(response.getResponseBody(), "{\"result\":3.141592653589793}");
    }

    @BeforeTest
    private void beforeTest() throws InterruptedException {
        httpClient = new DefaultAsyncHttpClient();

        TaskServerApp.main(new String[]{});
    }

    @AfterTest
    private void afterTest() throws IOException {
        httpClient.close();
    }
}

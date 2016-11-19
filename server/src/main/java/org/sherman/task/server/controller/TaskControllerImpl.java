package org.sherman.task.server.controller;

import org.sherman.task.server.common.domain.Task;
import org.sherman.task.server.common.service.TaskExecutionService;
import org.sherman.task.server.domain.ReturnValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
@Controller
public class TaskControllerImpl implements TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskControllerImpl.class);

    @Autowired
    private TaskExecutionService executionService;

    @Override
    @PostMapping(value = "/api/tasks/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Callable<ReturnValue<Boolean>> execute(@RequestBody Task task) {
        log.info("{}", task);

        return () -> {
            log.info("Async");
            Thread.sleep(10000);
            return new ReturnValue<>(true);
        };
    }
}

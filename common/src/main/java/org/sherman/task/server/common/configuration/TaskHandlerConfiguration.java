package org.sherman.task.server.common.configuration;

import org.sherman.task.server.common.handler.TaskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
@Configuration
public class TaskHandlerConfiguration {
    @Autowired
    private List<TaskHandler<?>> handlers;

    public List<TaskHandler<?>> getHandlers() {
        return handlers;
    }
}

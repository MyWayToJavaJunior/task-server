package org.sherman.task.server.common.service;

import org.jetbrains.annotations.NotNull;
import org.sherman.task.server.common.configuration.TaskHandlerConfiguration;
import org.sherman.task.server.common.domain.Task;
import org.sherman.task.server.common.domain.TaskError;
import org.sherman.task.server.common.domain.TaskResult;
import org.sherman.task.server.common.domain.TaskType;
import org.sherman.task.server.common.handler.TaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

import static java.util.function.Function.identity;
import static org.sherman.task.server.common.util.GuavaCollectors.toImmutableMap;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
@Service
public class TaskExecutionServiceImpl implements TaskExecutionService {
    private static final Logger log = LoggerFactory.getLogger(TaskExecutionServiceImpl.class);

    @Autowired
    private TaskHandlerConfiguration taskHandlerConfiguration;

    private Map<TaskType, TaskHandler<?>> tasksToHandlers;

    @PostConstruct
    public void init() {
        tasksToHandlers = taskHandlerConfiguration.getHandlers().stream()
                .collect(toImmutableMap(TaskHandler::getType, identity()));

        log.info("Handlers found: {}", tasksToHandlers);
    }

    @Override
    public TaskResult<?> execute(@NotNull Task task) {
        try {
            return Optional.ofNullable(tasksToHandlers.get(task.getType()))
                    .map(handler -> new TaskResult<>(handler.handle(task)))
                    .orElseThrow(() -> new IllegalArgumentException("Can't find handler for type " + task.getType()));
        } catch (Exception e) {
            log.error("Can't execute task", e);
            return new TaskResult<>(new TaskError(e.getMessage()));
        }
    }
}

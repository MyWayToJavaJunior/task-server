package org.sherman.task.server.failed.handler;

import org.jetbrains.annotations.NotNull;
import org.sherman.task.server.common.domain.Task;
import org.sherman.task.server.common.domain.TaskType;
import org.sherman.task.server.common.handler.TaskHandler;
import org.springframework.stereotype.Component;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
@Component
public class FailedHandler implements TaskHandler<Boolean> {
    @Override
    public Boolean handle(@NotNull Task task) {
        throw new RuntimeException("Something went wrong");
    }

    @NotNull
    @Override
    public TaskType getType() {
        return TaskType.FAILED;
    }
}

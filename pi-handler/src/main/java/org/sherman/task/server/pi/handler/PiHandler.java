package org.sherman.task.server.pi.handler;

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
public class PiHandler implements TaskHandler<Double> {
    @Override
    public Double handle(@NotNull Task task) {
        return Math.PI;
    }

    @NotNull
    @Override
    public TaskType getType() {
        return TaskType.PI;
    }
}

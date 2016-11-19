package org.sherman.task.server.sleep.handler;

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
public class SleepHandler implements TaskHandler<Boolean> {
    @Override
    public Boolean handle(@NotNull Task task) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            // restore the interruption flag
            Thread.currentThread().interrupt();
        }

        return Boolean.TRUE;
    }

    @NotNull
    @Override
    public TaskType getType() {
        return TaskType.SLEEP;
    }
}

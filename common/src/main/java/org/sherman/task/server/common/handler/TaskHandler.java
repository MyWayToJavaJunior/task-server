package org.sherman.task.server.common.handler;

import org.jetbrains.annotations.NotNull;
import org.sherman.task.server.common.domain.Task;
import org.sherman.task.server.common.domain.TaskType;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public interface TaskHandler {
    void handle(@NotNull Task task);

    @NotNull
    TaskType getType();
}

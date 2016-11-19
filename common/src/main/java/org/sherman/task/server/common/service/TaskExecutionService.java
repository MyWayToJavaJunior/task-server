package org.sherman.task.server.common.service;

import org.jetbrains.annotations.NotNull;
import org.sherman.task.server.common.domain.Task;
import org.sherman.task.server.common.domain.TaskResult;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public interface TaskExecutionService {
    TaskResult<?> execute(@NotNull Task task);
}

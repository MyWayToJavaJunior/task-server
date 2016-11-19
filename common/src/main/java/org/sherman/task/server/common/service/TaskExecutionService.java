package org.sherman.task.server.common.service;

import org.jetbrains.annotations.NotNull;
import org.sherman.task.server.common.domain.Task;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public interface TaskExecutionService {
    void execute(@NotNull Task task);
}

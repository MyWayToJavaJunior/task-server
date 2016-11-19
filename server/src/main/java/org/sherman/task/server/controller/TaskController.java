package org.sherman.task.server.controller;

import org.sherman.task.server.common.domain.Task;
import org.sherman.task.server.domain.ReturnValue;

import java.util.concurrent.Callable;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public interface TaskController {
    Callable<ReturnValue<?>> execute(Task task);
}

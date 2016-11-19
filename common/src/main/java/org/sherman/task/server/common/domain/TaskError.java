package org.sherman.task.server.common.domain;

import com.google.common.base.MoreObjects;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public class TaskError {
    private final String error;

    public TaskError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("error", error)
                .toString();
    }
}

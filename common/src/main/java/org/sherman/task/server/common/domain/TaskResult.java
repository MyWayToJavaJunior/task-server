package org.sherman.task.server.common.domain;

import com.google.common.base.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public class TaskResult<T> {
    private final T result;
    private final TaskError error;

    public TaskResult(T result) {
        this.result = result;
        this.error = null;
    }

    public TaskResult(TaskError error) {
        this.error = error;
        result = null;
    }

    public T getResult() {
        return result;
    }

    public boolean hasError() {
        return error != null;
    }

    public TaskError getError() {
        return error;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (null == object) {
            return false;
        }

        @SuppressWarnings("unchecked")
        TaskResult<T> o = (TaskResult<T>) object;

        return
                Objects.equal(result, o.result)
                        && Objects.equal(error, o.error);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result, error);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .addValue(result)
                .addValue(error)
                .toString();
    }
}

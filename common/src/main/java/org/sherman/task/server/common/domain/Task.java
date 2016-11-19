package org.sherman.task.server.common.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public class Task {
    private TaskType type;
    private long created;

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", type)
                .add("created", created)
                .toString();
    }
}

package org.sherman.task.server.common.domain;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public enum TaskType {
    FAILED(1),
    SLEEP(2),
    PI(3);

    private final int id;

    TaskType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

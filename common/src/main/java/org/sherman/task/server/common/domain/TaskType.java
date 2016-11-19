package org.sherman.task.server.common.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.sherman.task.server.common.util.GuavaCollectors;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import static java.util.function.Function.identity;

/**
 * @author Denis Gabaydulin
 * @since 19.11.16
 */
public enum TaskType {
    FAILED(1),
    SLEEP(2),
    PI(3),
    NOT_IMPLEMENTED(4);

    private final int id;

    TaskType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @JsonCreator
    public static TaskType fromId(int id) {
        return indexedById.get(id);
    }

    private static final Map<Integer, TaskType> indexedById = Arrays.stream(TaskType.values())
            .collect(GuavaCollectors.toImmutableMap(TaskType::getId, identity()));
}

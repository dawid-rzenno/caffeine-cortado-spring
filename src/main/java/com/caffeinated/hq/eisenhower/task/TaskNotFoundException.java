package com.caffeinated.hq.eisenhower.task;

public class TaskNotFoundException extends RuntimeException {

    TaskNotFoundException(Long id) {
        super("Could not find task " + id);
    }
}

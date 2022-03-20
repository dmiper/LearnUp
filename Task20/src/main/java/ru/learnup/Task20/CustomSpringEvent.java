package ru.learnup.Task20;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {
    private final String event;

    public CustomSpringEvent(Object source, String event) {
        super(source);
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}


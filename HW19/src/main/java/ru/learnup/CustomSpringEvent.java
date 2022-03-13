package ru.learnup;

import org.springframework.context.ApplicationEvent;

// Простое Событие Приложения
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

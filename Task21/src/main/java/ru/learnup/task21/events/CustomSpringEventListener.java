package ru.learnup.task21.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomSpringEventListener.class);

    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        LOG.info("Event: {}", event.getEvent());
    }

}

package ru.learnup.Task20;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CustomSpringEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(int randomNumber, int yourNumber) {
        String str;
        if (yourNumber != randomNumber) {
            if (yourNumber > randomNumber) str = context.getMessage("less", null, Locale.getDefault());
            else str = context.getMessage("bigger", null, Locale.getDefault());
        } else {
            str = context.getMessage("win", null, Locale.getDefault()) + " " + randomNumber;
        }
        context.publishEvent(new CustomSpringEvent(context, str));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

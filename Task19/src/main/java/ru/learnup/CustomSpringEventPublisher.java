package ru.learnup;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomSpringEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(int randomNumber, int yourNumber) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        String str = yourNumber != randomNumber ? yourNumber > randomNumber ? context.getMessage("less", null, Locale.getDefault()) : context.getMessage("bigger", null, Locale.getDefault()) : context.getMessage("win", null, Locale.getDefault()) + " " + randomNumber;
        context.publishEvent(new CustomSpringEvent(context, str));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

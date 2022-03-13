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

    public String publishEvent(int randomNumber, int yourNumber) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        Locale localeDefault = Locale.getDefault();
        String str;
        if (yourNumber != randomNumber) {
            if (yourNumber > randomNumber) {
                str = context.getMessage("less", null, localeDefault);
            } else {
                str = context.getMessage("bigger", null, localeDefault);
            }
        } else {
            str = context.getMessage("win", null, localeDefault) + " " + randomNumber;
        }
        context.publishEvent(new CustomSpringEvent(context, str));
        return str;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}

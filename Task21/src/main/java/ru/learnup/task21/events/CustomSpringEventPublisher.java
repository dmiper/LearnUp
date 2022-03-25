package ru.learnup.task21.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.learnup.task21.aspects.LogMethod;
import ru.learnup.task21.aspects.WorkTime;

import static java.util.Locale.US;

@Service
public class CustomSpringEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    @LogMethod
    @WorkTime
    public void publishEvent(int randomNumber, int yourNumber) {
        String str;
        if (yourNumber != randomNumber) {
            if (yourNumber <= randomNumber) {
                str = context.getMessage("bigger", null, US);
            } else {
                str = context.getMessage("less", null, US);
            }
        } else {
            str = context.getMessage("win", null, US) + " " + randomNumber;
        }
        context.publishEvent(new CustomSpringEvent(context, str));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

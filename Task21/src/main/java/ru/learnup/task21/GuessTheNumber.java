package ru.learnup.task21;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.learnup.task21.aspects.LogMethod;
import ru.learnup.task21.events.CustomSpringEventPublisher;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Locale.US;

@Component
public class GuessTheNumber {

    private static final Logger LOG = LoggerFactory.getLogger(GuessTheNumber.class);

    public void print(ConfigurableApplicationContext context) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = new Random().nextInt(1000);
        Stream.of("greetingsOne", "greetingsTwo").map(s -> context.getMessage(s, null, US)).forEach(LOG::info);
        int yourNumber = -1;
        while (yourNumber != randomNumber) {
            yourNumber = scanner.nextInt();
            context.getBean(CustomSpringEventPublisher.class).publishEvent(randomNumber, yourNumber);
        }
    }
}

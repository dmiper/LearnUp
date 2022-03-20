package ru.learnup.Task20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class GuessTheNumber {

    private static final Logger LOG = LoggerFactory.getLogger(GuessTheNumber.class);

    public void print(ConfigurableApplicationContext context) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = new Random().nextInt(1000);
        Stream.of("greetingsOne", "greetingsTwo").map(s -> context.getMessage(s, null, Locale.getDefault())).forEach(LOG::info);
        int yourNumber = -1;
        while (yourNumber != randomNumber) {
            LOG.debug("Waiting for a record");
            yourNumber = scanner.nextInt();
            LOG.debug("Reading an entry");
            context.getBean(CustomSpringEventPublisher.class).publishEvent(randomNumber, yourNumber);
        }
    }
}

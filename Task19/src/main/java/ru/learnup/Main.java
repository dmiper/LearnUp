package ru.learnup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        CustomSpringEventPublisher publisher = context.getBean(CustomSpringEventPublisher.class);
        Scanner scanner = new Scanner(System.in);
        int randomNumber = new Random().nextInt(1000);
        Stream.of("greetingsOne", "greetingsTwo").map(s -> context.getMessage(s, null, Locale.getDefault())).forEach(log::info);
        int yourNumber = -1;
        while (yourNumber != randomNumber) {
            log.debug("Waiting for a record");
            yourNumber = scanner.nextInt();
            log.debug("Reading an entry");
            publisher.publishEvent(randomNumber, yourNumber);
        }
    }
}

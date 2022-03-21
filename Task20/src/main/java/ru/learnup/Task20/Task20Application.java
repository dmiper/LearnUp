package ru.learnup.Task20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Task20Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Task20Application.class, args);

        context.getBean(GuessTheNumber.class).print(context);

    }
}

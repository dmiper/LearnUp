package ru.learnup.task21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Task21Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Task21Application.class, args);

        context.getBean(GuessTheNumber.class).print(context);
    }

}

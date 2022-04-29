package ru.learnup.task22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Task22Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Task22Application.class, args);

        run.getBean(Tasting.class).print(run);

    }

}

package ru.learnup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class Task18Application {

    public static void main(String[] args) {
        SpringApplication.run(Task18Application.class, args);

        Scanner scanner = new Scanner(System.in);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("configuration.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);

        boolean gameOver = false;
        while (gameOver == false) {
            Arrays.asList("Выберите цифру операции: ", "1 - Суммировать", "2 - Вычесть ", "3 - Разделить ", "4 - Умножить ").forEach(System.out::println);
            int process = scanner.nextInt();
            double arg1;
            double arg2;
            switch (process) {
                case (1):
                    System.out.println("Запишите значения для суммирования по порядку: ");
                    arg1 = scanner.nextDouble();
                    arg2 = scanner.nextDouble();
                    System.out.println(arg1 + " - " + arg2 + " = " + calculator.sum(arg1, arg2));
                    break;
                case (2):
                    System.out.println("Запишите значения для вычитания по порядку: ");
                    arg1 = scanner.nextDouble();
                    arg2 = scanner.nextDouble();
                    System.out.println(arg1 + " - " + arg2 + " = " + calculator.subtract(arg1, arg2));
                    break;
                case (3):
                    System.out.println("Запишите значения для деления по порядку: ");
                    arg1 = scanner.nextDouble();
                    arg2 = scanner.nextDouble();
                    System.out.println(arg1 + " / " + arg2 + " = " + calculator.divide(arg1, arg2));
                    break;
                case (4):
                    System.out.println("Запишите значения для умножения по порядку: ");
                    arg1 = scanner.nextDouble();
                    arg2 = scanner.nextDouble();
                    System.out.println(arg1 + " * " + arg2 + " = " + calculator.multiply(arg1, arg2));
                    break;
                default:
                    throw new RuntimeException("Не та цифра!!! Под такой цыфрой нет операции.");
            }
            Arrays.asList("Продолжить вычисления?", "1 - Yes.", "0 - No.").forEach(System.out::println);
            if (scanner.nextInt() == 0) gameOver = true;
        }
    }

}

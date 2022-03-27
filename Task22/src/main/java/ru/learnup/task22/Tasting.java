package ru.learnup.task22;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.learnup.task22.models.Books;
import ru.learnup.task22.models.Orders;
import ru.learnup.task22.repository.BooksRepository;
import ru.learnup.task22.repository.OrdersRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class Tasting {

    private final static Scanner SCANNER = new Scanner(System.in);

    public void print(ConfigurableApplicationContext context) {
        BooksRepository booksRepository = context.getBean(BooksRepository.class);
        OrdersRepository ordersRepository = context.getBean(OrdersRepository.class);

        System.out.println("Здравствуйте.");
        int sc = 0;
        while (sc >= 0 && sc < 7) {
            for (String s : Arrays.asList(
                    "Что вы хотите?",
                    "1. Посмотреть список книг.",
                    "2. Найти книгу по ID.",
                    "3. Хотите добавить свою книгу в книжный магазин?",
                    "4. Сделать заказ.",
                    "5. Посмотреть список заказов.",
                    "6. Посмотреть заказ по ID.",
                    "7. Закончить")) {
                System.out.println(s);
            }
            sc = SCANNER.nextInt();
            SCANNER.nextLine();
            switch (sc) {
                case 1:
                    for (Books book : booksRepository.findAllBooks()) {
                        System.out.println(book);
                    }
                    break;
                case 2:
                    System.out.println("Какой ID книги вам нужен?");
                    int idBook = SCANNER.nextInt();
                    try {
                        Books book = booksRepository.findByIdBook(idBook);
                        System.out.println(book);
                    } catch (RuntimeException e) {
                        System.out.println("Такого ID нет. Ошибка: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Укажите название книги");
                    String nameBookScanner = SCANNER.nextLine();
                    System.out.println("Укажите автора книги");
                    String authorScanner = SCANNER.nextLine();
                    System.out.println("Укажите какое количество хотите добавить книг");
                    int quantityScanner = SCANNER.nextInt();
                    Books books = Books.builder()
                            .nameBook(nameBookScanner)
                            .author(authorScanner)
                            .quantity(quantityScanner)
                            .build();
                    booksRepository.saveBooks(books);
                    break;
                case 4:
                    System.out.println("Укажите ID книги");
                    int bookScanner = SCANNER.nextInt();
                    System.out.println("Укажите количество");
                    int quantityOrderScanner = SCANNER.nextInt();
                    System.out.println("Укажите ваше Имя");
                    String buyersNameScanner = SCANNER.next();
                    Orders orders = Orders.builder()
                            .book(bookScanner)
                            .quantity(quantityOrderScanner)
                            .buyersName(buyersNameScanner)
                            .dataOrder(LocalDate.now())
                            .build();
                    ordersRepository.saveOrder(orders);
                    break;
                case 5:
                    for (Orders order : ordersRepository.findAllOrder()) {
                        System.out.println(order);
                    }
                    break;
                case 6:
                    System.out.println("Какой ID заказа вам нужен?");
                    int idOrder = SCANNER.nextInt();
                    try {
                        Orders order = ordersRepository.findByIdOrder(idOrder);
                        System.out.println(order);
                    } catch (RuntimeException e) {
                        System.out.println("Такого ID нет. Ошибка: " + e);
                    }
                    break;
                default:
                    System.out.println("Всего вам хорошего!");
            }
        }

    }

}

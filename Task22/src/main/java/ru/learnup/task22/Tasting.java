package ru.learnup.task22;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.learnup.task22.models.Authors;
import ru.learnup.task22.models.Books;
import ru.learnup.task22.models.Orders;
import ru.learnup.task22.repository.AuthorsRepository;
import ru.learnup.task22.repository.BooksRepository;
import ru.learnup.task22.repository.OrdersRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class Tasting {

    private static final Logger LOG = LoggerFactory.getLogger(Tasting.class);

    private final static Scanner SCANNER = new Scanner(System.in);

    BooksRepository booksRepository;
    OrdersRepository ordersRepository;
    AuthorsRepository authorsRepository;

    public void print(ConfigurableApplicationContext context) {
        booksRepository = context.getBean(BooksRepository.class);
        ordersRepository = context.getBean(OrdersRepository.class);
        authorsRepository = context.getBean(AuthorsRepository.class);

        System.out.println("Здравствуйте.");
        int sc = 0;
        while (sc >= 0 && sc < 4) {
            for (String s : Arrays.asList(
                    "Что вы хотите?",
                    "1. Операции с авторами.",
                    "2. Операции с книгами.",
                    "3. Операции с заказами.",
                    "4. Выйти.")) {
                System.out.println(s);
            }
            sc = SCANNER.nextInt();
            SCANNER.nextLine();
            switch (sc) {
                case 1:
                    printAuthors();
                    break;
                case 2:
                    printBooks();
                    break;
                case 3:
                    printOrders();
                    break;
                default:
                    System.out.println("Всего вам хорошего!");
            }
        }

    }

    public void printAuthors() {
        int sc = 0;
        while (sc >= 0 && sc < 4) {
            for (String s : Arrays.asList(
                    "Что вы хотите?",
                    "1. Показать всех авторов.",
                    "2. Показать автор по ID.",
                    "3. Добавить автора.",
                    "4. Выйти.")) {
                System.out.println(s);
            }
            sc = SCANNER.nextInt();
            SCANNER.nextLine();
            switch (sc) {
                case 1:
                    for (Authors authors : authorsRepository.findAllAuthors()) {
                        System.out.println(authors);
                    }
                    break;
                case 2:
                    System.out.println("Укажите ID автора.");
                    int idAuthor = SCANNER.nextInt();
                    try {
                        Authors authors = authorsRepository.findByIdAuthors(idAuthor);
                        System.out.println(authors);
                    } catch (RuntimeException e) {
                        LOG.info("Такого ID нет. Ошибка: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Запишите ФИО автора книги");
                    String authorScanner = SCANNER.nextLine();
                    try {
                        Authors authors = Authors.builder()
                                .author(authorScanner)
                                .build();
                        authorsRepository.saveAuthors(authors);
                    } catch (RuntimeException e) {
                        LOG.info("Повторите операцию, данные введены не верно. Ошибка при сохранении автора: " + e);
                    }
                    break;
                default:
                    System.out.println("Выход.");
            }
        }
    }

    public void printBooks() {
        int sc = 0;
        while (sc >= 0 && sc < 4) {
            for (String s : Arrays.asList(
                    "Что вы хотите?",
                    "1. Показать все книги с авторами.",
                    "2. Показать книгу по ID.",
                    "3. Добавить книгу.",
                    "4. Выйти.")) {
                System.out.println(s);
            }
            sc = SCANNER.nextInt();
            SCANNER.nextLine();
            switch (sc) {
                case 1:
                    for (Books book : booksRepository.findAllBooksAndAuthors()) {
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
                        LOG.info("Такого ID нет. Ошибка: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Укажите название книги");
                    String nameBookScanner = SCANNER.nextLine();
                    System.out.println("Укажите номер автора книги");
                    int authorScanner = SCANNER.nextInt();
                    System.out.println("Укажите какое количество хотите добавить книг");
                    int quantityScanner = SCANNER.nextInt();
                    try {
                        Books books = Books.builder()
                                .nameBook(nameBookScanner)
                                .authorId(authorScanner)
                                .quantity(quantityScanner)
                                .build();
                        booksRepository.saveBooks(books);
                    } catch (RuntimeException e) {
                        LOG.info("Повторите операцию, данные введены не верно. Ошибка при сохранении книги: " + e);
                    }
                    break;
                default:
                    System.out.println("Выход.");
            }
        }
    }

    public void printOrders() {
        int sc = 0;
        while (sc >= 0 && sc < 4) {
            for (String s : Arrays.asList(
                    "Что вы хотите?",
                    "1. Добавить заказ.",
                    "2. Показать все заказы.",
                    "3. Показать заказ по ID.",
                    "4. Выйти.")) {
                System.out.println(s);
            }
            sc = SCANNER.nextInt();
            SCANNER.nextLine();
            switch (sc) {
                case 1:
                    System.out.println("Укажите ID книги");
                    int bookScanner = SCANNER.nextInt();
                    System.out.println("Укажите количество");
                    int quantityOrderScanner = SCANNER.nextInt();
                    System.out.println("Укажите ваше Имя");
                    String buyersNameScanner = SCANNER.next();
                    try {
                        Orders orders = Orders.builder()
                                .book(bookScanner)
                                .quantity(quantityOrderScanner)
                                .buyersName(buyersNameScanner)
                                .dataOrder(LocalDate.now())
                                .build();
                        ordersRepository.makeOrder(orders);
                    } catch (RuntimeException e) {
                        LOG.info("Повторите операцию, данные введены не верно. Ошибка при создании заказа: " + e);
                    }
                    try {
                        Books books = Books.builder()
                                .id(bookScanner)
                                .quantity(quantityOrderScanner)
                                .build();
                        booksRepository.updateBook(books);
                    } catch (RuntimeException e) {
                        LOG.info("Ошибка при обновлении количества книг: " + e);
                    }
                    break;
                case 2:
                    for (Orders order : ordersRepository.findAllOrder()) {
                        System.out.println(order);
                    }
                    break;
                case 3:
                    System.out.println("Какой ID заказа вам нужен?");
                    int idOrder = SCANNER.nextInt();
                    try {
                        Orders order = ordersRepository.findByIdOrder(idOrder);
                        System.out.println(order);
                    } catch (RuntimeException e) {
                        LOG.info("Такого ID нет. Ошибка: " + e);
                    }
                    break;
                default:
                    System.out.println("Выход.");
            }
        }
    }

}

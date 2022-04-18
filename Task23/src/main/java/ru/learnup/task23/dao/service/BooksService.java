package ru.learnup.task23.dao.service;

import ru.learnup.task23.dao.entity.Books;

import java.util.List;

public interface BooksService {

    void addBook(Books books);

    List<Books> getAllBooks();

    List<Books> getBooksId(Long id);

    void deleteBook(Long id);

    void updateBook(Long id, Books books);

}

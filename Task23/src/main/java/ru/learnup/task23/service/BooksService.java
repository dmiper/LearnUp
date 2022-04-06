package ru.learnup.task23.service;

import org.springframework.stereotype.Service;
import ru.learnup.task23.models.Books;
import ru.learnup.task23.repository.BooksRepository;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> findBooksByAuthorID(Long id) {
        return booksRepository.findBooksByAuthorID(id);
    }
}

package ru.learnup.task23.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.learnup.task23.dao.entity.Books;
import ru.learnup.task23.dao.repository.BooksRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;

    @Override
    public void addBook(Books books) {
        Books book = Books.builder()
                .title(books.getTitle())
                .author(books.getAuthor())
                .yearOfPublication(books.getYearOfPublication())
                .numberOfPages(books.getNumberOfPages())
                .price(books.getPrice())
                .build();
        booksRepository.save(book);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }
    @Override
    public List<Books> getBooksId(Long id) {
        return booksRepository.findBooksByAuthorID(id);
    }

    @Override
    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }

    @Override
    public void updateBook(Long id, Books books) {
        Books oldBook = booksRepository.getById(id);
        oldBook.setTitle(books.getTitle());
        oldBook.setAuthor(books.getAuthor());
        oldBook.setYearOfPublication(books.getYearOfPublication());
        oldBook.setNumberOfPages(books.getNumberOfPages());
        oldBook.setPrice(books.getPrice());
        booksRepository.save(oldBook);
    }
}

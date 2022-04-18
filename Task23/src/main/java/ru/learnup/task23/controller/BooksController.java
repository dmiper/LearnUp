package ru.learnup.task23.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.learnup.task23.dao.entity.Books;
import ru.learnup.task23.dao.service.BooksService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private final BooksService booksService;
    final String redirectHome = "home";

    @GetMapping
    public String home(Model model) {
        return redirectHome;
    }

    @PostMapping("/addBook")
    private String addBooks(Books books) {
        log.debug("{}", books);
        booksService.addBook(books);
        return "addBook";
    }

    @GetMapping("/catalog")
    public String getBooks(Model model) {
        List<Books> books = booksService.getAllBooks();
        log.debug("{}", books);
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/{idBook}/delete")
    public String delete(@PathVariable("idBook") Long id) {
        booksService.deleteBook(id);
        return redirectHome;
    }

    @PostMapping("/{idBook}/update")
    public String update(@PathVariable("idBook") Long id, @Valid Books books) {
        booksService.updateBook(id, books);
        return redirectHome + "/{idBook}";
    }


}

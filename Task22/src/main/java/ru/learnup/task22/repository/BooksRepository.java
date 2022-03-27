package ru.learnup.task22.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.task22.models.Books;

import java.util.List;

@Repository
public class BooksRepository {

    private final NamedParameterJdbcTemplate template;

    private static final String FIND_ALL = "select * from schema.books ";

    private static final String FIND_BY_ID = "select * from schema.books " +
            "where books.id = :id";

    private static final String SAVE_BOOKS =
            "insert into schema.books (name_book, author, quantity) " +
                    "values (:name_book, :author, :quantity)";


    public BooksRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Books> findAllBooks() {
        return template.query(FIND_ALL,
                new MapSqlParameterSource(), (rs, rn) -> Books.builder()
                        .id(rs.getInt("id"))
                        .nameBook(rs.getString("name_book"))
                        .author(rs.getString("author"))
                        .quantity(rs.getInt("quantity"))
                        .build()
        );
    }

    public Books findByIdBook(int id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Books.builder()
                                .id(rs.getInt("id"))
                                .nameBook(rs.getString("name_book"))
                                .author(rs.getString("author"))
                                .quantity(rs.getInt("quantity"))
                                .build()
                ).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Books with id = " + id + " is not found"));
    }

    public void saveBooks(Books books) {
        template.update(
                SAVE_BOOKS,
                new MapSqlParameterSource()
                        .addValue("name_book", books.getNameBook())
                        .addValue("author", books.getAuthor())
                        .addValue("quantity", books.getQuantity())
        );
    }
}

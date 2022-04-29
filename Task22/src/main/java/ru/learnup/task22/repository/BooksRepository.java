package ru.learnup.task22.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.task22.models.Books;

import java.util.List;

@Repository
public class BooksRepository {

    private final NamedParameterJdbcTemplate template;

    private static final String FIND_ALL_BOOKS_AND_AUTHORS =
            "select g_books.id, g_books.name_book, g_books.author_id, c.author, g_books.quantity " +
                    "from books g_books " +
                    "left join authors c on c.id = g_books.author_id";

    private static final String FIND_BY_ID =
            "select g_books.id, g_books.name_book, g_books.author_id, c.author, g_books.quantity " +
                    "from books g_books " +
                    "left join authors c on c.id = g_books.author_id where g_books.id = :id";

    private static final String SAVE_BOOKS =
            "insert into books (name_book, author_id, quantity) values (:name_book, :author_id, :quantity)";

    private static final String UPDATE_ORDER =
            "update books set quantity = quantity - (:quantity) where id = (:id)";

    public BooksRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    public List<Books> findAllBooksAndAuthors() {
        return template.query(FIND_ALL_BOOKS_AND_AUTHORS,
                new MapSqlParameterSource(), (rs, rn) -> Books.builder()
                        .id(rs.getInt("id"))
                        .nameBook(rs.getString("name_book"))
                        .authorId(rs.getInt("author_id"))
                        .authorName(rs.getString("author"))
                        .quantity(rs.getInt("quantity"))
                        .build());
    }

    public Books findByIdBook(int id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Books.builder()
                                .id(rs.getInt("id"))
                                .nameBook(rs.getString("name_book"))
                                .authorId(rs.getInt("author_id"))
                                .authorName(rs.getString("author"))
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
                        .addValue("author_id", books.getAuthorId())
                        .addValue("quantity", books.getQuantity())
        );
    }

    public void updateBook(Books books) {
        template.update(
                UPDATE_ORDER,
                new MapSqlParameterSource()
                        .addValue("id", books.getId())
                        .addValue("quantity", books.getQuantity()));
    }


}

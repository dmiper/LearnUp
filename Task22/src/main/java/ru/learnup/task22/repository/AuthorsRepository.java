package ru.learnup.task22.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.task22.models.Authors;

import java.util.List;

@Repository
public class AuthorsRepository {
    private final NamedParameterJdbcTemplate template;

    private static final String FIND_ALL =
            "select * from authors";

    private static final String FIND_BY_ID =
            "select * from authors where authors.id = :id";

    private static final String SAVE_AUTHOR =
            "insert into authors (author) values (:author)";

    public AuthorsRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Authors> findAllAuthors() {
        return template.query(FIND_ALL,
                new MapSqlParameterSource(), (rs, rn) -> Authors.builder()
                        .id(rs.getInt("id"))
                        .author(rs.getString("author"))
                        .build());
    }

    public Authors findByIdAuthors(int id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Authors.builder()
                                .id(rs.getInt("id"))
                                .author(rs.getString("author"))
                                .build()
                ).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Books with id = " + id + " is not found"));
    }

    public void saveAuthors(Authors authors) {
        template.update(
                SAVE_AUTHOR,
                new MapSqlParameterSource()
                        .addValue("author", authors.getAuthor()));
    }

}

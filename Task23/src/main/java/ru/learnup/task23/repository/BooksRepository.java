package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Books;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Books save(Books books);

    List<Books> findAllBy(Long id);

    List<Books> deleteBy(Long id);

    @Query(value = "select p.id, fullname, title, year_of_publication, number_of_pages, price " +
            "from schema.books p " +
            "left join schema.author c on p.author_id = c.id " +
            "where p.author_id = :id",
            nativeQuery = true)
    List<Books> findBooksByAuthorID(Long id);

}

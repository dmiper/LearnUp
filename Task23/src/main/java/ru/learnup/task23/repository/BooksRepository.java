package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Books;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Books save(Books books);

    List<Books> findAllBy(Long id);

    List<Books> deleteBy(Long id);
}
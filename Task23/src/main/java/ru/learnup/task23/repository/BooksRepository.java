package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Books;
import ru.learnup.task23.models.Orders;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Books save(Books books);

    Orders findAllById(Long id);

    void delete(Long id);
}

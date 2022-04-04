package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Authors;
import ru.learnup.task23.models.Orders;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    Authors save(Authors authors);

    Orders findAllById(Long id);

    void delete(Long id);
}

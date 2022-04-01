package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Authors;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    Authors save(Authors authors);

    List<Authors> findAllBy(Long id);

    List<Authors> deleteBy(Long id);
}
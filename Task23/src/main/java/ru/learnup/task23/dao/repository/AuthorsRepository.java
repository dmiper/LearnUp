package ru.learnup.task23.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.dao.entity.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {

}

package ru.learnup.task23.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.dao.entity.Buyers;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Long> {

}

package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Buyers;
import ru.learnup.task23.models.Orders;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Long> {

}

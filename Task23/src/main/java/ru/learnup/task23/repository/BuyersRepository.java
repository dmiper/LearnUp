package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Buyers;
import ru.learnup.task23.models.Orders;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Long> {

    Buyers save(Buyers buyers);

    Orders findAllById(Long id);

    void delete(Long id);
}
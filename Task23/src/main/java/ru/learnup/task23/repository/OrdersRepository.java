package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Orders save(Orders orders);

    Orders findAllById(Long id);

    void delete(Long id);
}

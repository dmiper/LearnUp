package ru.learnup.task23.dao.repository;

import ru.learnup.task23.dao.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Orders save(Orders orders);

    List<Orders> findAllBy(Long id);

    List<Orders> deleteBy(Long id);
}

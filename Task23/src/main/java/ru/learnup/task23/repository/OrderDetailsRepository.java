package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.OrderDetails;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    OrderDetails save(OrderDetails orderDetails);

    List<OrderDetails> findAllBy(Long id);

    List<OrderDetails> deleteBy(Long id);
}
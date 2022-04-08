package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.OrderDetails;
import ru.learnup.task23.models.Orders;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}

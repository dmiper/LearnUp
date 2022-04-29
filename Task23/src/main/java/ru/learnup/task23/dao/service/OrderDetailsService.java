package ru.learnup.task23.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.task23.dao.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
}

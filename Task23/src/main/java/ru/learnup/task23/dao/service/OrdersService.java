package ru.learnup.task23.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.task23.dao.repository.OrdersRepository;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
}

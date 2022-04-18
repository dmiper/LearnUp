package ru.learnup.task23.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.learnup.task23.dao.repository.OrdersRepository;

@RequiredArgsConstructor
@Component
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
}

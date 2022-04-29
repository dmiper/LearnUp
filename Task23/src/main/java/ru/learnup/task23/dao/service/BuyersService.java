package ru.learnup.task23.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.task23.dao.repository.BuyersRepository;

@Service
public class BuyersService {

    private final BuyersRepository buyersRepository;

    public BuyersService(BuyersRepository buyersRepository) {
        this.buyersRepository = buyersRepository;
    }
}

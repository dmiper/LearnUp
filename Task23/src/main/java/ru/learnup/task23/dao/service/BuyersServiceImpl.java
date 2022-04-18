package ru.learnup.task23.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.learnup.task23.dao.repository.BuyersRepository;

@RequiredArgsConstructor
@Component
public class BuyersServiceImpl implements BuyersService{

    private final BuyersRepository buyersRepository;

}

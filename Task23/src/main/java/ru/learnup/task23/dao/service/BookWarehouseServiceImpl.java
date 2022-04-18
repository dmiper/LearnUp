package ru.learnup.task23.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.learnup.task23.dao.repository.BookWarehouseRepository;

@RequiredArgsConstructor
@Component
public class BookWarehouseServiceImpl implements BookWarehouseService {

    private final BookWarehouseRepository bookWarehouseRepository;

}

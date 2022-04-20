package ru.learnup.task23.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.task23.dao.repository.BookWarehouseRepository;

@Service
public class BookWarehouseService {

    private final BookWarehouseRepository bookWarehouseRepository;

    public BookWarehouseService(BookWarehouseRepository bookWarehouseRepository) {
        this.bookWarehouseRepository = bookWarehouseRepository;
    }
}

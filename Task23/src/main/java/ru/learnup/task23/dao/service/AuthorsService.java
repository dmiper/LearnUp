package ru.learnup.task23.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.task23.dao.repository.AuthorsRepository;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }
}

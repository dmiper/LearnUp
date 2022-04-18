package ru.learnup.task23.dao.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.learnup.task23.dao.repository.AuthorsRepository;

@RequiredArgsConstructor
@Component
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepository authorsRepository;

}

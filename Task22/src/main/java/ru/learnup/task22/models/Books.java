package ru.learnup.task22.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Books {
    private int id;
    private String nameBook;
    private String author;
    private int quantity;
}

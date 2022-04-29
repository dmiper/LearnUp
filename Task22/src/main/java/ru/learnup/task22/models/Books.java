package ru.learnup.task22.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Books {

    private int id;
    private String nameBook;
    private int authorId;
    private String authorName;
    private int quantity;

}

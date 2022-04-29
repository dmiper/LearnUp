package ru.learnup.task22.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Authors {

    private int id;
    private String author;

}

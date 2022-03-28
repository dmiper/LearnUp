package ru.learnup.task22.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Orders {
    private int id;
    private int book;
    private int quantity;
    private String buyersName;
    private LocalDate dataOrder;
}

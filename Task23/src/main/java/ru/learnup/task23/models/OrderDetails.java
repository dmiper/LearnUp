package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Детали заказа - ид заказа, ид книги, количество, цена
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class OrderDetails {

    @Id
    @OneToOne
    private Orders orderID;

    @ManyToOne
    @JoinColumn
    private Books bookID;

    @Min(value = 0)
    @Column(nullable = false)
    private int quantity;

    @Min(value = 0)
    @Column(nullable = false)
    private int price;
}

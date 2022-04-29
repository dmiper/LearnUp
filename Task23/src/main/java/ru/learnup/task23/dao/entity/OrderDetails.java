package ru.learnup.task23.dao.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Детали заказа - ид заказа, ид книги, количество, цена
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orders order;

    @ManyToOne
    @JoinColumn
    private Books book;

    @Min(value = 0)
    @Column(nullable = false)
    private Long quantity;

    @Min(value = 0)
    @Column(nullable = false)
    private Long price;
}

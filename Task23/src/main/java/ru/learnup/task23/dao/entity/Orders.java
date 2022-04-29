package ru.learnup.task23.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Заказ - ид покупателя, ид заказа, сумма покупки
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Buyers buyer;

    @Min(value = 0)
    @Column(nullable = false)
    private Long purchaseAmount;
}

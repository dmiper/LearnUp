package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Заказ - ид покупателя, ид заказа, сумма покупки
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Buyers buyerID;

    @Min(value = 0)
    @Column(nullable = false)
    private Integer purchaseAmount;
}

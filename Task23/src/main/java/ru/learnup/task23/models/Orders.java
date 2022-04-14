package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Заказ - ид покупателя, ид заказа, сумма покупки
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Buyers buyerID;

    @Min(value = 0)
    @Column(nullable = false)
    private Long purchaseAmount;
}

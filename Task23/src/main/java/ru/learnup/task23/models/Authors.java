package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;

/**
 * Автор - ФИО, ид
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String fullName;

}

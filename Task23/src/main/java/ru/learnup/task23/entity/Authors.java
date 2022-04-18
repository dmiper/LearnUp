package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;

/**
 * Автор - ФИО, ид
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

}

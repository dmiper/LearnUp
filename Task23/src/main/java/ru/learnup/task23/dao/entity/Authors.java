package ru.learnup.task23.dao.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Автор - ФИО, ид
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

}

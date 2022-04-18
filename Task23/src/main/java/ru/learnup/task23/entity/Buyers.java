package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Покупатель - ид, ФИО, дата рождения
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Buyers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
}

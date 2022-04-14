package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Покупатель - ид, ФИО, дата рождения
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Buyers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
}

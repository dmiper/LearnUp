package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

/**
 * Книга - информация о названии, ид автора, годе издания, количестве страниц, цене
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn
    private Authors author;

    @Column(nullable = false)
    private LocalDate yearOfPublication;

    @Min(value = 0)
    @Column(nullable = false)
    private Long numberOfPages;

    @Min(value = 0)
    @Column(nullable = false)
    private Long price;
}

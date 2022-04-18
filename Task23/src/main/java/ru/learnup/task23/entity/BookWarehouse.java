package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Книжный склад - информация об остатках книг по идентификатору книги
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class BookWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Books book;

    @Min(value = 0)
    @Column(nullable = false)
    private Long theRestOfTheBooks;

}

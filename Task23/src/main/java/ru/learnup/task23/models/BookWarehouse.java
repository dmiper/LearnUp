package ru.learnup.task23.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Книжный склад - информация об остатках книг по идентификатору книги
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class BookWarehouse {

    @Id
    @OneToOne(optional = false)
    private Books book;

    @Min(value = 0)
    @Column(nullable = false)
    private Integer theRestOfTheBooks;

}

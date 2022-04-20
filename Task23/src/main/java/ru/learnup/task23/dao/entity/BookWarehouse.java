package ru.learnup.task23.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Книжный склад - информация об остатках книг по идентификатору книги
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class BookWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Books book;

    @Min(value = 0)
    @Column(nullable = false)
    private Long theRestOfTheBooks;

    @Version
    private Long version;
}

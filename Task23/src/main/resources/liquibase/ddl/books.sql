--liquibase formatted sql

--changeset pervushin: create_books_table
CREATE TABLE schema.books
(
    id                  serial primary key,
    title               text not null,
    author_id           int8 not null,
    year_of_publication date not null,
    number_of_pages     int8 not null,
    price               int8 not null
);

--changeset pervushin: create_books_table_fk
ALTER TABLE schema.books
    ADD CONSTRAINT FK_BOOKS_ON_AUTHORID FOREIGN KEY (author_id) REFERENCES schema.authors (id);


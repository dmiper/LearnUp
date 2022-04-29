--liquibase formatted sql

--changeset pervushin: create_book_warehouse_table
CREATE TABLE schema.book_warehouse
(
    id                    serial primary key,
    book_id               int8 not null,
    the_rest_of_the_books int8 not null,
    version               int8 default 0
);

--changeset pervushin: create_book_warehouse_table_fk
ALTER TABLE schema.book_warehouse
    ADD CONSTRAINT FK_BOOKWAREHOUSE_ON_BOOK FOREIGN KEY (book_id) REFERENCES schema.books (id);


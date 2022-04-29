--liquibase formatted sql

--changeset pervushin: create_book_authors_table
CREATE TABLE schema.product
(
    id      serial primary key,
    version int8 default 0
);
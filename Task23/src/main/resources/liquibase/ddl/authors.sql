--liquibase formatted sql

--changeset pervushin: create_book_authors_table
CREATE TABLE schema.authors
(
    id        serial primary key,
    full_name text not null
);


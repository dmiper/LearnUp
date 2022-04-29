--liquibase formatted sql

--changeset pervushin: create_buyers_table
CREATE TABLE schema.buyers
(
    id            serial primary key,
    full_name     text not null,
    date_of_birth date not null
);

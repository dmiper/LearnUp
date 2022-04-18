--liquibase formatted sql

--changeset pervushin: create_book_authors_table
CREATE TABLE schema.authors
(
    id        serial primary key,
    full_name text not null
);

--changeset pervushin:init_authors;
insert into schema.authors(full_name)
values ('Dostoevsky Fyodor Mikhailovich'),
       ('Schepetnov Evgeny Vladimirovich'),
       ('Stephen King'),
       ('Agatha Christie Mullovan'),
       ('Tolstoy Lev Nikolaevich'),
       ('Gogol Nikolay Vasilievich');

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

--changeset pervushin:init_books;
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('auditor', 6, '2010-01-10', 253, 635),
       ('after the ball', 5, '1911-01-10', 341, 1635),
       ('10 Little Indians', 4, '1939-01-10', 295, 910),
       ('it', 3, '1986-01-10', 623, 862),
       ('books 1-9', 2, '2020-01-10', 1023, 7315),
       ('moron', 1, '1869-01-10', 213, 1335),
       ('three bears', 5, '2016-01-10', 153, 229);

--changeset pervushin: create_book_warehouse_table
CREATE TABLE schema.book_warehouse
(
    id                    serial primary key,
    book_id               int8 not null,
    the_rest_of_the_books int8 not null
);

--changeset pervushin: create_book_warehouse_table_fk
ALTER TABLE schema.book_warehouse
    ADD CONSTRAINT FK_BOOKWAREHOUSE_ON_BOOK FOREIGN KEY (book_id) REFERENCES schema.books (id);

--changeset pervushin:init_book_warehouse;
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (1, 200),
       (2, 200),
       (3, 200),
       (4, 200),
       (5, 200),
       (6, 200),
       (7, 200);

--changeset pervushin: create_buyers_table
CREATE TABLE schema.buyers
(
    id            serial primary key,
    full_name     text not null,
    date_of_birth date not null
);

--changeset pervushin:init_buyers
/*insert into schema.buyers(full_name, date_of_birth)
values ('');*/

--changeset pervushin: create_orders_table
CREATE TABLE schema.orders
(
    id              serial primary key,
    buyer_id        int8 not null,
    purchase_amount int8 not null
);

--changeset pervushin: create_orders_table_fk
ALTER TABLE schema.orders
    ADD CONSTRAINT FK_ORDERS_ON_BUYERID FOREIGN KEY (buyer_id) REFERENCES schema.buyers (id);

--changeset pervushin:init_orders
/*insert into schema.orders(buyer_id, purchase_amount)
values ('');*/

--changeset pervushin: create_order_details_table
CREATE TABLE schema.order_details
(
    id       serial primary key,
    order_id int8 not null,
    book_id  int8 not null,
    quantity int8 not null,
    price    int8 not null
);

--changeset pervushin: create_order_details_table_fk
ALTER TABLE schema.order_details
    ADD CONSTRAINT FK_ORDERDETAILS_ON_BOOKID FOREIGN KEY (book_id) REFERENCES schema.books (id);

ALTER TABLE schema.order_details
    ADD CONSTRAINT FK_ORDERDETAILS_ON_ORDERID FOREIGN KEY (order_id) REFERENCES schema.orders (id);

--changeset pervushin:init_order_details
/*insert into schema.order_details(order_id, book_id, quantity, price)
values ('');*/

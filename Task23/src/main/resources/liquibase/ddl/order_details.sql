--liquibase formatted sql

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

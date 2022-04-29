--liquibase formatted sql

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

--liquibase formatted sql

--changeset pervushin:init_authors;
insert into schema.authors(full_name)
values ('Dostoevsky Fyodor Mikhailovich');
insert into schema.authors(full_name)
values ('Schepetnov Evgeny Vladimirovich');
insert into schema.authors(full_name)
values ('Stephen King');
insert into schema.authors(full_name)
values ('Agatha Christie Mullovan');
insert into schema.authors(full_name)
values ('Tolstoy Lev Nikolaevich');
insert into schema.authors(full_name)
values ('Gogol Nikolay Vasilievich');

--changeset pervushin:init_books;
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('auditor', 6, '2010-01-10', 253, 635);
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('after the ball', 5, '1911-01-10', 341, 1635);
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('10 Little Indians', 4, '1939-01-10', 295, 910);
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('it', 3, '1986-01-10', 623, 862);
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('books 1-9', 2, '2020-01-10', 1023, 7315);
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('moron', 1, '1869-01-10', 213, 1335);
insert into schema.books(title, author_id, year_of_publication, number_of_pages, price)
values ('three bears', 5, '2016-01-10', 153, 229);

--changeset pervushin:init_book_warehouse;
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (1, 200);
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (2, 200);
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (3, 200);
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (4, 200);
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (5, 200);
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (6, 200);
insert into schema.book_warehouse(book_id, the_rest_of_the_books)
values (7, 200);

--changeset pervushin:init_buyers
/*insert into schema.buyers(full_name, date_of_birth)
values ('');*/

--changeset pervushin:init_orders
/*insert into schema.orders(buyer_id, purchase_amount)
values ('');*/

--changeset pervushin:init_order_details
/*insert into schema.order_details(order_id, book_id, quantity, price)
values ('');*/
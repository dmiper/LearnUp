create table authors
(
    id     serial primary key,   -- id номера заказа
    author varchar(100) not null -- Покупатель
);

insert into authors(author)
values ('Сергей Лукьяненко'),
       ('Лев Толстой'),
       ('Анна Орехова'),
       ('Макс Глебов');


create table books
(
    id        serial primary key,    -- id
    name_book varchar(150) not null, -- Название книги
    author_id integer      not null, -- id Автора
    quantity  integer      not null, -- Количество

    foreign key (author_id) references authors (id)
);

insert into books(name_book, author_id, quantity)
values ('Три дня Индиго', 1, 40),
       ('Звезд не хватит на всех. Коллапс Буферной Зоны', 4, 25),
       ('Анна Каренина', 2, 50),
       ('Эффект Врат', 3, 10);

create table orders
(
    id          serial primary key,    -- id номера заказа
    book        integer      not null, -- Книга
    quantity    integer      not null, -- Количество
    buyers_name varchar(100) not null, -- Покупатель
    date_order  date         not null, -- Дата

    foreign key (book) references books (id)
);

insert into orders(book, quantity, buyers_name, date_order)
values (1, 1, 'Василий Петрович', '31-12-2021'),
       (2, 1, 'Анна Каренина', '29-02-2020');

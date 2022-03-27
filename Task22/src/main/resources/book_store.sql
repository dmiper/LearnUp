create table books
(
    id        serial primary key, -- id
    name_book varchar(55) not null, -- Название книги
    author    varchar(55) not null, -- Автор
    quantity  integer     not null -- Количество
);

insert into books(name_book, author, quantity)
values ('Три дня Индиго', 'Сергей Лукьяненко', 40),
       ('Звезд не хватит на всех. Коллапс Буферной Зоны', 'Макс Глебов', 25),
       ('Анна КаренинаАУДИО', 'Лев Толстой', 50),
       ('Эффект Врат', 'Анна Орехова', 10);


create table orders
(
    id_order_number serial primary key, -- id номера заказа
    book            integer not null, -- Книга
    quantity        integer not null, -- Количество
    buyers_name     varchar(55) not null, -- Покупатель
    date_order date not null, -- Дата

    foreign key (book) references books (id)
);

insert into orders(book, quantity, buyers_name, date_order)
values (1, 1, 'Василий Петрович', '31-12-2021'),
       (2, 1, 'Анна Каренина', '29-02-2020');



create table if not exists cities (
    id serial not null,
    name varchar(100) not null,
    state char(2) not null,
    constraint pk_city primary key (id)
);
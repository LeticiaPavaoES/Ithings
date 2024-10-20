create table if not exists customers (
    id serial not null,
    full_name varchar(100) not null,
    birth_date date not null,
    gender char(1) not null,
    city_id bigint not null,
    constraint pk_customers primary key (id),
    constraint fk_customers_cities foreign key (city_id) references cities(id)
);
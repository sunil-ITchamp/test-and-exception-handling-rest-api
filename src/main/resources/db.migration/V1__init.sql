create sequence customer_id_seq start with 1 increment by 50;
create sequence order_id_seq start with 1 increment by 50;

create table customer
(
id bigint DEFAULT nextval('customer_id_seq') not null,
name varchar not null,
email varchar not null,
primemember boolean not null,
primary key (id)
);

create table order
(
id bigint DEFAULT nextval('order_id_seq') not null,
totalbill float not null,
primary key (id)
);
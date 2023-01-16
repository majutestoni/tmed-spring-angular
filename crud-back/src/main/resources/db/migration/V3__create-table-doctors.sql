CREATE TABLE doctors(
    id bigint not null AUTO_INCREMENT,
    name varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    specialty varchar(100) not null,
    active tinyint,
    primary key(id)
);

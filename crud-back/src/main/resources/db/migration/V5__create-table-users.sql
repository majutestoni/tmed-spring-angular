CREATE TABLE users(
    id bigint not null AUTO_INCREMENT,
    username varchar(100) not null,
    password varchar(200) not null,
    primary key(id)
);

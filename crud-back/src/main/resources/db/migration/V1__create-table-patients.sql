CREATE TABLE patients(
    id bigint not null AUTO_INCREMENT,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    uf char(2) not null,
    cidade varchar(100) not null,
    primary key(id)
);


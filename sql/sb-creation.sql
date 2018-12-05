DROP TABLE users;
CREATE TABLE users(CPF BIGINT not null primary key,
nome varchar(200) not null,
login varchar(20) not null,
passwordHash BIGINT not null);

DROP TABLE reservations;
CREATE TABLE reservations(
id BIGINT not null primary key GENERATED ALWAYS AS IDENTTTY
(START WITH 1, INCREMENT BY 1),
timestamp TIMESTAMP not null,
date varchar(200) not null);

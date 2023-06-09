create table usuario
(
    id integer AUTO_INCREMENT  not null,
    login varchar(255) not null,
    nome varchar(255) not null,
    senha varchar(255) not null,
    primary key(id)
);


create table plano
(
    id integer AUTO_INCREMENT not null,
    nome varchar(255) not null,
    valor decimal(10,2) not null,
    primary key(id)
);

create table beneficiario
(
    id integer AUTO_INCREMENT not null,
    nome varchar(255) not null,
    cpf varchar(255) not null,
    email varchar(255) not null,
    idade integer not null,
    plano_id integer,
    primary key(id),
        CONSTRAINT fk_plano_id FOREIGN KEY (plano_id) REFERENCES plano(id)
);

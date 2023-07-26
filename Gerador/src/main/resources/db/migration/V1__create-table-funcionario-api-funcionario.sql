CREATE TABLE tb_funcionarios
(
    id           bigint(20) not null AUTO_INCREMENT,
    numero_funcionario bigint(20),
    nome         varchar(255) not null,
    cpf          varchar(11)  not null,
    rg          varchar(10)  not null,
    email        varchar(150) not null,
    ddd          varchar(3)   not null,
    telefone     varchar(10)  not null,
    situacao     varchar(9)   not null,
    estado_civil varchar(10)  not null,

    primary key(id)
);
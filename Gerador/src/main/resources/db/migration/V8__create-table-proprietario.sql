CREATE TABLE tb_proprietario
(
    id                bigint(20) not null AUTO_INCREMENT,
    uuid_proprietario VARCHAR(100) not null,
    nome              VARCHAR(150) not null,
    cpf               VARCHAR(11)  not null,
    rg                VARCHAR(10)  not null,
    data_nascimento   DATE         not null,
    ddd_pais          VARCHAR(60)  not null,
    ddd               VARCHAR(3)   not null,
    telefone          VARCHAR(9)   not null,
    sexo              VARCHAR(12)  not null,

    PRIMARY KEY (id)
);
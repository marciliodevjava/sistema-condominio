CREATE TABLE tb_enderecos
(
    id           bigint(20) not null AUTO_INCREMENT,
    cep        varchar(8) not null,
    logradouro          varchar(255)  not null,
    numero          varchar(10)   not null,
    bairro     varchar(100),
    cidade     varchar(100)  not null,
    uf     varchar(15)  not null,
    pais     varchar(161)  not null,
    id_funcionario bigint(20),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES tb_funcionarios(id)
);
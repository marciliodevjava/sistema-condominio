CREATE TABLE tb_dependentes
(
    id                 bigint(20)   not null AUTO_INCREMENT,
    uuid_identificador varchar(36)  not null,
    grau_parentesco    varchar(13)  not null,
    nome               varchar(150) not null,
    data_nascimento    date,
    cpf                varchar(11)  not null,
    rg                 varchar(10)  not null,
    ddd                varchar(3),
    telefone           varchar(10)  not null,
    id_funcionario     bigint(20),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES tb_funcionarios (id)
);
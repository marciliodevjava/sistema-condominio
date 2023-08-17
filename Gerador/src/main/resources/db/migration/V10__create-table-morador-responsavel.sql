CREATE TABLE tb_morador_responsavel
(
    id              BIGINT(20) not null AUTO_INCREMENT,
    uuid_morador    VARCHAR(100) not null,
    nome            VARCHAR(150) not null,
    cpf             VARCHAR(11)  not null,
    rg              VARCHAR(10)  not null,
    data_nascimento DATE         not null,
    ddd_pais        VARCHAR(5)   not null,
    ddd             VARCHAR(3)   not null,
    telefone        VARCHAR(9)   not null,
    sexo            VARCHAR(12)  not null,
    id_apartamento  BIGINT(20) not null,

    PRIMARY KEY (id),
    FOREIGN KEY (id_apartamento) REFERENCES tb_apartamentos (id)
);
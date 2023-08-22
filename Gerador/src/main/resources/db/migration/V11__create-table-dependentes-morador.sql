CREATE TABLE tb_dependentes_morador
(
    id              BIGINT(20) not null AUTO_INCREMENT,
    uuid_dependente VARCHAR(100) not null,
    nome            VARCHAR(150) not null,
    cpf             VARCHAR(11)  not null,
    rg              VARCHAR(10),
    data_nascimento DATE         not null,
    ddd_pais        VARCHAR(7)   not null,
    ddd             VARCHAR(3)   not null,
    telefone        VARCHAR(9)   not null,
    sexo            VARCHAR(12)  not null,
    id_morador_responsavel      BIGINT(20),

    PRIMARY KEY (id),
    FOREIGN KEY (id_morador_responsavel) REFERENCES tb_morador_responsavel (id)
);
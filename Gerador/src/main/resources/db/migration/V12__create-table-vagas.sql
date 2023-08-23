CREATE TABLE tb_vagas
(
    id             BIGINT(20) not null AUTO_INCREMENT,
    uuid_vagas     VARCHAR(100) not null,
    numero         VARCHAR(150) not null,
    setor          VARCHAR(11)  not null,
    tipo           VARCHAR(10)  not null,
    id_morador_responsavel      BIGINT(20),

    PRIMARY KEY (id),
    FOREIGN KEY (id_morador_responsavel) REFERENCES tb_morador_responsavel (id)
);
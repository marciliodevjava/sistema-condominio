CREATE TABLE tb_apartamentos
(
    id               bigint(20) not null AUTO_INCREMENT,
    uuid_apartamento VARCHAR(100) not null,
    numero           INTEGER(5) not null,
    bloco            VARCHAR(7)   not null,
    rg               VARCHAR(10)  not null,
    andar            VARCHAR(7)   not null,
    id_proprietario  BIGINT(20) not null,

    PRIMARY KEY (id),
    FOREIGN KEY (id_proprietario) REFERENCES tb_proprietario(id)

);
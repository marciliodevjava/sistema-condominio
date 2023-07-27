CREATE TABLE tb_matricula_funcionarios
(
    id                 bigint(20) not null AUTO_INCREMENT,
    uuid_identificador varchar(36) not null,
    numero_funcionario bigint(20),
    data               date,
    hora               time,
    ativo              varchar(7),
    id_funcionario     bigint(20),

    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES tb_funcionarios (id)
);
CREATE TABLE tb_usuarios
(
    id                 bigint(20) not null AUTO_INCREMENT,
    nome               varchar(255) not null,
    login_usuario      varchar(50)  not null,
    senha_usuario      varchar(100)  not null,
    uuid_identificador varchar(36)  not null,
    data               date         not null,
    hora               time         not null,
    PRIMARY KEY (id)
);
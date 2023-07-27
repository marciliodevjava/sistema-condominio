CREATE TABLE tb_uuid
(
    id      bigint(20) not null AUTO_INCREMENT,
    uuid_gerador    varchar(36) not null,
    data    date        not null,
    hora    time        not null,
    projeto varchar(50) not null,

    PRIMARY KEY (id)
);
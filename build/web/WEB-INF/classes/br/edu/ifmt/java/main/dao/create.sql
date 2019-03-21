CREATE TABLE login (
    id    INTEGER       PRIMARY KEY AUTOINCREMENT
                        NOT NULL,
    email VARCHAR (255) UNIQUE
                        NOT NULL,
    senha VARCHAR (255) NOT NULL,
    nome  VARCHAR (255) NOT NULL
);

CREATE TABLE [obra_de_arte] (
    id          INTEGER       PRIMARY KEY AUTOINCREMENT
                              NOT NULL
                              UNIQUE,
    titulo      VARCHAR (255) NOT NULL,
    autor       VARCHAR (255) NOT NULL,
    data        DATETIME      NOT NULL
                              DEFAULT (now() ),
    tipo        VARCHAR (255) NOT NULL
                              DEFAULT vz,
    procedencia VARCHAR (255) NOT NULL
                              DEFAULT vz,
    tecnica     VARCHAR (255) NOT NULL
                              DEFAULT vz
);

CREATE TABLE opcoes (
    id        INTEGER       PRIMARY KEY AUTOINCREMENT,
    descricao VARCHAR (255) UNIQUE
                            NOT NULL
);
/* RTdb-logico: */

CREATE TABLE jornada_trabalho (
    turno VARCHAR(5),
    carga_horaria VARCHAR(1),
    id INTEGER PRIMARY KEY,
    seg BOOLEAN,
    ter BOOLEAN,
    qua BOOLEAN,
    qui BOOLEAN,
    sex BOOLEAN,
    sab BOOLEAN,
    dom BOOLEAN,
    fk_funcionarios_cpf VARCHAR(11)
);

CREATE TABLE veiculos (
    placa VARCHAR(6),
    marca_rastreador VARCHAR(10),
    versao_rastreador VARCHAR(10),
    id_rastreador INTEGER PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(11)
);

CREATE TABLE status (
    tipo VARCHAR(10),
    inicio TIMESTAMP,
    fim TIMESTAMP,
    total INTERVAL,
    id INTEGER PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(11),
    fk_viagens_id INTEGER
);

CREATE TABLE filiais (
    cidade VARCHAR(60),
    id INTEGER PRIMARY KEY,
    estado VARCHAR(2),
    nome VARCHAR(70)
);

CREATE TABLE funcionarios (
    cpf VARCHAR(11) PRIMARY KEY,
    senha VARCHAR(124),
    nome VARCHAR(60),
    cargo VARCHAR(10),
    fk_filiais_id INTEGER
);

CREATE TABLE viagens (
    total INTERVAL,
    final TIMESTAMP,
    inicio TIMESTAMP,
    id INTEGER PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(11),
    fk_veiculos_id_rastreador INTEGER
);
 
ALTER TABLE jornada_trabalho ADD CONSTRAINT FK_jornada_trabalho_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE CASCADE;
 
ALTER TABLE veiculos ADD CONSTRAINT FK_veiculos_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE status ADD CONSTRAINT FK_status_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE status ADD CONSTRAINT FK_status_3
    FOREIGN KEY (fk_viagens_id)
    REFERENCES viagens (id)
    ON DELETE RESTRICT;
 
ALTER TABLE funcionarios ADD CONSTRAINT FK_funcionarios_2
    FOREIGN KEY (fk_filiais_id)
    REFERENCES filiais (id)
    ON DELETE RESTRICT;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_3
    FOREIGN KEY (fk_veiculos_id_rastreador)
    REFERENCES veiculos (id_rastreador)
    ON DELETE RESTRICT;
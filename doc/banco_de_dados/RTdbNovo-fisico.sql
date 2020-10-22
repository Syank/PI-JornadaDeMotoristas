/* RTdbNovo-logico: */

CREATE TABLE filiais (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    cnpj VARCHAR(15),
    cidade VARCHAR(30),
    estado VARCHAR(2),
    rntrc VARCHAR(8)
);

CREATE TABLE funcionarios_filiais (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(50),
    cargo VARCHAR(13),
    email VARCHAR(50),
    senha VARCHAR(32),
    fk_filiais_id SERIAL
);

CREATE TABLE motoristas (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(50),
    cnh VARCHAR(11),
    dom BOOLEAN,
    seg BOOLEAN,
    ter BOOLEAN,
    qua BOOLEAN,
    qui BOOLEAN,
    sab BOOLEAN,
    cargahoraria VARCHAR(4),
    salario VARCHAR(10),
    sex BOOLEAN,
    email VARCHAR(50),
    senha VARCHAR(32),
    dia_atual VARCHAR(2),
    trabalhado_hoje VARCHAR(5),
    descansado_hoje VARCHAR(5),
    alimentacao_hoje VARCHAR(5),
    fk_filiais_id SERIAL
);

CREATE TABLE avisos (
    id SERIAL PRIMARY KEY,
    mensagem TEXT,
    data DATE,
    resolvido BOOLEAN,
    nomenclatura VARCHAR(15),
    fk_motoristas_cpf VARCHAR(11)
);

CREATE TABLE veiculos (
    placa VARCHAR(8) PRIMARY KEY,
    id_rastreador VARCHAR(20),
    marca_rastreador VARCHAR(20),
    modelo_rastreador VARCHAR(20),
    modelo_veiculo VARCHAR(20),
    fk_filiais_id SERIAL
);

CREATE TABLE viagens (
    id SERIAL PRIMARY KEY,
    destino VARCHAR(30),
    carga VARCHAR(20),
    inicio TIMESTAMP,
    fim TIMESTAMP,
    prazo TIMESTAMP,
    fk_veiculos_placa VARCHAR(8),
    fk_motoristas_cpf VARCHAR(11)
);

CREATE TABLE status (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(20),
    inicio TIMESTAMP,
    fim TIMESTAMP,
    total TIMESTAMP,
    fk_motoristas_cpf VARCHAR(11)
);
 
ALTER TABLE funcionarios_filiais ADD CONSTRAINT FK_funcionarios_filiais_2
    FOREIGN KEY (fk_filiais_id)
    REFERENCES filiais (id)
    ON DELETE RESTRICT;
 
ALTER TABLE motoristas ADD CONSTRAINT FK_motoristas_2
    FOREIGN KEY (fk_filiais_id)
    REFERENCES filiais (id)
    ON DELETE RESTRICT;
 
ALTER TABLE avisos ADD CONSTRAINT FK_avisos_2
    FOREIGN KEY (fk_motoristas_cpf)
    REFERENCES motoristas (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE veiculos ADD CONSTRAINT FK_veiculos_2
    FOREIGN KEY (fk_filiais_id)
    REFERENCES filiais (id)
    ON DELETE RESTRICT;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_2
    FOREIGN KEY (fk_veiculos_placa)
    REFERENCES veiculos (placa)
    ON DELETE RESTRICT;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_3
    FOREIGN KEY (fk_motoristas_cpf)
    REFERENCES motoristas (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE status ADD CONSTRAINT FK_status_2
    FOREIGN KEY (fk_motoristas_cpf)
    REFERENCES motoristas (cpf)
    ON DELETE RESTRICT;
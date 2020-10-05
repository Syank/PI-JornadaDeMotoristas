/* Lógico_1: */

CREATE TABLE funcionarios (
    cpf varchar(20) PRIMARY KEY,
    cargo varchar(20),
    email varchar(50),
    senha varchar(128),
    fk_filiais_id serial
);

CREATE TABLE filiais (
    id serial PRIMARY KEY,
    nome varchar(50),
    cidade varchar(50),
    estado varchar(5)
);

CREATE TABLE veiculos (
    placa varchar(10) PRIMARY KEY,
    modelo varchar(50),
    idRastreador int,
    marcaRastreador varchar(50),
    fk_filiais_id serial
);

CREATE TABLE avisos (
    id serial PRIMARY KEY,
    tipo varchar(20),
    funcionarioDestino varchar(20),
    visualizado boolean,
    mensagem text,
    fk_funcionarios_cpf varchar(20)
);

CREATE TABLE status (
    id serial PRIMARY KEY,
    tipo varchar(20),
    tempoInicio TIMESTAMP,
    tempoFim TIMESTAMP,
    tempoTotal TIMESTAMP,
    fk_motoristas_cpf varchar(20)
);

CREATE TABLE viagens (
    id serial PRIMARY KEY,
    funcionario varchar(20),
    veiculo varchar(50),
    destino varchar(50),
    carga varchar(50),
    tempoTotal TIMESTAMP,
    prazo DATE,
    fk_motoristas_cpf varchar(20),
    fk_veiculos_placa varchar(10)
);

CREATE TABLE motoristas (
    cpf varchar(20) PRIMARY KEY,
    nome varchar(50),
    cnh varchar(20),
    RNTRC varchar(20),
    expediente varchar(20),
    salario varchar(20),
    fk_funcionarios_cpf varchar(20)
);

CREATE TABLE supervisores (
    cpf varchar(20) PRIMARY KEY,
    nome varchar(50),
    expediente varchar(20),
    fk_funcionarios_cpf varchar(20)
);

CREATE TABLE administradores (
    cpf varchar(20) PRIMARY KEY,
    nome varchar(50),
    expediente varchar(20),
    fk_funcionarios_cpf varchar(20)
);
 
ALTER TABLE funcionarios ADD CONSTRAINT FK_funcionarios_2
    FOREIGN KEY (fk_filiais_id)
    REFERENCES filiais (id)
    ON DELETE RESTRICT;
 
ALTER TABLE veiculos ADD CONSTRAINT FK_veiculos_2
    FOREIGN KEY (fk_filiais_id)
    REFERENCES filiais (id)
    ON DELETE RESTRICT;
 
ALTER TABLE avisos ADD CONSTRAINT FK_avisos_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE status ADD CONSTRAINT FK_status_2
    FOREIGN KEY (fk_motoristas_cpf)
    REFERENCES motoristas (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_2
    FOREIGN KEY (fk_motoristas_cpf)
    REFERENCES motoristas (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE viagens ADD CONSTRAINT FK_viagens_3
    FOREIGN KEY (fk_veiculos_placa)
    REFERENCES veiculos (placa)
    ON DELETE RESTRICT;
 
ALTER TABLE motoristas ADD CONSTRAINT FK_motoristas_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE supervisores ADD CONSTRAINT FK_supervisores_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE administradores ADD CONSTRAINT FK_administradores_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;
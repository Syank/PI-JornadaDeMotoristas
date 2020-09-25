# RoadTracker :truck::computer:
Seja bem vindo ao repositório do RoadTracker!

## O que é o RoadTracker?
Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho dos motoristas de caminhão, pois muitas vezes não há o controle sobre o expediente desses trabalhadores. Todas as filiais de uma empresa podem se cadastrar e realizar o cadastro de seus motoristas e, consequentemente, realizar o cadastro das jornadas de trabalho deles, o veículo que será utilizado e a viagem a ser realizada. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!

## Integrantes da equipe
- [Rafael Furtado Rodrigues dos Santos](https://www.linkedin.com/in/rafael-furtado-613a9712a/ "Rafael's LinkedIn") (Scrum Master)

- [Bárbara dos Santos Port](https://www.linkedin.com/in/b%C3%A1rbara-port-402158198/ "Bárbara's LinkedIn") (Product Owner)

- [Ana Clara Ferreira de Godoy](https://www.linkedin.com/in/ana-clara-godoy-2973381b2/ "Ana Clara's LinkedIn") (Development Team)

- [Giovanni dos Santos Alves](https://www.linkedin.com/in/giovanni-santos-546412154/ "Giovanni's LinkedIn") (Development Team)

- [Ana Carolina da Silva Lima](https://www.linkedin.com/in/ana-carolina-lima-099955136/ "Ana Carolina's LinkedIn") (Development Team)

- [Anna Yukimi Yamada](https://www.linkedin.com/in/anna-yukimi-yamada-6ba23b149/ "Anna's LinkedIn") (Development Team)

## *User stories* do nosso sistema
![user stories entrega 1 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/1.png?raw=true)
![user stories entrega 2 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/2.png?raw=true)
![user stories entrega 3 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/3.png?raw=true)
![user stories entrega 4 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/4.png?raw=true)

## *Wireframes* do RoadTracker
![tela de login roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/login.jpeg?raw=true)
![tela de boas vindas roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/boas_vindas.jpeg?raw=true)
![tela de cadastro do funcionário roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/cadastro_funcionario.jpeg?raw=true)
![tela de usuario cadastrado roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/aviso_funcionario_cadastrdo.jpeg?raw=true)
![tela de falha no cadastro roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/aviso_falha_cadastro.jpeg?raw=true)
![tela de listagem de funcionários roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/listagem_funcionarios.jpeg?raw=true)
![tela de informações do funcionário roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/informações_funcionario.jpeg?raw=true)
![tela de usuário excluído roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/aviso_usuario_excluido.jpeg?raw=true)
![tela de dados alterados roadtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/aviso_dados_alterados.jpeg?raw=true)

## Modelo conceitual do nosso banco de dados
![conceitual rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/banco_de_dados/RTdb-conceitual.png?raw=true)

## Modelo lógico do nosso banco de dados
![lógico rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/banco_de_dados/RTdb-logico.png?raw=true)

## Modelo físico do nosso banco de dados
~~~SQL

CREATE TABLE filiais (
    cidade VARCHAR(30),
    id SERIAL PRIMARY KEY,
    estado VARCHAR(2),
    nome VARCHAR(30)
);

CREATE TABLE funcionarios (
    cargo VARCHAR(13),
    senha VARCHAR(256),
    cpf VARCHAR(13) PRIMARY KEY,
    dom BOOLEAN,
    sab BOOLEAN,
    sex BOOLEAN,
    qui BOOLEAN,
    ter BOOLEAN,
    cargahoraria VARCHAR(2),
    seg BOOLEAN,
    nome VARCHAR(60),
    qua BOOLEAN,
    fk_filiais_id SERIAL
);

CREATE TABLE veiculos (
    placa VARCHAR(8),
    versao_rastreador VARCHAR(30),
    id_rastreador VARCHAR(30) PRIMARY KEY,
    marca_rastreador VARCHAR(30),
    fk_funcionarios_cpf VARCHAR(13)
);

CREATE TABLE viagens (
    total TIME,
    fim DATETIME,
    inicio DATETIME,
    id SERIAL PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(13),
    fk_veiculos_id_rastreador VARCHAR(30)
);

CREATE TABLE status (
    tipo VARCHAR(13),
    inicio DATETIME,
    fim DATETIME,
    total TIME,
    id SERIAL PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(13),
    fk_viagens_id SERIAL
);
 
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

~~~

## Versões das bibliotecas utilizadas por nós
- JavaFX: 14.0.2.1
- JDK: 14.0.2.1
- Hibernate: 5.4.21
- PostgreSQL JDBC: 42.2.16

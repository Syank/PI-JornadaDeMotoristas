# RoadTracker :truck::computer:
Seja bem vindo ao repositório do RoadTracker!

## O nosso desafio 
Nosso cliente é a empresa IACIT e nos foi solicitado para desenvolver um sistema de gerenciamento de controle de jornada de trabalho de motoristas de forma parametrizável visando a disponibilização de funcionalidades de planejamento, acompanhamento e controle da jornada de trabalho destes trabalhadores. Nosso sistema deverá oferecer cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro), cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, tempo de espera, tempo de refeição e tempo de descanso).

## O que é o RoadTracker?
Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois muitas vezes não há o controle sobre o expediente desses trabalhadores. Todas as filiais de uma empresa ser cadastradas e realizar o cadastro de seus motoristas e, consequentemente, realizar o cadastro das jornadas de trabalho deles, o veículo que será utilizado e a viagem a ser realizada. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!

## Integrantes da equipe :girl::boy:
- [Rafael Furtado Rodrigues dos Santos](https://www.linkedin.com/in/rafael-furtado-613a9712a/ "Rafael's LinkedIn") (Scrum Master)

- [Bárbara dos Santos Port](https://www.linkedin.com/in/b%C3%A1rbara-port-402158198/ "Bárbara's LinkedIn") (Product Owner)

- [Ana Clara Ferreira de Godoy](https://www.linkedin.com/in/ana-clara-godoy-2973381b2/ "Ana Clara's LinkedIn") (Development Team)

- [Giovanni dos Santos Alves](https://www.linkedin.com/in/giovanni-santos-546412154/ "Giovanni's LinkedIn") (Development Team)

- [Ana Carolina da Silva Lima](https://www.linkedin.com/in/ana-carolina-lima-099955136/ "Ana Carolina's LinkedIn") (Development Team)

- [Anna Yukimi Yamada](https://www.linkedin.com/in/anna-yukimi-yamada-6ba23b149/ "Anna's LinkedIn") (Development Team)

## *User stories* do nosso sistema
### Primeira entrega :clock12:
A nossa primeira entrega contará com um CRUD dos funcionários das filais, que poderão ter os cargos de administrador, supervisor e motoristas. Sendo assim as filiais já poderão ter controle dos funcionários que estarão cadastrados e já poderão ter uma visão melhor sobre as jornadas de trabalho de cada funcionário.
![user stories entrega 1 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/1.png?raw=true)

### Segunda entrega :clock4:
Na segunda entrega já será possível o cadastro de filiais, de veículos e viagens. Isso já possibilita o controle dos veículos e as viagens realizadas, proporcionando a escalabilidade de boa parte do sistema.
![user stories entrega 2 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/2.png?raw=true)

### Terceira entrega :clock8:
Acerca da terceira entrega o motorista cadastrar os status em que ele se encontra (como descanso, espera, alimentação e abastecimento), podendo informar a todos da sua filial sobre qual o seu estado. Essa é uma das principais funcionalidades do sistema, porém depende de outra: cadastro das viagens. Sem uma viagem o motorista não poderá emitir status.
![user stories entrega 3 rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/user_stories/3.png?raw=true)

### Quarta entrega :clock12:
Finalmente, diante da quarta e última entrega, todos os usuários poderão recuperar a sua senha caso seja necessário. Haverá um perfil para supervisores, que poderão desempenhar algumas funções dos administradores (o que ajuda na agilidade dos processos). Além disso os funcionários poderão enviar avisos a outros funcionários, caso haja algum assunto importante a ser tratado ou caso ocorra alguma emergência.
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

CREATE DATABASE rtracker;

CREATE TABLE filiais (
    cidade VARCHAR(50),
    id SERIAL PRIMARY KEY,
    estado VARCHAR(2),
    nome VARCHAR(50)
);

CREATE TABLE funcionarios (
    cargo VARCHAR(20),
    senha VARCHAR(64),
    cpf VARCHAR(11) PRIMARY KEY,
    dom BOOLEAN,
    sab BOOLEAN,
    sex BOOLEAN,
    qui BOOLEAN,
    ter BOOLEAN,
    cargahoraria VARCHAR(3),
    seg BOOLEAN,
    nome VARCHAR(50),
    qua BOOLEAN,
    turno VARCHAR(10),
    fk_filiais_id SERIAL
);

CREATE TABLE veiculos (
    placa VARCHAR(10),
    versao_rastreador VARCHAR(20),
    id_rastreador VARCHAR(30) PRIMARY KEY,
    marca_rastreador VARCHAR(20),
    fk_funcionarios_cpf VARCHAR(11)
);

CREATE TABLE status (
    tipo VARCHAR(20),
    inicio DATETIME,
    fim DATETIME,
    total TIMESTAMP,
    id SERIAL PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(11),
    fk_viagens_id SERIAL
);

CREATE TABLE viagens (
    total TIMESTAMP,
    fim DATETIME,
    inicio DATETIME,
    id SERIAL PRIMARY KEY,
    fk_funcionarios_cpf VARCHAR(11),
    fk_veiculos_id_rastreador VARCHAR(30)
);

CREATE TABLE avisos (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(20),
    funcionario_destino VARCHAR(11),
    mensagem TEXT,
    visualizado BOOLEAN,
    fk_funcionarios_cpf VARCHAR(11)
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
 
ALTER TABLE avisos ADD CONSTRAINT FK_avisos_2
    FOREIGN KEY (fk_funcionarios_cpf)
    REFERENCES funcionarios (cpf)
    ON DELETE RESTRICT;

~~~

## Versões das bibliotecas utilizadas por nós
- JavaFX: 14.0.2.1
- JDK: 14.0.2.1
- Hibernate: 5.4.21
- PostgreSQL JDBC: 42.2.16

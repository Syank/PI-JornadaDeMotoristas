# RoadTracker :truck::computer:
Seja bem vindo à branch da primeira entrega do RoadTracker!

## O nosso desafio 
Nosso cliente é a empresa IACIT e nos foi solicitado para desenvolver um sistema de gerenciamento de controle de jornada de trabalho de motoristas de forma parametrizável visando a disponibilização de funcionalidades de planejamento, acompanhamento e controle da jornada de trabalho destes trabalhadores. Nosso sistema deverá oferecer cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro), cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, tempo de espera, tempo de refeição e tempo de descanso).

## O que é o RoadTracker?
Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois muitas vezes não há o controle sobre o expediente desses trabalhadores. Todas as filiais de uma empresa ser cadastradas e realizar o cadastro de seus motoristas e, consequentemente, realizar o cadastro das jornadas de trabalho deles, o veículo que será utilizado e a viagem a ser realizada. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!

## *Card* da primeira entrega do nosso sistema
### O que entregamos
Entregamos um CRUD, feito para administrador, envolvendo todos os tipos de funcionários do sistema (administrador, supervisor e motorista). O administrador poderá cadastrar motoristas, supervisores e outros administradores, porém ainda não é possível solicitar cadastros (os supervisores deverão solicitar o cadastro de algum outro funcionário, se necessário). Assim que o administrador cadastra um novo funcionário é possível visualizar uma lista com todos os funcionários presentes no sistema. O usuário poderá selecionar um dos funcionários e entrar numa página que exibirá as informações do funcionário escolhido, sendo possível alterá-las (e quando no modo edição é possível descartar essas alterações) ou excluir o funcionário do sistema.
### Por que fizemos essa escolha?
Os funcionários são os principais agentes do sistema e dentre eles principalmente o motorista. Sendo assim vimos a oportunidade de impressionar aqueles que estivessem utilizando o sistema proporcionando a organização dos funcionários das filiais em um único local, a disponibilização dos dados destes funcionários para melhor conhecimento de todos que estão presentes na filial e o controle dos dados de cada funcionário para que as informações possam ser atualizadas a qualquer momento de forma rápida e simplificada. Entregamos os 4 primeiros *cards*, logo, temos 4 *cards* entregues de um total de 32 *cards*.
### Quais são as partes mais trabalhosas?
As partes mais trabalhosas e que precisam de mais tempo são as telas de cadastrar usuários e de alterar usuários, pois, como já estarão integradas ao *back-end* precisarão de todos os campos necessários para enviar ao banco de dados e precisarão de várias validações para enviar dados persistentes ao banco. A tela de listagem é menos trabalhosa, pois não exige muitas validações. Para excluir um funcionário o processo também não é muito trabalhoso, pois desde que o usuário esteja selecionado é possível excluí-lo pela sua identificação.

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/Card%20Sprint%200.jpeg" width="500" height="280"/>

## Nosso sistema em funcionamento na primeira entrega
![GIF sistema](https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/Sistema%20Sprint%200.gif)

## *User stories* do nosso sistema
### Primeira entrega :clock12:
<div>
A nossa primeira entrega contará com um CRUD dos funcionários das filais, que poderão ter os cargos de administrador, supervisor e motoristas. Sendo assim as filiais já poderão ter controle dos funcionários que estarão cadastrados.
</div>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/user_stories/1.png" width="600px"/>

## *Wireframes* da primeira entrega do RoadTracker 
<div align="center">
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/login.jpeg" width="400" height="250" hspace="5"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/boas_vindas.jpeg" width="400" height="250" hspace="5"/>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/cadastro_funcionario.jpeg" width="400" height="250" hspace="5"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/aviso_funcionario_cadastrdo.jpeg" width="400" height="250" hspace="5"/>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/aviso_falha_cadastro.jpeg" width="400" height="250" hspace="5"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/listagem_funcionarios.jpeg" width="400" height="250" hspace="5"/>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/informações_funcionario.jpeg" width="400" height="250" hspace="5"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/aviso_usuario_excluido.jpeg" width="400" height="250" hspace="5"/>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/wireframes/aviso_dados_alterados.jpeg" width="400" height="250" hspace="5"/>
</div>

## Modelo conceitual do nosso banco de dados
![conceitual rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/banco_de_dados/RTdb-conceitual.png?raw=true)

## Modelo lógico do nosso banco de dados
![lógico rtracker](https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/banco_de_dados/RTdb-logico.png?raw=true)

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

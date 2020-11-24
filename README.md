<html>
<head>
       <p><img src="https://img.shields.io/badge/status%20do%20projeto-em%20progresso-yellow?style=for-the-badge&logo=appveyor"></p>
       <p><img src="https://img.shields.io/badge/Sprint%20atual-Sprint%200-blue?style=for-the-badge&logo=appveyor"></p>
       <p>
       <img src="https://img.shields.io/badge/dependências-JavaFX%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-JDK%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-Hibernate%3A%205.4.21-green">
       <img src="https://img.shields.io/badge/dependências-PostgreSQL%20JDBC%3A%2042.2.16-green">
       </p>
</head>
<body>
    <h1>RoadTracker :truck::computer:</h1>
    <p>Seja bem-vindo à branch da primeira entrega do RoadTracker!</p>

## O nosso desafio
<p align="justify">Nosso cliente é a empresa IACIT. Foi solicitado para nós desenvolvermos um sistema para o gerenciamento e controle da jornada de trabalho de motoristas sendo parametrizável, visando à disponibilização de funcionalidades de planejamento, acompanhamento, controlando a jornada de trabalho de cada um desses colaboradores. Nosso sistema deverá oferecer um cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), a escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro) e um cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, espera, refeição e descanso).</p>
</body>

## O que é o RoadTracker?
<p align="justify">Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois, muitas vezes, não há o monitoramento e acompanhamento necessário do expediente desses trabalhadores. Todas as filiais de uma empresa devem ser cadastradas, assim como seus motoristas e suas respectivas jornadas de trabalho, viagens a serem realizadas e o veículo que será utilizado em cada uma dessas viagens. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!</p>

## *Card* da primeira entrega do nosso sistema
### O que entregamos :white_check_mark:
<p align="justify">Entregamos um CRUD, feito para administrador, envolvendo todos os tipos de funcionários do sistema (administrador, supervisor e motorista). Ele poderá cadastrar motoristas, supervisores e outros administradores, porém ainda não é possível solicitar cadastros (os supervisores deverão solicitar o cadastro de algum outro funcionário, se necessário). Assim que um novo funcionário é cadastrado é possível visualizar uma lista com todos os funcionários presentes no sistema. O usuário poderá selecionar um destes e entrar numa página que exibirá as informações do qual foi escolhido, sendo possível alterá-las (e quando no modo edição é possível descartar essas alterações) ou excluí-lo do sistema.</p>
<h3>Por que fizemos essa escolha? :grey_question:</h3>
<p align="justify">Os funcionários são os principais agentes do sistema e dentre eles principalmente o motorista. Devido a isso vimos a oportunidade de impressionar aqueles que estivessem utilizando o sistema ao proporcionar a organização de todos os funcionários das filiais em um único local, a disponibilização dos dados destes para melhor conhecimento de todos que estão presentes e o controle dos dados de cada um para que as informações possam ser atualizadas a qualquer momento de forma rápida e simplificada. Entregamos os 4 primeiros <i>cards</i>, logo, temos 4 <i>cards</i> entregues de um total de 35.</p>
<h3>Quais são as partes mais trabalhosas? :question:</h3>
<p align="justify">As partes mais trabalhosas e que precisam de mais tempo são as telas de cadastrar e alterar dados de usuários, pois, como já estarão integradas ao <i>back-end</i> precisarão de todos os campos necessários e de várias validações para enviar dados persistentes ao banco de dados. A tela de listagem é menos trabalhosa, pois não exige muitas validações. Consequentemente, para excluir um funcionário o processo, também, não é muito trabalhoso, pois desde ele esteja selecionado é possível excluí-lo pela sua identificação. Como um todo a nossa primeira entrega foi difícil, porque decidimos que entregaríamos o <i>software funcionando</i>. Logo, precisávamos de tempo para configurar as dependências do projeto e dar os primeiros passos com o Hibernate (tecnologia que nenhum dos nós tinha utilizado antes).</p>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/Card%20Sprint%200.jpeg" width="500" height="280"/>

## Nosso sistema em funcionamento na primeira entrega
![GIF sistema](https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_0/doc/Sistema%20Sprint%200.gif)

## *User stories* do nosso sistema
### Primeira entrega :clock12:
<div>
<p align="justify">A nossa primeira entrega contará com um CRUD dos funcionários das filiais, que poderão ter os cargos de administrador, supervisor e motoristas. Sendo assim, elas já poderão ter controle de todos aqueles que estarão cadastrados.</p>
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
</body>
</html>

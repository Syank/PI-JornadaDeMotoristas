<head>
       <p><img src="https://img.shields.io/badge/status%20do%20projeto-em%20progresso-yellow?style=for-the-badge&logo=appveyor"></p>
       <p><img src="https://img.shields.io/badge/Sprint%20atual-Sprint%201-blue?style=for-the-badge&logo=appveyor"></p>
       <p>
       <img src="https://img.shields.io/badge/dependências-JavaFX%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-JDK%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-Hibernate%3A%205.4.21-green">
       <img src="https://img.shields.io/badge/dependências-PostgreSQL%20JDBC%3A%2042.2.16-green">
       </p>
         
</head>
<body>
       <h1>RoadTracker :truck::computer:</h1>
       <p>Seja bem vindo à branch da segunda entrega do RoadTracker!</p>

<h2>O nosso desafio</h2>
<p>Nosso cliente é a empresa IACIT e nos foi solicitado para desenvolver um sistema de gerenciamento de controle de jornada de trabalho de motoristas de forma parametrizável visando a disponibilização de funcionalidades de planejamento, acompanhamento e controle da jornada de trabalho destes trabalhadores. Nosso sistema deverá oferecer cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro), cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, tempo de espera, tempo de refeição e tempo de descanso).</p>

<h2>O que é o RoadTracker?</h2>
<p>Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois muitas vezes não há o controle sobre o expediente desses trabalhadores. Todas as filiais de uma empresa ser cadastradas e realizar o cadastro de seus motoristas e, consequentemente, realizar o cadastro das jornadas de trabalho deles, o veículo que será utilizado e a viagem a ser realizada. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!</p>

<h2>Card da segunda entrega do nosso sistema</h2>
       <h3>O que entregamos :white_check_mark: </h3>
<p>A partir da primeira Sprint (Sprint 0), configuramos todo o ambiente de trabalho e dependências que o projeto necessita, e um CRUD básico dos funcionários havia sido elaborado. Agora, para a Sprint 1, optamos por finalizar os métodos de CRUD que o perfil do administrador tem, corrigimos pequenos bugs que este perfil tinha e implementamos funcionalidades interessantes que certamente trazem uma experiência de uso melhor aos usuários.</p>
       <h3>Por que fizemos essa escolha? :grey_question: </h3>
<p>O projeto pode ser basicamente separado em três partes, de acordo com os perfis de acesso, sendo eles Motorista, Supervisor e Administrador. Como a entrega anterior já era dentro do perfil do Administrador, optamos, para a Sprint 1, por finalizar todas as funcionalidades que o perfil tem, assim o usuário já pode ter uma experiência de uso mais concreta do nosso programa, podendo cadastrar todas as entidades, acessar suas informações, edita-las ou apaga-las, se assim desejar.</p>
       <h3>Quais são as partes mais trabalhosas? :question: </h3>
<p>As partes mais trabalhosas foram as correções que se mostrarem serem necessárias realizar no sistema do banco de dados, de como as entidades se relacionam entre si e adaptar essas mudanças ao código Java.</p>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/Cards/card2.png" width="500" height="280"/>

<h2>Nosso sistema em funcionamento na segunda entrega</h2>


<h2>User stories do nosso sistema</h2>
<h3>Segunda entrega :clock12:</h3>
<p>A nossa segunda entrega será focada no término do perfil do administrador, ou seja, haverá o cadastro de viagens, filiais e veículos além da leitura de avisos enviados pelos motoristas. Os usuários passarão a necessitar de um cadastro para acessar o sistema, ou seja, o login funcionará.</p>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/user_stories/2.png" width="600px"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/user_stories/2-2.png" width="600px"/>

<h2>Wireframes da segunda entrega do RoadTracker</h2>
<div align="center">

</div>

<section id="ModeloC">
        <h3>Modelo conceitual do nosso banco de dados</h3>
        <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/banco_de_dados/RTdbNovo-conceitual.png?raw=true" width="800px">
    
</section>

<section id="ModeloL">
        <h3>Modelo lógico do nosso banco de dados</h3>
        <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/banco_de_dados/RTdbNovo-logico.png?raw=true" width="800px">

</section>
<section id="ModeloF">
        <h3>Modelo físico do nosso banco de dados</h3>
</section>

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

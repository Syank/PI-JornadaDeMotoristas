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
       <p>Seja bem vindo à <i>branch</i> da segunda entrega do RoadTracker!</p>
       
<h2>O nosso desafio</h2>
<p>Nosso cliente é a empresa IACIT e nos foi solicitado para desenvolver um sistema de gerenciamento de controle de jornada de trabalho de motoristas de forma parametrizável visando a disponibilização de funcionalidades de planejamento, acompanhamento e controle da jornada de trabalho destes trabalhadores. Nosso sistema deverá oferecer cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro), cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, tempo de espera, tempo de refeição e tempo de descanso).</p>

<h2>O que é o RoadTracker?</h2>
<p>Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois muitas vezes não há o controle sobre o expediente desses trabalhadores. Todas as filiais de uma empresa ser cadastradas e realizar o cadastro de seus motoristas e, consequentemente, realizar o cadastro das jornadas de trabalho deles, o veículo que será utilizado e a viagem a ser realizada. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!</p>

<h2><i>Card</i> da segunda entrega do nosso sistema</h2>
       <h3>O que entregamos :white_check_mark: </h3>
<p>A partir da primeira <i>sprint</i> (<i>sprint</i> 0), configuramos todo o ambiente de trabalho e dependências que o projeto necessita e desenvolvemos um CRUD básico dos funcionários. Agora, para a <i>sprint 1</i>, optamos por finalizar os métodos de CRUD que o perfil do administrador tem, corrigimos pequenos bugs que este perfil tinha e implementamos funcionalidades interessantes que certamente trazem uma experiência de uso melhor aos usuários. Inserimos funcionalidades extras como: verificação de login, verificação de segurança ao alterar dados, mover a janela pela tela e dicas flutuantes nos cadastros.</p>
       <h3>Por que fizemos essa escolha? :grey_question: </h3>
<p>O projeto pode ser basicamente separado em três partes, de acordo com os perfis de acesso, sendo eles motorista, supervisor e administrador. Como a entrega anterior já era dentro do perfil do administrador optamos, para a <i>sprint 1</i>, por finalizar todas as funcionalidades que esse perfil tem, assim o usuário já pode ter uma experiência de uso mais concreta do nosso programa, podendo cadastrar todas as entidades, acessar suas informações, editá-las ou apagá-las, se assim desejar.</p>
       <h3>Quais são as partes mais trabalhosas? :question: </h3>
<p>As partes mais trabalhosas foram as correções que se mostraram serem necessárias realizar no sistema do banco de dados, de como as entidades se relacionam entre si e adaptar essas mudanças ao código Java. Além disso as telas de cadastro e alteração de viagens se mostrou mais trabalhosa, pois envolvia um novo componente: o <i>DatePicker</i>. Ainda não havíamos o utilizado, portanto nós tivemos que pesquisar um pouco mais para aprender a utilizá-lo.</p>

<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/Cards/card2.png" width="500" height="280"/>
<div>
       <h2><i>Feedback</i> sobre a primeira entrega</h2>
       <p>Após nossa primeira entrega, recebemos um <i>feedback</i> positivo em relação ao cliente, a empresa IACIT, contudo por parte da avaliação técnica dos professores, em nosso repositório ainda faltavam alguns elementos para serem adicionados, sendo eles: a divisão das entregas por <i>branches</i>, o esforço que tivemos na <i>sprint</i> e nossa justificativa de priorização. Sendo assim detalhamos ainda mais as nossas entregas agregando as sugestões ao nosso projeto. Também fomos aconselhados a realizar o <i>login</i> através de um e-mail e não através do CPF.</p>
       <p>Com essas observações levantadas pelos professores, separamos as entregas por <i>branches</i>. Agora temos uma <i>branch</i> para cada entrega, sendo a <i>branch master</i> a que possui o nosso projeto na sua totalidade. Adicionamos o esforço que tivemos e a justificativa ao nosso README. Estes dois últimos estão na seção logo acima dessa.</p>
       <p>Tivemos algumas sugestões quanto às nossas <i>user stories</i>. Adicionamos identificações a cada <i>story</i> e melhoramos a descrição de cada uma, para que ficasse melhor explicado para todos. Além disso revisamos a ligação entre as <i>user stories</i> e o banco de dados para que tudo estivesse interligado corretamente.</p>
</div>

<div>
       <h2>Gráfico do <i>burndown</i> do nosso progresso na entrega</h2>
       <div>
              <img aling="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/Burndown/Sprint%201%20completo.jpg">
              </br>
              <p>O gráfico acima exibe nosso progresso na realização das atividades que elaboramos para a segunda entrega. Nele é possível ver que desde o começo nossa equipe esteve dedicada à entrega e sempre esteve adiantada no cronograma. Tal feito nos permitiu adicionar funcionalidades extras ao sistema que inicialmente não havíamos planejado, tudo para melhorar a experiência do usuário.</p>
       </div>
</div>

<h2>Nosso sistema em funcionamento na segunda entrega</h2>

<div>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/apresentacao_entrega_2/GIFS%202%C2%B0%20entrega/GIF%20LOGIN.gif" width="400"/>

 <p>A tela de login agora verifica os dados inseridos nos campos para confirmar se a conta existe de verdade no banco de dados, antes de liberar o acesso ao usuário.
</p>
<p>Agora ao posicionar o mouse em cima de um campo, uma dica flutuante irá aparecer para mostrar sobre o que aquele campo se trata.
</p>
<p>Também temos a funcionalidade de mover a janela do programa pela tela, como exemplificado no GIF.
</p>
</div>

</br></br>

<div>
<img align="right" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/apresentacao_entrega_2/GIFS%202%C2%B0%20entrega/GIF%20CRUD%20FUNCION%C3%81RIOS.gif" width="410"/>
       
<p>No momento de se cadastrar um funcionário novo no sistema o administrador pode escolher entre os cargos disponíveis.
</p>
<p>Ao selecionar o cargo de motorista alguns campos novos com informações extras irão aparecer. Isso ocorre pois o cargo de motorista é o princial do sistema e precisamos coletar mais informações para manter um monitoramento mais preciso.
</p>
<p>Após cadastrar um funcionário, independente do cargo, é possível utilizar o e-mail e a senha imediatamente no login para entrar no sistema como aquele usuário.
</p>
</div>

</br></br>

<div>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/apresentacao_entrega_2/GIFS%202%C2%B0%20entrega/GIF%20CRUD%20FILIAIS.gif" width="410"/>
       
<p>As filiais no sistema possuem um campo para o RNTRC, que é uma licença rodoviária.
</p>
<p>Para cadastrar algumas outras entidades é necessário possuir antes uma filial cadastrada no sistema.
</p>
<p>Após cadastrar uma filial, já se torna possível utilizá-la para cadastrar outras entidades no sistema sem precisar reiniciar o programa para recarregar as informações do banco de dados.
</p>
</div>

</br></br>

<div>
<img align="right" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/apresentacao_entrega_2/GIFS%202%C2%B0%20entrega/GIF%20CRUD%20VEICULOS.gif" width="410"/>
       
<p>Os veículos são vinculados a uma filial no momento do seu cadastro no sistema.
</p>
<p>Ao se cadastrar um veículo, os campos que devem ser preenchidos são a respeito do seu rastreador, sua placa, modelo do veículo e filial a qual pertence.
</p>
<p>Assim como necessita-se de uma filial para cadastrar algumas entidades, também necessita-se de um veículo para criar uma nova viagem no sistema.
</p>
</div>
       
</br></br>
       
<div>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/apresentacao_entrega_2/GIFS%202%C2%B0%20entrega/GIF%20CRUD%20ENTREGAS.gif" width="400"/>
       
<p>Por fim temos as viagens, que necessitam de um motorista e um veículo cadastrados no sistema para serem criadas. Dessa forma as entidades irão se relacionar e caso seja necessário realizar uma busca ela será muito mais efetiva.
</p>
<p>As viagens necessitam que seja especificado a empresa de destino, a carga levada e o prazo máximo para a entrega.
</p>
<p>Dessa forma após criar uma nova viagem, ela irá constar na conta do motorista escolhido. Assim ele poderá realizar as ações que são cabíveis a ele.
</p>
</div>

</br></br>

<p>Para todos os CRUDs mostrados acima note que ao tentar realizar qualquer alteração nos dados irá surgir uma caixa para a confirmação da senha do usuário conectado ao sistema, o que garante a segurança dos dados caso alguém tente alterá-los sem permissão.</p>
       
<div>
<h2>User stories do nosso sistema</h2>

<h3>Segunda entrega :clock4:</h3>
<p>A nossa segunda entrega será focada no término do perfil do administrador, ou seja, haverá o cadastro de viagens, filiais e veículos além da leitura de avisos enviados pelos motoristas. Os usuários passarão a necessitar de um cadastro para acessar o sistema, ou seja, o login funcionará.</p>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/user_stories/2.png" width="600px"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/user_stories/2-2.png" width="600px"/>
</div>

<h2><i>Wireframes</i> da segunda entrega do RoadTracker</h2>
<div align="center">
       <p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/wireframes/aviso_dados_alterados.jpeg" width="400"/>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/wireframes/historico_entregas.jpeg" width="400"/>
       </p>
       <p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/wireframes/aviso_selecionado.png" width="400"/>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/wireframes/ver_filiais.png" width="400"/>
       </p>
       </br>
       <p>
              Estas são apenas algumns dos <i>wireframes</i> do nosso projeto, você pode visualizar todos clicando <a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/master/doc/wireframes">aqui</a>.
       </p>
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
~~~

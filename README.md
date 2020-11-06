<head>
       <p><img src="https://img.shields.io/badge/status%20do%20projeto-em%20progresso-yellow?style=for-the-badge&logo=appveyor"></p>
       <p><img src="https://img.shields.io/badge/Sprint%20atual-Sprint%202-blue?style=for-the-badge&logo=appveyor"></p>
       <p>
       <img src="https://img.shields.io/badge/dependências-JavaFX%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-JDK%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-Hibernate%3A%205.4.21-green">
       <img src="https://img.shields.io/badge/dependências-PostgreSQL%20JDBC%3A%2042.2.16-green">
       </p>

</head>
<body>
       <h1>RoadTracker :truck::computer:</h1>
       <p>Seja bem vindo à <i>branch</i> da terceira entrega do RoadTracker!</p>
       
<h2>O nosso desafio</h2>
<p align="justify">Nosso cliente é a empresa IACIT. Foi solicitado para nós desenvolver um sistema para o gerenciamento e controle da jornada de trabalho de motoristas que seja parametrizável visando à disponibilização de funcionalidades de planejamento, acompanhamento, controlando a jornada de trabalho de cada um desses colaboradores. Nosso sistema deverá oferecer um cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), a escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro) e um cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, espera, refeição e descanso).</p>

<h2>O que é o RoadTracker?</h2>
<p align="justify">Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois, muitas vezes, não há o monitoramento e acompanhamento necessário do expediente desses trabalhadores. Todas as filiais de uma empresa devem ser cadastradas, assim como seus motoristas e suas respectivas jornadas de trabalho, viagens a serem realizadas e o veículo que será utilizado em cada uma dessas viagens. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!</p>

<h2><i>Card</i> da terceira entrega do nosso sistema</h2>
       <h3>O que entregamos :white_check_mark: </h3>
<p align="justify">Para esta entrega, <i>sprint</i> 2, desenvolvemos e adicionamos ao sistema os perfis do motorista e do supervisor, finalizando as funcionalidades do sistema. Na parte do motorista, foram adicionados métodos e caminhos para o usuário visualizar suas viagens, iniciá-las ou pausá-las, controlar seus tempos (como expediente, descanso e alimentação) e envio de avisos ao sistema, em que supervisores e administradores podem acessar e ficarem cientes da situação do motorista. Já para o supervisor, adicionamos a possibilidade de solicitar cadastros de novos motoristas, solicitações essas que serão aprovadas ou não por algum administrador, a opção de visualizar viagens, motoristas e veículos no sistema e a alteração dos dados destes dois últimos. Os supervisores também conseguem visualizar os avisos e solicitações registradas no sistema.</p>
       <h3>Por que fizemos essa escolha? :grey_question: </h3>
<p align="justify">Na <i>sprint</i> anterior (<i>sprint</i> 1), foi adicionado ao sistema todas as funcionalidades do perfil do administrador, que é responsável por inserir, manipular e apagar todas as entidades do sistema. Por isso, para a entrega atual optamos por apertar o passo e finalizar os outros dois perfis que estipulamos que nosso sistema precisaria, restando apenas, para a última entrega, apenas ajustes de UX e atender a pedidos específicos do cliente para que o sistema atenda às suas expectativas.</p>
       <h3>Quais são as partes mais trabalhosas? :question: </h3>
<p align="justify">Diferente do perfil do administrador em si, onde havia, de certa forma, poucas coisas para se fazer, mas que exigiam bastante tempo, os perfis do motorista e do supervisor tinham diversas itens a se adicionar, mas que eram simples de se fazer, pois a lógica do sistema já havia sido elaborada anteriormente. Então as grandes dificuldades dessa <i>sprint</i> em si foram correlacionar os perfis entre si para que tudo funcionasse em harmonia.</p>
</br>
<p align="justify">A nossa terceira entrega foi um pouco excepcional, pois inicialmente haviamos planejado a conclusão apenas do perfil do motorista. Contudo, devido ao empenho da equipe e o grande aprendizado que tivemos no decorrer das <i>sprints</i>, concluímos que conseguiríamos adiantar a última entrega, que seria o término do perfil do supervisor. Por isso logo abaixo consta os dois cards das entregas, a que planejamos fazer e a última que conseguimos desenvolver antes do previsto.</p>
<div align="justify">
       <p>
           <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/Cards/card3.png" width="400"/>
           <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/Cards/card4.png" width="400"/>
       </p>
</div>
<div>
       <h2><i>Feedback</i> sobre a segunda entrega</h2>
       <p align="justify">Como a última entrega apenas foi avaliada pelos professores, não tivemos um <i>feedback</i> por parte do cliente. Em relação ao sistema em si, nenhuma observação foi levantada pelos avaliadores, porém na parte organizacional do GitHub foram apontados alguns pontos que levamos em consideração e já adequamos ao requerido.</p>
       <p align="justify">Em nossa <i>branch master</i> havia muito conteúdo no README, tornando-o muito extenso e cansativo para se ler.</p>
       <p align="justify">Na apresentação fomos aconselhados a expor mais informações do projeto, como modelo de dados, backlog total e tecnologias utilizadas, por mais que já tenham sido expostos, para mostrar a evolução do projeto, tornando a apresentação mais completa.</p>
</div>

<div>
       <h2>Gráfico do <i>burndown</i> do nosso progresso na entrega</h2>
       <div>
              <img aling="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/Burndown/Sprint%202%20completo.png">
              </br>
              <p align="justify">O gráfico acima exibe nosso progresso na realização das atividades que elaboramos para a terceira entrega. Diferente da entrega anterior, nesta nossa equipe não teve um desenvolvimento tão linear, chegando inclusive em alguns momentos a ficar com o rendimento levemente abaixo do esperado. Talvez uma das razões disso ter ocorrido seja uma pequena exaustão de todos após o empenho da entrega 2, além de fatores externos. De quaisquer maneiras recuperamos o tempo e cumprimos tudo o que havíamos planejado para esta entrega.</p>
       </div>
</div>

<h2>Nosso sistema em funcionamento na terceira entrega</h2>

<div>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/apresentacao_entrega_3/GIFS%203%C2%B0%20entrega/GIF%20motorista.gif" width="400"/>

<p align="justify">Como motorista, o usuário tem acesso as suas viagens à serem realizadas e a capacidade de inicia-las e pausa-las de acordo com a necessidade.
</p>
<p align="justify">Após iniciar uma viagem, todas as informações da mesma podem ser vistas no respectivo menu, onde o motorista pode controlar suas horas de trabalho, alimentação e descanso.
</p>
<p align="justify">Se necessário, o usuário também pode gerar avisos no sistema para informar aos supervisores e administradores algum imprevisto na sua viagem.
</p>
</div>

</br></br>

<div>
<img align="right" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/apresentacao_entrega_3/GIFS%203%C2%B0%20entrega/GIF%20supervisor.gif" width="410"/>
       
<p align="justify">No perfil do supervisor, o usuário tem acesso as listas de viagens, veículos e de motoristas cadastrados no sistema para saber mais sobre suas informações.
</p>
<p align="justify">O supervisor tem a capacidade de gerar solicitações de cadastro de novos motoristas aos administradores, bem como editar informações de motoristas e veículos já cadastrados.
</p>
<p align="justify">Ele também pode visualizar os avisos gerados no sistema por outros supervisores e motoristas.
</p>
</div>

</br></br>

<div>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/apresentacao_entrega_3/GIFS%203%C2%B0%20entrega/GIF%20recupera%C3%A7%C3%A3o%20de%20senha.gif" width="410"/>
       
<p align="justify">A funcionalidade de recuperação de senha também foi adicionada a tela inicial do programa, o login.
</p>
<p align="justify">Para recuperar a senha, o usuário deve fornecer dados para comprovar sua ententicidade, como nome completo, e-mail, seu cargo e seu CPF.
</p>
<p align="justify">Caso todos os dados estejam corretos, a senha é redefinida para a nova que foi fornecida pelo usuário no momento da recuperação e já pode ser utilizada.
</p>
</div>

</br></br>

<div>
<h2>User stories do nosso sistema</h2>

<h3>Terceira entrega :clock4:</h3>
<p align="justify">Ressaltando novamente, nesta <i>sprint</i> nossa equipe conseguiu acelerar o desenvolvimento do sistema e finalizar em conjunto a última entrega, por isso, abaixo estão as <i>User Stories</i> de ambas as entregas.</p>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_1/doc/user_stories/3.png" width="600px"/>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/user_stories/4.png" width="600px"/>
</div>

<h2>Amostra de <i>Wireframes</i> da terceira entrega do RoadTracker</h2>
<div align="center">
       <p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/wireframes/Motorista/viagem_atual_iniciada.png" width="400"/>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/wireframes/Motorista/listagem_minhas_viagens.png" width="400"/>
       </p>
       <p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/wireframes/Supervisor/listagem_motoristas.png" width="400"/>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/wireframes/Supervisor/solicitacao_cadastro_sucesso.png" width="400"/>
       </p>
       </br>
       <p>
              Estas são apenas algumas das <i>wireframes</i> do nosso projeto, você pode visualizar todos clicando <a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/master/doc/wireframes">aqui</a>.
       </p>
</div>

<section id="ModeloC">
        <h3>Modelo conceitual do nosso banco de dados (com ajustes para a sprint)</h3>
        <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/banco_de_dados/RTdbNovo-conceitual.png" width="800px">
    
</section>

<section id="ModeloL">
        <h3>Modelo lógico do nosso banco de dados (com ajustes para a sprint)</h3>
        <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/banco_de_dados/RTdbNovo-logico.png" width="800px">

</section>
<section id="ModeloF">
        <h3>Modelo físico do nosso banco de dados</h3>
       <p>Você pode visualizar o modelo físico (código) do nosso banco de dados clicando <a href="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_2/doc/banco_de_dados/RTdbNovo-fisico.sql">aqui</a>.</p>
</section>

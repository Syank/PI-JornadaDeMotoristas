<head>
       <p><img src="https://img.shields.io/badge/status%20do%20projeto-em%20progresso-yellow?style=for-the-badge&logo=appveyor"></p>
       <p><img src="https://img.shields.io/badge/Sprint%20atual-Sprint%203-blue?style=for-the-badge&logo=appveyor"></p>
       <p>
       <img src="https://img.shields.io/badge/dependências-JavaFX%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-JDK%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-Hibernate%3A%205.4.21-green">
       <img src="https://img.shields.io/badge/dependências-PostgreSQL%20JDBC%3A%2042.2.16-green">
       </p>
         
</head>
<body>
        <nav>
            <p><h1>RoadTracker :truck::computer:</h1></p>
            <p>Seja bem-vindo à branch da quarta entrega do RoadTracker!</p>
            <p><h2>O nosso desafio</h2></p>
            <p align="justify">Nosso cliente é a empresa IACIT. Foi solicitado para nós desenvolvermos um sistema para o gerenciamento e controle da jornada de trabalho de motoristas sendo parametrizável, visando à disponibilização de funcionalidades de planejamento, acompanhamento, controlando a jornada de trabalho de cada um desses colaboradores. Nosso sistema deverá oferecer um cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), a escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro) e um cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, espera, refeição e descanso).</p>

</nav>
</section>

<section id="o_que_e">
            <h3>O que é o RoadTracker?</h3>
            <p align="justify">Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois, muitas vezes, não há o monitoramento e acompanhamento necessário do expediente desses trabalhadores. Todas as filiais de uma empresa devem ser cadastradas, assim como seus motoristas e suas respectivas jornadas de trabalho, viagens a serem realizadas e o veículo que será utilizado em cada uma dessas viagens. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!</p>
               
</section>

<h2>Nossa quarta e última entrega do sistema</h2>
       <h3>O que entregamos :white_check_mark: </h3>
<p align="justify">Para esta entrega, <i>sprint</i> 3, focamos nossos esforços na correção de bugs críticos no sistema, atendemos ao pedido do cliente de registrar as atividades dos usuários no sistema para auditorias, passamos do banco de dados local para on-line e criamos um instalador do nosso programa, visando aumentar a portabilidade do mesmo.</p>
       <h3>Por que fizemos essa escolha? :grey_question: </h3>
<p align="justify">Na <i>sprint</i> anterior (<i>sprint</i> 2), haviamos finalizado toda a parte mais delicada do sistema e seu funcionamento, por isso, para esta entrega, nos restou melhorias de UX e atender a pedidos do cliente.</p>
       <h3>Quais são as partes mais trabalhosas? :question: </h3>
<p align="justify">Podemos dizer que a parte mais complexa desta entrega foi a elaboração de um programa instalador do nosso sistema, que permitisse aumentar a sua portabilidade e não exigindo que o usuário final tenha pré-instalado softwares de terceiros para ter acesso ao RoadTracker.</p>
</br>
<p align="justify">Com tudo isso em mente, o desempenho da equipe durante a entrega não poderia ter sido melhor, já que todos os requisitos foram cumpridos, contúdo, por na última entrega termos adiantado a entrega 4, a atual, não há um card disponível com as funcionalidades do sistema, porém pode-se concluir que a <b>complexidade desta entrega foi 75/100.</b></p>

<div>
       <h2><i>Feedback</i> sobre a terceira entrega</h2>
       <p align="justify">Durante a apresentação da terceira entrega, o cliente nos fez o pedido para que implementassemos no sistema a funcionalidade de registro de atividades e informações dos usuários e entidades para fins de auditoria. Levando isso em consideração, adicionamos essa funcionalidade ao sistema e agora tudo o que o usuário fizer que altere algum dado no banco de dados será devidamente registrado e, disponível apenas aos administradores, também é possível solicitar a criação de um arquivo PDF, parametrizável, com essas informações.</p>
</div>

<div>
       <h2>Gráfico do <i>burndown</i> do nosso progresso na entrega</h2>
       <div>
              <img aling="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_3/doc/Burndown/Sprint%203%20completo.png">
              </br>
              <p align="justify">O gráfico acima exibe nosso progresso na realização das atividades que elaboramos para a quarta entrega. Desta vez a equipe se manteve focada na sprint e todas as atividades que estabelecemos para nós mesmos foram cumpridas sem grandes atrasos.</p>
       </div>
</div>

<h2>Nosso sistema em funcionamento na quarta entrega</h2>

<div>
       <p align="justify">Diferente das outras entregas, dessa vez não adicionamos nada de novo aos perfis de motoristas e supervisores, apenas uma nova funcionalidade no perfil do administrador, responsável por gerar os dados da funcionalidade requisitada pelo cliente.</p>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_3/doc/apresentacao_entrega_4/GIFS%20entrega%20final/GIF%20Administrador.gif" width="400"/>

<p align="justify">No GIF ao lado, está o perfil do administrador completo, o qual também está disponível na branch master.
</p>
<p align="justify">Ao final dele é possível ver com mais detalhes a nova funcionalidade de registro de atividades e a geração do PDF.
</p>
</div>

</br></br>

</br></br>

<div>
<h2>User stories do nosso sistema</h2>

<h3>Quarta entrega :clock4:</h3>
<img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_3/doc/user_stories/4.png" width="600px"/>
</div>

<h2>Amostra de <i>Wireframes</i> da quarta entrega do RoadTracker</h2>
<div align="center">
       <p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_3/doc/wireframes/Administrador/tela_logs.png" width="400"/>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/sprint_3/doc/wireframes/Administrador/gerar_relatorio.bmp" width="400"/>
       </p>
       </br>
       <p>
       Estas são apenas algumas das <i>wireframes</i> do nosso projeto, você pode visualizar todos clicando <a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/master/doc/wireframes">aqui</a>.
       </p>
</div>

<section id="Modelo">
        <h3>Modelo físico do nosso banco de dados</h3>
       <p>Não houveram mudanças no banco de dados, mas você pode vê-lo clicando <a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/sprint_3/doc/banco_de_dados">aqui</a>.</p>
</section>

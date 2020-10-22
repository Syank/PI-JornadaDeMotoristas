package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Motorista;
import model.Viagem;
import view.Main;
import view.Viagens;

public class ControlesPerfilMotViagemAtual implements Initializable {
	
	 Viagem viagemAtual = null;
	 
	 public static boolean cronometrarTempoTotal = false;
	 public static boolean cronometrarExpDiario = false;
	 public static boolean carregarViagem = false;
    
	 @FXML
	 private Label labelDestino;
	 @FXML
	 private Label labelPlaca;
	 @FXML
	 private Label labelPrazo;
	 @FXML
	 private Label labelHorasTotais;
	 @FXML
	 private Label labelCarga;
	 @FXML
	 private Label labelSituacao;
	 @FXML
	 private Label labelAtencao;
	 @FXML
	 private Button botaoExpediente;
	 @FXML
	 private Label labelExpMax;
	 @FXML
	 private Label labelExpHoje;
	 @FXML
	 private Button botaoAlimentacao;
	 @FXML
	 private Label labelAlimMax;
	 @FXML
	 private Label labelAlimHoje;
	 @FXML
	 private Button botaoDescanso;
	 @FXML
	 private Label labelDescMax;
	 @FXML
	 private Label labelDescHoje;

	 private List<Viagens> listaDeViagens = new ArrayList<>();
    
	 
	 
	 


    @FXML
    public void iniciarExpediente(ActionEvent event) {	
    	cronometrarTempoTotal = true;
    	cronometrarExpDiario = true;
    	botaoExpediente.setText("Pausar expediente");
    	botaoExpediente.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			finalizarExpediente(event);
    		}
    	});   	
    }
    @FXML
    public void finalizarExpediente(ActionEvent event) {	
    	cronometrarTempoTotal = false;
    	cronometrarExpDiario = false;
    	botaoExpediente.setText("Iniciar expediente");
    	botaoExpediente.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			iniciarExpediente(event);
    		}
    	});
    }
    
    
    @FXML
    public void pausaDescanso(ActionEvent event) {	
    }
    @FXML
    public void voltaDescanso(ActionEvent event) {	
    }
    
    
    @FXML
    public void pausaAlimentacao(ActionEvent event) {	
    }
    @FXML
    public void voltaAlimentacao(ActionEvent event) {	
    }
    
    
    @FXML
    public void finalizarViagem(ActionEvent event) {	
    }
    
    
    
    public void carregarViagem() {
    	Viagem viagem = new Viagem();
    	Motorista motorista = new Motorista().encontrarMotorista(ControlesLogin.cpfLogado);

    	
    	listaDeViagens = viagem.listarViagens();
    	
    	listaDeViagens.forEach(item -> {
    		if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
    			if(item.getSituacao().equals("Em andamento")) {
    				viagemAtual = viagem.encontrarViagem(item.getId());
    			}
    		}
    	});
    	
    	if(viagemAtual != null) {        	
    		labelDestino.setText(labelDestino.getText() + viagemAtual.getDestino());
    		labelPlaca.setText(labelPlaca.getText() + viagemAtual.getVeiculo().getPlaca());
    		labelPrazo.setText(labelPrazo.getText() + viagemAtual.getFim());
    		labelHorasTotais.setText(labelHorasTotais.getText() + viagemAtual.getTotal());
    		labelCarga.setText(labelCarga.getText() + viagemAtual.getCarga());
    		labelSituacao.setText(labelSituacao.getText() + viagemAtual.getSituacao());
    		
    		labelAtencao.setVisible(false);
    		
    		labelExpMax.setText(labelExpMax.getText() + motorista.getCargaHoraria() + 'h');
    		labelExpHoje.setText(labelExpHoje.getText() + motorista.getTrabalhado_hoje() + 'h');
    		
       		labelAlimMax.setText(labelAlimMax.getText() + "1h");
       		labelAlimHoje.setText(labelAlimHoje.getText() + motorista.getAlimentacao_hoje() + 'h');
       		
       		labelDescMax.setText(labelDescMax.getText() + "1h");
    		labelDescHoje.setText(labelDescHoje.getText() + motorista.getDescansado_hoje() + 'h');
    		
    		
    		
    		
    		
    		// Essa parte logo abaixo talvez esteja confusa, mas resumindo, ela verifica se a entrega está atrasada ou não, e avisa o motorista caso esteja
        	String prazo = viagemAtual.getFim();
        	
        	int ano = LocalDate.now().getYear();
        	int dia = LocalDate.now().getDayOfMonth();
        	int mes = LocalDate.now().getMonthValue();
        	
        	String desmontado[] = prazo.split("/");
        	
        	if(Integer.parseInt(desmontado[2]) < ano) {
        		labelAtencao.setVisible(true);
        		labelAtencao.setText("Sua entrega está atrasada! Verifique junto a filial para mais informações.");
        	}else if(Integer.parseInt(desmontado[1]) < mes) {
        		labelAtencao.setVisible(true);
        		labelAtencao.setText("Sua entrega está atrasada! Verifique junto a filial para mais informações.");
        	}else if(Integer.parseInt(desmontado[0]) < dia) {
        		labelAtencao.setVisible(true);
        		labelAtencao.setText("Sua entrega está atrasada! Verifique junto a filial para mais informações.");
        	}
        	

        	// Ativa os botões
        	botaoAlimentacao.setDisable(false);
        	botaoDescanso.setDisable(false);
        	botaoExpediente.setDisable(false);
        	
        	
        	carregarViagem = false;
    	}
    	
    	
    	
    	
    }
    
    
    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	Main.trocarTela("Criar Aviso");
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
    	Main.trocarTela("Mot Viagens");
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }
	@FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

    
    
    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"

  	  	
  	  	
  	  	// "Função" para cronometrar o tempo
  	  	if(cronometrarTempoTotal) {
	  	  	String texto = "Horas totais dirigidas: ";
	  	  	
	  	  	String tempoAtual[] = labelHorasTotais.getText().split(":");
	  	  	
	  	  	String segundos = tempoAtual[3];
	  	  	String minutos = tempoAtual[2];
	  	  	String horas = tempoAtual[1].substring(1);  // Nessa linha, horas inicialmente vem como " 00", então essas operações retiram o " "
	  	  	
	  	  	// Incrementa o tempo
	  	  	segundos = String.valueOf(Integer.parseInt(segundos) + 1);
	  	  	if(Integer.parseInt(segundos) >= 60) {
	  	  		segundos = "00";
	  	  	  	minutos = String.valueOf(Integer.parseInt(minutos) + 1);
	  	  	}
	  	  	if(Integer.parseInt(minutos) >= 60) {
	  	  		minutos = "00";
	  	  		horas = String.valueOf(Integer.parseInt(horas) + 1);
	  	  	}
	  	  	
	  	  	// Formata o tempo
	  	  	if(Integer.parseInt(segundos) < 10 && segundos.length() < 2) {
	  	  		segundos = "0" + segundos;
	  	  	}
	  	  	if(Integer.parseInt(minutos) < 10 && minutos.length() < 2) {
	  	  		minutos = "0" + minutos;
	  	  	}
	  	  	if(Integer.parseInt(horas) < 10 && horas.length() < 2) {
	  	  		horas = "0" + horas;
	  	  	}
	  	  	
	  	  	// Formata o texto e coloca na label
	  	  	texto = texto + horas + ":" + minutos + ":" + segundos;	
	  	  	labelHorasTotais.setText(texto);
	  	  	
  	  	}
  	  	
  	  	if(cronometrarExpDiario) {
  	  		String texto = "Total de hoje: ";
  	  		String totalDiario = labelExpHoje.getText();
  	  		
  	  		if(!totalDiario.contains("0h")) {
  		  	  	String tempoAtual[] = labelExpHoje.getText().split(":");
  		  	  	
  		  	  	String segundos = tempoAtual[3];
  		  	  	String minutos = tempoAtual[2];
  		  	  	String horas = tempoAtual[1].substring(1);
  		  	  	
  		  	  	// Incrementa o tempo
  		  	  	segundos = String.valueOf(Integer.parseInt(segundos) + 1);
  		  	  	if(Integer.parseInt(segundos) >= 60) {
  		  	  		segundos = "00";
  		  	  	  	minutos = String.valueOf(Integer.parseInt(minutos) + 1);
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) >= 60) {
  		  	  		minutos = "00";
  		  	  		horas = String.valueOf(Integer.parseInt(horas) + 1);
  		  	  	}
  		  	  	
  		  	  	// Formata o tempo
  		  	  	if(Integer.parseInt(segundos) < 10 && segundos.length() < 2) {
  		  	  		segundos = "0" + segundos;
  		  	  	}
  		  	  	if(Integer.parseInt(minutos) < 10 && minutos.length() < 2) {
  		  	  		minutos = "0" + minutos;
  		  	  	}
  		  	  	if(Integer.parseInt(horas) < 10 && horas.length() < 2) {
  		  	  		horas = "0" + horas;
  		  	  	}
  		  	  	
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + horas + ":" + minutos + ":" + segundos;	
  		  	  	labelExpHoje.setText(texto);
  		  	  	
  	  		}else {
  		  	  	// Formata o texto e coloca na label
  		  	  	texto = texto + "00:00:01";	//Aqui precisa iniciar em 1s para não ficar atrasado o tempo
  		  	  	labelExpHoje.setText(texto);
  		  	  	
  	  		}
  	  		
  	  	}
  	  	
  	  	// Carrega a viagem do motorista
  	  	if(carregarViagem) {
  	  		carregarViagem();
  	  	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask(){
       

          @Override
          public void run() {
        	  Platform.runLater(() -> tarefasEmLoop());
          }
        }, 0, 1000);
	} 
}

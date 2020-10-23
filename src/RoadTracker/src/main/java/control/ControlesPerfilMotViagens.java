package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Viagem;
import view.Main;
import view.Viagens;

public class ControlesPerfilMotViagens implements Initializable {
	
	public static boolean carregarTableView = false;

    @FXML
    private Pane paneMinhasViagens;
    @FXML
    private TableView<Viagens> tabelaViagens;
    @FXML
    private TableColumn<?, ?> colunaDestino;
    @FXML
    private TableColumn<?, ?> colunaCarga;
    @FXML
    private TableColumn<?, ?> colunaPrazo;
    @FXML
    private TableColumn<?, ?> colunaSituacao;
    @FXML
    private Pane paneViagemSelecionada;
    

    

    @FXML
    void iniciaViagem(ActionEvent event) {
    	//Ao clicar em um botão com este evento, abre a tela da viagem atual.
    	Viagens selecionado = tabelaViagens.getSelectionModel().getSelectedItem();
    	Viagem viagem = new Viagem();
    	
    	viagem = viagem.encontrarViagem(selecionado.getId());
    	
    	viagem.atualizarSituacao("Em andamento");
    	
    }

    @FXML
    void pausaViagem(ActionEvent event) {
    	//Ao clicar em um botão com este evento, finaliza a viagem atual.
    }
    
    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	Main.trocarTela("Criar Aviso");
    	//Ao clicar em um elemento com este evento, redireciona para a tela de criar aviso.
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
		carregarInfoViagens (); //atualiza lista
    	//Ao clicar em um elemento com este evento, redireciona para a tela de minhas viagens.
    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {
    	Main.trocarTela("Viagem Selecionada");
    	//Ao clicar em um elemento com este evento, redireciona para a tela de realizar viagem.
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
    
    

    void carregarInfoViagens () {
        List<Viagens> listaDeViagens = new ArrayList<>();
        List<Viagens> listaDeViagensMotorista = new ArrayList<>();
        ObservableList<Viagens> obsListViagens;
        
    	Viagem viagem = new Viagem();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	
    	//Essa "coisa" abaixo é um 'for coisa in lista' embelezado do java
    	listaDeViagens.forEach(item -> {
    		if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
    			listaDeViagensMotorista.add(item);
    		}
    	});
    		
    	
    	obsListViagens = FXCollections.observableArrayList(listaDeViagensMotorista);
    	
    	colunaCarga.setCellValueFactory(new PropertyValueFactory<>("carga"));
    	colunaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
    	colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
    	colunaPrazo.setCellValueFactory(new PropertyValueFactory<>("prazo"));
    	
    	tabelaViagens.setItems(obsListViagens);
    }
    
    
    
    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"
    	
    	if(carregarTableView) {
    		carregarInfoViagens();
    		carregarTableView = false;
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

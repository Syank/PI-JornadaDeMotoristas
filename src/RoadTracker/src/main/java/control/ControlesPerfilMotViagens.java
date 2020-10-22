package control;

import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

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

import java.util.ArrayList;
import java.util.List;

public class ControlesPerfilMotViagens implements Initializable {

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
    
    private List<Viagens> listaDeViagens = new ArrayList<>();
    private List<Viagens> listaDeViagensMotorista = new ArrayList<>();
    private ObservableList<Viagens> obsListViagens;
    

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
    
    
    @FXML
    void carregarViagens(ActionEvent event) {
    	carregarInfoViagens();
    }
    void carregarInfoViagens () {
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
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Tudo que será carregado logo que abrimos o aplicativo.
		
	} 
}

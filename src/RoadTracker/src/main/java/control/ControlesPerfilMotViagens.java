package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Viagem;
import view.Main;

public class ControlesPerfilMotViagens implements Initializable {

    @FXML
    private Label labelViagens; //

    @FXML
    private Pane paneCadastrarAviso;

    @FXML
    private TableView<Viagem> tabelaViagens;

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
    void abrirCriarAviso(MouseEvent event) {
    	//Ao clicar em um elemento com este evento, redireciona para a tela de criar aviso.
    }

    @FXML
    void abrirHistEntregas(MouseEvent event) {
    	//Ao clicar em um elemento com este evento, redireciona para a tela de entregas.
    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {
    	//Ao clicar em um elemento com este evento, redireciona para a tela de realizar viagem.
    }

    @FXML
    void iniciaViagem(ActionEvent event) {
    	//Ao clicar em um botão com este evento, abre a tela da viagem atual.
    }

    @FXML
    void pausaViagem(ActionEvent event) {
    	//Ao clicar em um botão com este evento, finaliza a viagem atual.
    }
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Login"); 
    }
	@FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Tudo que será carregado logo que abrimos o aplicativo.
		
	} 
}

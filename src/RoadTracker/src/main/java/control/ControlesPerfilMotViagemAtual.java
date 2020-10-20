package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.Main;

public class ControlesPerfilMotViagemAtual implements Initializable {
    
    @FXML
    private Label labelViagem;

    @FXML
    private Pane paneRealizarViagem;

    @FXML
    private Label expMax;

    @FXML
    private Label expHoje;

    @FXML
    private Label alimentacaoMax;

    @FXML
    private Label alimentacaoHoje;

    @FXML
    private Label descansoMax;

    @FXML
    private Label descansoHoje;

    @FXML
    private Label viagemDestino;

    @FXML
    private Label viagemPlacaVeiculo;

    @FXML
    private Label prazoEntrega;

    @FXML
    private Label horasDirigidas;

    @FXML
    private Label motStatus;

    @FXML
    private Label carga;

    
    @FXML
    void abrirCriarAviso(MouseEvent event) {

    }

    @FXML
    void abrirHistEntregas(MouseEvent event) {

    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {

    }

    @FXML
    public void iniciarExpediente(ActionEvent event) {	
    }
    
    @FXML
    public void finalizarExpediente(ActionEvent event) {	
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
    public void finalizarEntrega(ActionEvent event) {	
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
		// TODO Auto-generated method stub
		
	} 
}

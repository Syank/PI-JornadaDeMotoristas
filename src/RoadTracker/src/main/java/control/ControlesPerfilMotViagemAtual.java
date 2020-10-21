package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import view.Main;

public class ControlesPerfilMotViagemAtual implements Initializable {
    
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
	 private Button botaoFinalizar;
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
    void abrirCriarAviso(MouseEvent event) {

    }

    @FXML
    void abrirHistEntregas(MouseEvent event) {

    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	} 
}

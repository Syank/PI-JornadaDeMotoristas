package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import view.Main;

public class ControlesPerfilMotViagemAtual implements Initializable {
    
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

package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.Main;

public class ControlesPerfilMotViagemAtual {
    
    @FXML
    public void iniciarExpediente(ActionEvent event) {	
    }
    
    @FXML
    public void pausaDescanso(ActionEvent event) {	
    }
    
    @FXML
    public void pausaAlimentacao(ActionEvent event) {	
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
}

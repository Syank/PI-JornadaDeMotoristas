package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import view.Main;

public class ControlesPerfilMotViagens implements Initializable {

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

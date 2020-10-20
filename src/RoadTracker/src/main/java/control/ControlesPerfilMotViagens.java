package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.Main;

public class ControlesPerfilMotViagens {

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

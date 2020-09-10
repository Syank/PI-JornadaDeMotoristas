package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControlesTela2 {

    @FXML
    private Button botaoDeslogar;

    @FXML
    void deslogar(ActionEvent event) {
    	Main.trocarTela("Tela 1");
    }

}

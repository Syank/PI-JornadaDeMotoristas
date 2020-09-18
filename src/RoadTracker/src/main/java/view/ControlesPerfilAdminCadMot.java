package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ControlesPerfilAdminCadMot {

    @FXML
    void abrirTelaFunc(MouseEvent event) {

    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
}

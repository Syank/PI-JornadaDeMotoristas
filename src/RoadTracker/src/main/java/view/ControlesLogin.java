package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControlesLogin {
	
    @FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private Button botaoEntrar;
	
	
	
	
    @FXML
    void verificarLogin(ActionEvent event) {
    	if(!inputUsuario.getText().isEmpty() && !inputSenha.getText().isEmpty()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    }
	
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

}

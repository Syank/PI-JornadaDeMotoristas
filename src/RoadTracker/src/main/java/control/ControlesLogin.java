package control;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import view.*;


public class ControlesLogin {
	
    @FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private Button botaoEntrar;
    
    @FXML
    private AnchorPane janela;
	
	
	
	
    @FXML
    void verificarLogin(ActionEvent event) throws IOException {
    	if(!inputUsuario.getText().isEmpty() && !inputSenha.getText().isEmpty()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    }
	
    
    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

}

package view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControlesTela1 {

    @FXML
    private Button botaoLimpar;

    @FXML
    private Button botaoLogin;

    @FXML
    private Label label;

    @FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputSenha;
    


    @FXML
    void limparCampos(ActionEvent event) {
    	inputUsuario.setText("");
    	inputSenha.setText("");
    }

    @FXML
    void verificarLogin(ActionEvent event) {
    	if(inputUsuario.getText().contains("oi")) {
    		System.out.println("Deu certo");
    		
    		Main.trocarTela("Tela 2");
    	}
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

}

package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControlesLogin {
	
    @FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private Button botaoEntrar;
	
	
	
	
    @FXML
    void verificarLogin(ActionEvent event) throws IOException {
    	if(!inputUsuario.getText().isEmpty() && !inputSenha.getText().isEmpty()) {
    		Stage telaAviso = new Stage();
    		Parent fxmlAviso = FXMLLoader.load(getClass().getResource("FXMLTelaDeAlerta.fxml"));
    		
    		Scene cenaTelaAviso = new Scene(fxmlAviso);
    		
    		telaAviso.setScene(cenaTelaAviso);
    		//telaAviso.initStyle(StageStyle.UNDECORATED);
    		telaAviso.initModality(Modality.APPLICATION_MODAL);
    		telaAviso.showAndWait();
    		
    		Main.trocarTela("Tela Boas Vindas");
    	}
    }
	
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

}

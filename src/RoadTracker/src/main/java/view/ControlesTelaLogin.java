package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControlesTelaLogin {

	@FXML
	private Button botaoLogin;
	
	@FXML
	private Button botaoSair;
	
	@FXML
	private Button botaoMinimizar;
	
	
	//@FXML
	//void botaoLogin(ActionEvent event) {
		// ir pra outra tela que aidna n sei como
	//}
	@FXML
	void botaoSair(ActionEvent event) {
		System.exit(0);
	}
	
}

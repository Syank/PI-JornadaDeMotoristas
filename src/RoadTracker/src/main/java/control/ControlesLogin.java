package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import view.*;
import model.*;


public class ControlesLogin implements Initializable{
	
	
    @FXML
    private TextField inputUsuario;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private Button botaoEntrar;
    
    @FXML
    private AnchorPane janela;
	
	
	
	
    @FXML
    void verificarLogin(ActionEvent event) {
    	Funcionario funcionario = new Funcionario();
    	Motorista motorista = new Motorista();
    	
    	String loginDado = inputUsuario.getText();
    	String senhaDada = inputSenha.getText();
    	
    	
    	
    	// O if abaixo verifica se o funcionário com o login fornecido possuí a mesma senha que a senha fornecida
    	if(funcionario.verificarLogin(loginDado).getSenha().equals(senhaDada)) {
        	Main.trocarTela("Tela Boas Vindas");
        	inputUsuario.setText("");
        	inputSenha.setText("");
        	System.out.println("logado como admin");
    	}else 
    		if(motorista.verificarLogin(loginDado).getSenha().equals(senhaDada)) {
	        	Main.trocarTela("Tela Boas Vindas");
	        	inputUsuario.setText("");
	        	inputSenha.setText("");
	        	System.out.println("logado como motorista");
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Funcionario func = new Funcionario();
		Filial filial = new Filial();
		
		
		// Verifica se já existe uma Filial no banco de dados para cadastrar o admin root
		if(!(filial.encontrarFilial(1) != null)) {
			filial.cadastrarFilial("Filial Central", "São José dos Campos", "SP", "00000000000000", "00000000");
		}
		
		// Verifica se já existe a conta do admin root, se não, a cria
		if(!(func.encontrarFuncionario("00000000000") != null)) {
			func.cadastrarFuncionario("Admin User", "00000000000", "root", "Administrador", 1, "adminuser@root.com");
		}
		
	}

}

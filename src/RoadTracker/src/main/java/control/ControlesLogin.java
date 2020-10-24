package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Filial;
import model.Funcionario;
import model.Motorista;
import view.Main;


public class ControlesLogin implements Initializable{
	
	public static String senha;
	public static String cpfLogado;
    @FXML
    private TextField inputUsuario;
    @FXML
    private PasswordField inputSenha;
    @FXML
    private Button botaoEntrar;
    @FXML
    private AnchorPane janela;
    @FXML
    private Label labelDicaFlutuante;
    @FXML
    private Pane paneAvisosPrincipal;
    @FXML
    private Pane paneAvisosSombra;
    @FXML
    private Pane paneAvisosFalha;
    @FXML
    private Label labelAvisosTituloFalha;
    @FXML
    private Label labelAvisosTextoFalha;
    @FXML
    void verificarLogin(ActionEvent event) {
    	Funcionario funcionario = new Funcionario();
    	Motorista motorista = new Motorista();
    	
    	String loginDado = inputUsuario.getText();
    	String senhaDada = inputSenha.getText();
    	
    	String cpfFunc = funcionario.verificarLogin(loginDado);
    	String cpfMot = motorista.verificarLogin(loginDado);
    	
    	funcionario = funcionario.encontrarFuncionario(cpfFunc);
    	motorista = motorista.encontrarMotorista(cpfMot);
    	
    	
    	// A sequência de ifs abaixo pode ser um pouco confusa, mas, resumindo, ela verifica se foi encontrado pelo menos 1 dos cpfs,
    	//se for, então verifica qual tipo de cpf foi logado
    	if(cpfFunc.equals("Não encontrado") && cpfMot.equals("Não encontrado")){
    		notificar("Falha", "Usuário não encontrado", "Nenhum usuário foi encontrado. Verifique os dados.");
    	}
    	else {
    		if(cpfMot.equals("Não encontrado")) {
    			if(funcionario.getSenha().equals(senhaDada)) {
    				senha = senhaDada;
    				cpfLogado = funcionario.getCpf();
                	Main.trocarTela("Tela Boas Vindas");
                	inputUsuario.setText("");
                	inputSenha.setText("");
    		}
    	}
    	else if (cpfFunc.equals("Não encontrado")) {
    		if(motorista.getSenha().equals(senhaDada)) {
    			senha = senhaDada;
    			cpfLogado = motorista.getCpf();
	        	Main.trocarTela("Viagem Selecionada");
	        	inputUsuario.setText("");
	        	inputSenha.setText("");
	        	motorista.resetarDiaDeTrabalho();
	        	ControlesPerfilMotViagemAtual.carregarViagem = true;
	        	ControlesPerfilMotViagens.carregarTableView = true;
    			}
    		}
    	}
    }

    
    @FXML
    void exibirDicaFlutuante(MouseEvent event) {
    	if(event.getTarget().toString().contains("inputUsuario")) {
        	labelDicaFlutuante.setText("E-mail");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("inputSenha")) {
        	labelDicaFlutuante.setText("Senha");
        	labelDicaFlutuante.setVisible(true);
    	}

    	labelDicaFlutuante.setLayoutX(event.getSceneX());
    	labelDicaFlutuante.setLayoutY(event.getSceneY());
    }

    @FXML
    void esconderDicaFlutuante(MouseEvent event) {
    	labelDicaFlutuante.setVisible(false);
    	
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
    
	void notificar(String tipoDeAviso, String titulo, String texto) {
		paneAvisosPrincipal.setDisable(false);
		paneAvisosPrincipal.setVisible(true);
		paneAvisosSombra.setVisible(true);
		paneAvisosSombra.setDisable(false);
		
		switch (tipoDeAviso) {
		case "Falha":
			paneAvisosFalha.setDisable(false);
			paneAvisosFalha.setVisible(true);
			labelAvisosTextoFalha.setText(texto);
			labelAvisosTituloFalha.setText(titulo);
			break;
		}
		
	}
	
    @FXML
    void fecharAviso(ActionEvent event) {
		paneAvisosPrincipal.setDisable(true);
		paneAvisosPrincipal.setVisible(false);
		paneAvisosSombra.setVisible(false);
		paneAvisosSombra.setDisable(true);
		paneAvisosFalha.setDisable(true);
		paneAvisosFalha.setVisible(false);
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

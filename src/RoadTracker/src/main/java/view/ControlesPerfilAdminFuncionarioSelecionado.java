package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Funcionario;

public class ControlesPerfilAdminFuncionarioSelecionado implements Initializable {

    @FXML
    private Button botaoBuscar;
    
    @FXML
    private TextField cpfFuncionario;

    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }

    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Funcionarios");
    }
    
    
    
    public static void carregarInfosFuncionario(String cpfFuncionario) {
    	// ---- função para ler as infos do funcionário pelo cpf aqui ---
    	// --- textField.setText(coisa do funcionario) ---- (uma linha dessas pra cada textField)
    	//(ainda vou setar para os campos estarem desativados para edição no começo)
    }
    
    @FXML
    void excluirFuncionario(ActionEvent event) {
		Funcionario funcionario = new Funcionario();
    	funcionario.removerFuncionario(cpfFuncionario.getText());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}

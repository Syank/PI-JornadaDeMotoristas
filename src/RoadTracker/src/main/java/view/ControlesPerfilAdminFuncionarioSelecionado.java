package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Funcionario;

public class ControlesPerfilAdminFuncionarioSelecionado implements Initializable {


    @FXML
    private CheckBox cbDomingo;

    @FXML
    private CheckBox cbSegunda;

    @FXML
    private CheckBox cbTerca;

    @FXML
    private CheckBox cbQuarta;

    @FXML
    private CheckBox cbQuinta;

    @FXML
    private CheckBox cbSexta;

    @FXML
    private CheckBox cbSabado;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField pfSenha;

    @FXML
    private TextField tfCargaHoraria;

    @FXML
    private ComboBox<?> cbFilial;

    @FXML
    private Label lblNome;
	
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
    	Funcionario funcionario = new Funcionario();
    	funcionario = funcionario.encontrarFuncionario(cpfFuncionario);
    	
    	System.out.println(funcionario.getNome());
    	System.out.println(funcionario.getCpf());
    	System.out.println(funcionario.getCargo());
    	System.out.println(funcionario.getSenha());
    	System.out.println(funcionario.getFk_filiais_id());
    	
    	
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

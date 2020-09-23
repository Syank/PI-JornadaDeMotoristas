package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Funcionario;

public class ControlesPerfilAdminFuncionarioSelecionado implements Initializable {

	private static Funcionario funcionario = new Funcionario();

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
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }
    
    @FXML
    void abrirTelaFuncionarios(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
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
    
    
  
    @FXML
    void mudar(ActionEvent event) {
    	carregarInfosFuncionario();
    }
    
    
    public static void escolherFuncionario(String cpf) {
    	funcionario = funcionario.encontrarFuncionario(cpf);

    }
    
    
    
    public void carregarInfosFuncionario() {
    	tfNome.setText(funcionario.getNome());
    	tfCpf.setText(funcionario.getCpf());

    }
    
    @FXML
    void excluirFuncionario(ActionEvent event) {
		funcionario.removerFuncionario(funcionario.getCpf());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
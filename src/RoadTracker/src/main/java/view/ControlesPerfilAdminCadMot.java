package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Funcionario;

public class ControlesPerfilAdminCadMot {
	
	private ComboBox<Cargos> cbCargo;
	private TextField tfNome;
	private TextField tfCpf;
	private PasswordField pfSenha1;
	private PasswordField pfSenha2;
	private ComboBox cbFilial;
	private TextField tfCargaHoraria;
	private CheckBox cbDomingo;
	private CheckBox cbSegunda;
	private CheckBox cbTerca;
	private CheckBox cbQuarta;
	private CheckBox cbQuinta;
	private CheckBox cbSexta;
	private CheckBox cbSabado;
	
    private List<Cargos> cargos = new ArrayList<>();
    private ObservableList<Cargos> cargosList;

    public void carregarComboBox() {
    	
    	Funcionario funcionario = new Funcionario();

    	cargos = funcionario.listarCargos();
    	cargosList = FXCollections.observableArrayList(cargos);
    	cbCargo.setItems(cargosList);
    }
	

    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	System.out.println("Clicou em func");
    	Main.trocarTela("Tela Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	System.out.println("Clicou em hist ent");
    	Main.trocarTela("Tela Historico de Entregas");
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void cadastrarFuncionario(MouseEvent event) {
    	
    	// Todos os funcionários
    	String cargo = cbCargo.getId();
    	String nome = tfNome.getText();
    	String cpf = tfCpf.getText();
    	String senha = pfSenha1.getText();
    	String senha2 = pfSenha2.getText();
    	int filial = Integer.parseInt(cbFilial.getId());
    	
    	// Motoristas: Jornada de trabalho
    	int cargaHoraria = Integer.parseInt(tfCargaHoraria.getText());
    	boolean dom = cbDomingo.isSelected();
    	boolean seg = cbSegunda.isSelected();
    	boolean ter = cbTerca.isSelected();
    	boolean qua = cbQuarta.isSelected();
    	boolean qui = cbQuinta.isSelected();
    	boolean sex = cbSexta.isSelected();
    	boolean sab = cbSabado.isSelected();
    	
    	Funcionario funcionario = new Funcionario();
    	if (senha == senha2) {
    		funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial);
    		if (cargo == "motorista") {
    			funcionario.cadastrarJornadaTrabalho(cpf, cargaHoraria, seg, ter, qua, qui, sex, sab, dom);
    		}
    	}
    	else {
    		System.err.println("Senhas diferentes");
    	}
    }
}

package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Funcionario;

public class ControlesPerfilAdminCadMot implements Initializable {
	
	@FXML
	private ComboBox<Cargos> cbCargo;
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCpf;
	@FXML
	private PasswordField pfSenha1;
	@FXML
	private PasswordField pfSenha2;
	@FXML
	private ComboBox<Filiais> cbFilial;
	@FXML
	private TextField tfCargaHoraria;
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


	
    private List<Cargos> cargos = new ArrayList<>();
    private ObservableList<Cargos> cargosList;
    
    private List<Filiais> filiais = new ArrayList<>();
    private ObservableList<Filiais> filiaisList;

    public void carregarComboBoxCargos() {
    	Funcionario funcionario = new Funcionario();
    	cargos = funcionario.listarCargos();
    	cargosList = FXCollections.observableArrayList(cargos);
    	cbCargo.setItems(cargosList);
    	
    }
    
    public void carregarComboBoxFiliais() {
    	Funcionario funcionario = new Funcionario();
    	filiais = funcionario.listarFiliais();
    	filiaisList = FXCollections.observableArrayList(filiais);
    	cbFilial.setItems(filiaisList);
    }
	
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Boas Vindas");
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
    
    @FXML
    void cadastrarFuncionario(MouseEvent event) {
    	
    	// Todos os funcionários
    	String cargo = cbCargo.getValue().getCargo();
    	String nome = tfNome.getText();
    	String cpf = tfCpf.getText();
    	String senha = pfSenha1.getText();
    	String senha2 = pfSenha2.getText();
    	int filial = cbFilial.getValue().getId();
    	
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

    	if (senha.equals(senha2)) {
    		System.err.println(filial);
    		funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial);
    		if (cargo.equals("Motorista")) {
    			funcionario.cadastrarJornadaTrabalho(cpf, cargaHoraria, seg, ter, qua, qui, sex, sab, dom);
    		}
    	}
    	else {
    		System.err.println("Senhas diferentes");
    	}

    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxCargos();
		carregarComboBoxFiliais();
	}
}

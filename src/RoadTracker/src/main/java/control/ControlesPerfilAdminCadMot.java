package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;
import view.*;

public class ControlesPerfilAdminCadMot implements Initializable {
	
	//Elementos da pane de avisos
    @FXML
    private Pane paneAvisosPrincipal;
    @FXML
    private Pane paneAvisosSucesso;
    @FXML
    private Label labelAvisosTituloSucesso;
    @FXML
    private Label labelAvisosTextoSucesso;
    @FXML
    private Pane paneAvisosFalha;
    @FXML
    private Label labelAvisosTituloFalha;
    @FXML
    private Label labelAvisosTextoFalha;
    @FXML
    private Pane paneAvisosSombra;
    // ---------------------------
    
    
    //Elementos da pane de cadastro de funcion�rios
    @FXML
    private Pane paneCadastrarFuncionarios;
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
    // --------------------------------------------
    
	
    //Elementos da pane de cadastro de filiais
    @FXML
    private Pane paneCadastrarFiliais;
    
    @FXML
    private Button botaoCadastrarFilial;

    @FXML
    private TextField tfNomeFilial;

    @FXML
    private TextField tfCidadeFilial;

    @FXML
    private TextField tfEstadoFilial;
    // ---------------------------------------
    
    
    //Elementos da pane de cadastro de ve�culos
    @FXML
    private Pane paneCadastrarVeiculos;
    // ----------------------------------------
    
    
    //Elementos da pane de cadastro de viagens
    @FXML
    private Pane paneCadastrarViagens;
    // ----------------------------------------
    
    
    //Elementos da pane para escolher tipo de cadastro
    @FXML
    private Pane paneEscolherTipoDeCadastro;
    // ----------------------------------------
    

    
    //M�todos da pane de cadastrar funcion�rio
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
    void cadastrarFuncionario(MouseEvent event) {
    	// Todos os funcion�rios
    	String nome = tfNome.getText();
    	String cpf = tfCpf.getText();
    	String senha = pfSenha1.getText();
    	String senha2 = pfSenha2.getText();
    	String cargo = cbCargo.getValue().getCargo();
    	int filial = cbFilial.getValue().getId();
    	String cargaHoraria = tfCargaHoraria.getText();
    	boolean dom = cbDomingo.isSelected();
    	boolean seg = cbSegunda.isSelected();
    	boolean ter = cbTerca.isSelected();
    	boolean qua = cbQuarta.isSelected();
    	boolean qui = cbQuinta.isSelected();
    	boolean sex = cbSexta.isSelected();
    	boolean sab = cbSabado.isSelected();
    	
    	Funcionario funcionario = new Funcionario();

    	if (senha.equals(senha2)) {
    		funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial, cargaHoraria, seg, ter, qua, qui, sex, sab, dom);
    		notificar("Sucesso de cadastro", "Funcion�rio cadastrado", "O " + cargo + " " + nome + " foi cadastrado com sucesso!");
    	}
    	else {
    		notificar("Falha de cadastro", "Falha ao cadastrar", "As senhas est�o incorretas, tente novamente");
    		System.err.println("Senhas diferentes");
    	}

    }
    // -----------------------------------

    
    // M�todos gerais
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
    	if(paneEscolherTipoDeCadastro.isVisible()) {
    	Main.trocarTela("Tela Boas Vindas");
    	}else {
    		voltarParaTelaDeEscolhas(event);
    	}
    }
    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void abrirTelaCadastrarFuncionarios(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(true);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(false);
    	paneEscolherTipoDeCadastro.setDisable(true);
    }
    @FXML
    void abrirTelaCadastrarFiliais(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(true);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(false);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(true);
    }
    @FXML
    void abrirTelaCadastrarVeiculos(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(true);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(false);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(true);
    }
    @FXML
    void abrirTelaCadastrarViagens(MouseEvent event){
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(true);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(false);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(false);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(true);
    }
    @FXML
    void voltarParaTelaDeEscolhas(ActionEvent event) {
    	paneCadastrarVeiculos.setVisible(false);
    	paneCadastrarFiliais.setVisible(false);
    	paneCadastrarViagens.setVisible(false);
    	paneCadastrarFuncionarios.setVisible(false);
    	paneEscolherTipoDeCadastro.setVisible(true);
    	
    	paneCadastrarVeiculos.setDisable(true);
    	paneCadastrarFiliais.setDisable(true);
    	paneCadastrarViagens.setDisable(true);
    	paneCadastrarFuncionarios.setDisable(true);
    	paneEscolherTipoDeCadastro.setDisable(false);
    }
    
    
    void notificar(String tipoDeAviso, String titulo, String texto) {
    	paneAvisosPrincipal.setDisable(false);
    	paneAvisosPrincipal.setVisible(true);
    	paneAvisosSombra.setVisible(true);
    	paneAvisosSombra.setDisable(false);
    	switch(tipoDeAviso){
    		case "Sucesso de cadastro":
    			paneAvisosSucesso.setDisable(false);
    			paneAvisosSucesso.setVisible(true);
    			labelAvisosTextoSucesso.setText(texto);
    			labelAvisosTituloSucesso.setText(titulo);
    			break;
    		case "Falha de cadastro":
    			paneAvisosFalha.setDisable(false);
    			paneAvisosFalha.setVisible(true);
    			labelAvisosTextoFalha.setText(texto);
    			labelAvisosTituloFalha.setText(titulo);
    			break;
    	}
    }
    @FXML
    void fecharAviso(ActionEvent event){
    	paneAvisosPrincipal.setDisable(true);
    	paneAvisosPrincipal.setVisible(false);
    	paneAvisosSombra.setVisible(false);
    	paneAvisosSombra.setDisable(true);
		paneAvisosSucesso.setDisable(true);
		paneAvisosSucesso.setVisible(false);
		paneAvisosFalha.setDisable(true);
		paneAvisosFalha.setVisible(false);
    }
    
    @FXML
    void cadastrarFilial(ActionEvent event) {
    	
    	Filial f = new Filial();
    	
    	String nome = tfNomeFilial.getText();
    	String cidade = tfCidadeFilial.getText();
    	String estado = tfEstadoFilial.getText();
    	
    	f.cadastrarFilial(nome, cidade, estado);
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxCargos();
		carregarComboBoxFiliais();
	}
}

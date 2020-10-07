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

public class ControlesPerfilAdminCadastrarEntidades implements Initializable {
	
	@FXML
	private Label labelTipoDeCadastro;
	
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
    
    
    //Elementos da pane de cadastro de funcionários
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
    @FXML
    private ComboBox<Turnos> cbTurno;
	
    private List<Cargos> cargos = new ArrayList<>();
    private ObservableList<Cargos> cargosList;
    
    private List<Filiais> filiais = new ArrayList<>();
    private ObservableList<Filiais> filiaisList;
    
    private List<Turnos> turnos = new ArrayList<>();
    private ObservableList<Turnos> turnosList;
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
    
    
    //Elementos da pane de cadastro de veículos
    @FXML
    private Pane paneCadastrarVeiculos;
    @FXML
    private TextField textFieldMarcaRastreador;
    @FXML
    private TextField textFieldVersaoRastreador;
    @FXML
    private TextField textFieldIDRastreador;
    @FXML
    private TextField textFieldPlacaVeiculo;
    @FXML
    private TextField textFieldFuncionarioVeiculo;
    // ----------------------------------------
    
    
    //Elementos da pane de cadastro de viagens
    @FXML
    private Pane paneCadastrarViagens;
    
    @FXML
    private TextField tfViagemInit;

    @FXML
    private TextField tfEmpresaDestino;

    @FXML
    private TextField tfViagemFim;

    @FXML
    private TextField tfIDRastreador;

    @FXML
    private TextField tfMotoristaViagem;
    // ----------------------------------------
    
    
    //Elementos da pane para escolher tipo de cadastro
    @FXML
    private Pane paneEscolherTipoDeCadastro;
    // ----------------------------------------
    

    
    //Métodos da pane de cadastrar funcionário
    public void carregarComboBoxCargos() {
    	Funcionario funcionario = new Funcionario();
    	cargos = funcionario.listarCargos();
    	cargosList = FXCollections.observableArrayList(cargos);
    	cbCargo.setItems(cargosList);
    } 

    public void carregarComboBoxFiliais() {
    	Filial filial = new Filial();
    	filiais = filial.listarFiliais();
    	filiaisList = FXCollections.observableArrayList(filiais);
    	cbFilial.setItems(filiaisList);
    }
    public void carregarComboBoxTurnos() {
    	Turnos t = new Turnos(0, null);
    	turnos = t.listarTurnos();
    	turnosList = FXCollections.observableArrayList(turnos);
    	cbTurno.setItems(turnosList);
    } 
    @FXML
    void cadastrarFuncionario(MouseEvent event) {
    	// Todos os funcionários
    	String nome = tfNome.getText();
    	String cpf = tfCpf.getText();
    	String senha = pfSenha1.getText();
    	String senha2 = pfSenha2.getText();
    	String cargo = cbCargo.getValue().getCargo();
    	int filial = cbFilial.getValue().getId();
    	String email = "teste";
    	
    	Funcionario funcionario = new Funcionario();

    	if (senha.equals(senha2)) {
    		funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial, email);
    		notificar("Sucesso de cadastro", "Funcionário cadastrado", "O " + cargo + " " + nome + " foi cadastrado com sucesso!");
    	}
    	else {
    		notificar("Falha de cadastro", "Falha ao cadastrar", "As senhas estão incorretas, tente novamente");
    	}
    }
    // -----------------------------------
    
    // Métodos da pane para cadastro da filial 
    @FXML
    void cadastrarFilial(ActionEvent event) {
    	
    	Filial f = new Filial();
    	
    	String nome = tfNomeFilial.getText();
    	String cidade = tfCidadeFilial.getText();
    	String estado = tfEstadoFilial.getText();
    	
    	f.cadastrarFilial(nome, cidade, estado);
    	
    	notificar("Sucesso de cadastro", "Filial cadastrada", "A filial " + nome + " foi cadastrada com sucesso!");
    }
    
    // ----------------------------------------
    
    
    
    // Métodos para cadastro de veículos
    @FXML
    void cadastrarVeiculo(ActionEvent event) {
        	
        Veiculo veic = new Veiculo();
        	
        String id_rastreador = textFieldIDRastreador.getText();
        String placa = textFieldPlacaVeiculo.getText();
        String versao = textFieldVersaoRastreador.getText();
        String marca_rastreador = textFieldMarcaRastreador.getText();
        String cpfFuncionario = textFieldFuncionarioVeiculo.getText();
        
        veic.cadastrarVeiculo(id_rastreador, placa, versao, marca_rastreador);
        
        notificar("Sucesso de cadastro", "Veículo cadastrado", "O veículo com a placa " + placa + " foi cadastrado com sucesso!");
    	
    }
    // --------------------------------------------
    
    
    // Métodos da pane de cadastro de viagem
    @FXML
    void cadastrarViagem(ActionEvent event) {
    	
    }
    // ---------------------------------------
    


    
    // Métodos gerais
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    	Main.trocarTela("Tela Funcionarios");
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	voltarTelaEscolhas();
    }
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    	Main.trocarTela("Tela Historico de Entregas");
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	voltarTelaEscolhas();
    }
    @FXML
    void voltar(ActionEvent event) {   	
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    	if(paneEscolherTipoDeCadastro.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    	else {  	
    		voltarParaTelaDeEscolhas(event);
    	}
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
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
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastro de Funcionários");
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
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastro de Filiais");
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
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastro de Veículos");
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
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastro de Viagens");
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
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
    }
    
    public void voltarTelaEscolhas() {
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
    	limparCamposCadastrarFuncionarios();
    	limparCamposCadastrarFiliais();
    	limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    	
    	labelTipoDeCadastro.setText("Cadastrar Entidades");
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
		limparCamposCadastrarFuncionarios();
		limparCamposCadastrarFiliais();
		limparCamposCadastrarViagens();
    	limparCamposCadastrarVeículos();
    }
    public void limparCamposCadastrarFiliais() {
    	tfNomeFilial.setText("");
    	tfCidadeFilial.setText("");
    	tfEstadoFilial.setText("");
    }
    public void limparCamposCadastrarFuncionarios() {
     	tfNome.setText("");
    	tfCpf.setText("");
    	tfCargaHoraria.setText("");
    	pfSenha1.setText("");
    	pfSenha2.setText("");
    	cbDomingo.setSelected(false);
    	cbSegunda.setSelected(false);
    	cbTerca.setSelected(false);
    	cbQuarta.setSelected(false);
    	cbQuinta.setSelected(false);
    	cbSexta.setSelected(false);
    	cbSabado.setSelected(false);
    	cbCargo.getSelectionModel().clearSelection();
    }
    public void limparCamposCadastrarVeículos() {
    	textFieldMarcaRastreador.setText("");
    	textFieldVersaoRastreador.setText("");
    	textFieldIDRastreador.setText("");
        textFieldPlacaVeiculo.setText("");
        textFieldFuncionarioVeiculo.setText("");
    	
    }
    public void limparCamposCadastrarViagens() {
    	tfEmpresaDestino.setText("");
    	tfViagemInit.setText("");
    	tfViagemFim.setText("");
    	tfMotoristaViagem.setText("");
    	tfIDRastreador.setText("");
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxCargos();
		carregarComboBoxFiliais();
		carregarComboBoxTurnos();
	}
}

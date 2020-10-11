package control;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
    @FXML
    private TextField textFieldSalario;
    @FXML
    private Pane paneInfosExtrasMotorista;
    @FXML
    private TextField textFieldEmail;
	
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
    @FXML
    private TextField tfCnpj;
    @FXML
    private TextField tfRntrc;
    // ---------------------------------------
    
    
    //Elementos da pane de cadastro de veículos
    @FXML
    private Pane paneCadastrarVeiculos;
    @FXML
    private TextField textFieldMarcaRastreador;
    @FXML
    private TextField textFieldModeloRastreador;
    @FXML
    private TextField textFieldIDRastreador;
    @FXML
    private TextField textFieldPlacaVeiculo;
    @FXML
    private TextField textFieldModeloVeiculo;
    @FXML
    private ComboBox<Filiais> comboBoxEscolherFilialVeiculos;
    // ----------------------------------------
    
    
    //Elementos da pane de cadastro de viagens
    @FXML
    private Pane paneCadastrarViagens;
    @FXML
    private TextField tfEmpresaDestino;
    @FXML
    private TextField textFieldCarga;
    @FXML
    private DatePicker datePickerPrazoEntrega;
    @FXML
    private ComboBox<Veiculos> comboBoxVeiculoViagem;
    @FXML
    private ComboBox<Funcionarios> comboBoxMotoristaViagem;
    
    private List<Funcionarios> motoristas = new ArrayList<>();
    private ObservableList<Funcionarios> obsListMotoristas;
    
    private List<Veiculos> veiculos = new ArrayList<>();
    private ObservableList<Veiculos> obsListVeiculos;
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
    	comboBoxEscolherFilialVeiculos.setItems(filiaisList);
    }
    public void carregarComboBoxTurnos() {
    	Turnos t = new Turnos(0, null);
    	turnos = t.listarTurnos();
    	turnosList = FXCollections.observableArrayList(turnos);
    	cbTurno.setItems(turnosList);
    } 
    public void carregarComboBoxMotoristas() {
    	Motorista motorista = new Motorista();
    	motoristas = motorista.listarMotoristas();
    	obsListMotoristas = FXCollections.observableArrayList(motoristas);
    	comboBoxMotoristaViagem.setItems(obsListMotoristas);
    }
    public void carregarComboBoxVeiculos() {
    	Veiculo veiculo = new Veiculo();
    	veiculos = veiculo.listarVeiculos();
    	obsListVeiculos = FXCollections.observableArrayList(veiculos);
    	comboBoxVeiculoViagem.setItems(obsListVeiculos);
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
    	String email = textFieldEmail.getText();
    	
    	
    	if(cpf.length() == 11) {
        	Funcionario funcionario = new Funcionario();
        	

    		// Primeiro verifica se o cpf não está sendo usado, depois verifica se o email não está sendo usado
        	if (cargo.equals("Administrador") || cargo.equals("Supervisor")) {
            	if(funcionario.encontrarFuncionario(cpf) == null) {
                	if(!funcionario.getEmail().equals(email)) {
                    	if (senha.equals(senha2)) {
                    		boolean cadastro = funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial, email);
                    		
                    		if(cadastro) {
                    			notificar("Sucesso de cadastro", "Funcionário cadastrado", "O " + cargo + " " + nome + " foi cadastrado com sucesso!");
                    		}else {
                    			notificar("Falha de cadastro", "Falha ao cadastrar funcionário", "Não foi possível realizar a ação de cadastro, confira os campos e tente novamente.");
                    		}
                    	
                    	}else {
                    		notificar("Falha de cadastro", "Falha ao cadastrar funcionário", "Não foi possível realizar a ação de cadastro, os campos da senha estão incorretos.");
                    	}
                	}
            	}else {
            		notificar("Falha de cadastro", "Falha ao cadastrar funcionário", 
            				"O CPF informado já está sendo utilizado por outro funcionário, "
            				+ "por favor verifique o campo ou exclua o funcionário com o CPF em questão");
            		
            	}
        	}
        	else {
        		
        		String salario = textFieldSalario.getText();
        		String cargaHoraria = tfCargaHoraria.getText();
        		String turno = cbTurno.getValue().getTurno();
        		boolean dom = cbDomingo.isSelected();
        		boolean seg = cbSegunda.isSelected();
        		boolean ter = cbTerca.isSelected();
        		boolean qua = cbQuarta.isSelected();
        		boolean qui = cbQuinta.isSelected();
        		boolean sex = cbSexta.isSelected();
        		boolean sab = cbSabado.isSelected();
        		
        		Motorista motorista = new Motorista();
        		

        		// Primeiro verifica se o cpf não está sendo usado, depois verifica se o email não está sendo usado
        		if(motorista.encontrarMotorista(cpf) == null) {
            		if(!motorista.getEmail().equals(email)) {
                    	if (senha.equals(senha2)) {
                    		boolean cadastro = motorista.cadastrarMotorista(cpf, nome, email, senha, salario, cargaHoraria, filial, turno, seg, ter, qua, qui, sex, sab, dom, cargo);
                    	
                    		if(cadastro) {
                    			notificar("Sucesso de cadastro", "Funcionário cadastrado", "O " + cargo + " " + nome + " foi cadastrado com sucesso!");
                    		}else {
                    			notificar("Falha de cadastro", "Falha ao cadastrar funcionário", "Não foi possível realizar a ação de cadastro, confira os campos e tente novamente.");
                    		}
                    	}else {
                    		notificar("Falha de cadastro", "Falha ao cadastrar", "As senhas estão incorretas, tente novamente");
                    	}
            		}
        		}else {
            		notificar("Falha de cadastro", "Falha ao cadastrar funcionário", 
            				"O CPF informado já está sendo utilizado por outro motorista, "
            				+ "por favor verifique o campo ou exclua o motorista com o CPF em questão");
        		}
        	}
    	}else {
    		notificar("Falha de cadastro", "CPF inválido", "O CPF informado é inválido, "
    				+ "por favor confira o campo e insira um CPF, somente os números, de 11 dígitos");
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
    	String cnpj = tfCnpj.getText();
    	String rntrc = tfRntrc.getText();
    	
    	f.cadastrarFilial(nome, cidade, estado, cnpj, rntrc);
    	
    	notificar("Sucesso de cadastro", "Filial cadastrada", "A filial " + nome + " foi cadastrada com sucesso!");
    }
    
    // ----------------------------------------
    
    
    
    // Métodos para cadastro de veículos
    @FXML
    void cadastrarVeiculo(ActionEvent event) {
        	
        Veiculo veic = new Veiculo();
        	
        String placa = textFieldPlacaVeiculo.getText();
        String modelo_veiculo = textFieldModeloVeiculo.getText();
        String id_rastreador = textFieldIDRastreador.getText();
        String marca_rastreador = textFieldMarcaRastreador.getText();
        String modelo_rastreador = textFieldModeloRastreador.getText();
    	int filial = comboBoxEscolherFilialVeiculos.getValue().getId();
        
        
        veic.cadastrarVeiculo(placa, modelo_veiculo, id_rastreador, marca_rastreador, modelo_rastreador, filial);
        
        notificar("Sucesso de cadastro", "Veículo cadastrado", "O veículo com a placa " + placa + " foi cadastrado com sucesso!");
    	
    }
    // --------------------------------------------
    
    
    // Métodos da pane de cadastro de viagem
    @FXML
    void cadastrarViagem(ActionEvent event) {
    	Viagem viagem = new Viagem();
    	int ano = datePickerPrazoEntrega.getValue().getYear();
    	int dia = datePickerPrazoEntrega.getValue().getDayOfMonth();
    	int mes = datePickerPrazoEntrega.getValue().getMonthValue();
    	String prazo = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
    	
    	String cpfFuncionario = comboBoxMotoristaViagem.getSelectionModel().getSelectedItem().getCpf();
    	String placaVeiculo = comboBoxVeiculoViagem.getSelectionModel().getSelectedItem().getPlaca();
    	
    	viagem.cadastrarViagem(prazo, tfEmpresaDestino.getText(), 
    						   cpfFuncionario, placaVeiculo, 
    						   textFieldCarga.getText());
        notificar("Sucesso de cadastro", "Viagem cadastrada", "A viagem foi cadastrada no sistema com sucesso!");
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
    	
    	paneInfosExtrasMotorista.setDisable(true);
    	paneInfosExtrasMotorista.setVisible(false);
    	
    	carregarComboBoxFiliais();
    	
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
    	
    	carregarComboBoxFiliais();
    	
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
    	
    	carregarComboBoxVeiculos();
    	carregarComboBoxMotoristas();
    	
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
    
    @FXML
    public void ajustarEscolhaDoCargo(ActionEvent event) {
    	String escolha = cbCargo.getValue().getCargo();
    	
    	if(escolha.equals("Motorista")) {
    		paneInfosExtrasMotorista.setDisable(false);
    		paneInfosExtrasMotorista.setVisible(true);
    	}else {
    		paneInfosExtrasMotorista.setDisable(true);
    		paneInfosExtrasMotorista.setVisible(false);
    	}
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
    	textFieldSalario.setText("");
    	cbTurno.getSelectionModel().clearSelection();
    	textFieldEmail.setText("");
    }
    public void limparCamposCadastrarVeículos() {
    	textFieldMarcaRastreador.setText("");
    	textFieldModeloRastreador.setText("");
    	textFieldIDRastreador.setText("");
        textFieldPlacaVeiculo.setText("");
        textFieldModeloVeiculo.setText("");
    	
    }
    public void limparCamposCadastrarViagens() {
    	tfEmpresaDestino.setText("");
    	textFieldCarga.setText("");
    	datePickerPrazoEntrega.setValue(LocalDate.now());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxCargos();
		carregarComboBoxFiliais();
		carregarComboBoxTurnos();
		carregarComboBoxMotoristas();
		carregarComboBoxVeiculos();
	}
}

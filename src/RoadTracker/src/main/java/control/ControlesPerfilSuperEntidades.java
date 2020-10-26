package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Aviso;
import model.Filial;
import view.Filiais;
import view.Turnos;

public class ControlesPerfilSuperEntidades implements Initializable{

	 	@FXML
	    private Pane paneMotoristaSelecionado;
	    @FXML
	    private VBox boxInfoExtraMotorista2;
	    @FXML
	    private TextField tfCargaHoraria;
	    @FXML
	    private CheckBox cbDom;
	    @FXML
	    private CheckBox cbSeg;
	    @FXML
	    private CheckBox cbTer;
	    @FXML
	    private CheckBox cbQua;
	    @FXML
	    private CheckBox cbQui;
	    @FXML
	    private CheckBox cbSex;
	    @FXML
	    private CheckBox cbSab;
	    @FXML
	    private Button btnSalvar;
	    @FXML
	    private Button btnDescartar;
	    @FXML
	    private Label lblNome;
	    @FXML
	    private ComboBox<?> cbCargo;
	    @FXML
	    private ComboBox<?> cbFilial;
	    @FXML
	    private VBox boxInfoExtraMotorista1;
	    @FXML
	    private ComboBox<?> cbTurno;
	    @FXML
	    private TextField textFieldSalarioMotorista;
	    @FXML
	    private TextField tfNome;
	    @FXML
	    private TextField tfCpf;
	    @FXML
	    private TextField textFieldEmail;
	    @FXML
	    private PasswordField pfSenha;
	    @FXML
	    private Label labelSituacaoMotorista;
	    @FXML
	    private Pane paneCadastrarMotorista;
	    @FXML
	    private ComboBox<Filiais> comboBoxCadastroFilial;
	    @FXML
	    private Pane paneInfosExtrasMotorista;
	    @FXML
	    private CheckBox checkBoxDomingo;
	    @FXML
	    private CheckBox checkBoxSegunda;
	    @FXML
	    private CheckBox checkBoxTerca;
	    @FXML
	    private CheckBox checkBoxQuarta;
	    @FXML
	    private CheckBox checkBoxQuinta;
	    @FXML
	    private CheckBox checkBoxSexta;
	    @FXML
	    private CheckBox checkBoxSabado;
	    @FXML
	    private ComboBox<Turnos> comboBoxCadastroTurno;
	    @FXML
	    private TextField textFieldCadastroCargaHoraria;
	    @FXML
	    private TextField textFieldCadastroSalario;
	    @FXML
	    private TextField textFieldCadastroNome;
	    @FXML
	    private TextField textFieldCadastroCpf;
	    @FXML
	    private TextField textFieldCadastroEmail;
	    @FXML
	    private PasswordField textFieldCadastroSenha;
	    @FXML
	    private PasswordField textFieldCadastroConfirmarSenha;
	    @FXML
	    private Pane paneMotoristas;
	    @FXML
	    private Button btSelecionarFuncionario;
	    @FXML
	    private Button botaoBuscar;
	    @FXML
	    private TableView<?> tabelaFuncionarios;
	    @FXML
	    private TableColumn<?, ?> colunaNome;
	    @FXML
	    private TableColumn<?, ?> colunaCpf;
	    @FXML
	    private TableColumn<?, ?> colunaCargo;
	    @FXML
	    private TextField campoDeBuscaNome;
	    @FXML
	    private TextField campoDeBuscaCpf;
	    @FXML
	    private Pane paneSelecionarOpcao;
	    @FXML
	    private Label labelDicaFlutuante;
	    @FXML
	    private Pane paneAvisosPrincipal;
	    @FXML
	    private Pane paneAvisosSombra;
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
	    private Pane paneAvisosConfirmar;
	    @FXML
	    private Label labelAvisosTituloConfirmar;
	    @FXML
	    private Label labelAvisosTextoConfirmar;
	    @FXML
	    private PasswordField passwordFieldConfirmarSenha;
	    
	    
	    
	    
	    // Só estão os métodos das ações dos botões aqui, os outros como carregar tableview devem ser criados
	    
	    




	    @FXML
	    void confirmarAlteracao(ActionEvent event) {

	    }

	    @FXML
	    void descartarAlteracoes(ActionEvent event) {

	    }

	    @FXML
	    void esconderDicaFlutuante(MouseEvent event) {

	    }

	    @FXML
	    void exibirDicaFlutuante(MouseEvent event) {

	    }

	    @FXML
	    void fecharAviso(ActionEvent event) {

	    }

	    @FXML
	    void habilitarEdicao(ActionEvent event) {

	    }

	    @FXML
	    void requisitarAlteracaoFuncionario(ActionEvent event) {

	    }

	    @FXML
	    void selecionarFuncionario(ActionEvent event) {

	    }

	    @FXML
	    void solicitarCadastro(ActionEvent event) {
	    	Aviso aviso = new Aviso();
	    	
	    	String solicitacao = "";
	    	
	    	String nome = textFieldCadastroNome.getText();
	    	String cpf = textFieldCadastroCpf.getText();
	    	String email = textFieldCadastroEmail.getText();
	    	String senha = textFieldCadastroSenha.getText();
	    	String cargaHoraria = textFieldCadastroCargaHoraria.getText();
	    	String salario = textFieldCadastroSalario.getText();
	    	
	    	int idFilial = comboBoxCadastroFilial.getValue().getId();
	    	String nomeFilial = new Filial().encontrarFilial(idFilial).getNome();
	    	String turno = comboBoxCadastroTurno.getValue().getTurno();
	    	
	    	boolean dom = checkBoxDomingo.isSelected();
	    	boolean seg = checkBoxSegunda.isSelected();
	    	boolean ter = checkBoxTerca.isSelected();
	    	boolean qua = checkBoxQuarta.isSelected();
	    	boolean qui = checkBoxQuinta.isSelected();
	    	boolean sex = checkBoxSexta.isSelected();
	    	boolean sab = checkBoxSabado.isSelected();
	    	String diasDeTrabalho = "";
	    	
	    	if(dom) {
	    		diasDeTrabalho += "Domingo";
	    	}
	    	if(seg) {
	    		diasDeTrabalho += ", Segunda-Feira";
	    	}
	    	if(ter) {
	    		diasDeTrabalho += ", Terça-Feira";
	    	}
	    	if(qua) {
	    		diasDeTrabalho += ", Quarta-Feira";
	    	}
	    	if(qui) {
	    		diasDeTrabalho += ", Quinta-Feira";
	    	}
	    	if(sex) {
	    		diasDeTrabalho += ", Sexta-Feira";
	    	}
	    	if(sab) {
	    		diasDeTrabalho += " e Sábado";
	    	}
	    	if(!dom) {
	    		diasDeTrabalho = diasDeTrabalho.substring(2); // Tira ", " caso não trabalhe domingo
	    	}
	    	
	    	solicitacao = "Solicito o cadastro do motorista com as seguintes informações:\n"
	    				+ "Nome: " + nome + "\n"
	    				+ "CPF: " + cpf + "\n"
	    				+ "E-mail: " + email + "\n"
	    				+ "Senha: " + senha + "\n"
	    				+ "Carga Horária: " + cargaHoraria + "\n"
	    				+ "Salário: " + salario + "\n"
	    				+ "Turno: " + turno + "\n"
	    				+ "Dias de trabalho: " + diasDeTrabalho + "\n"
	    				+ "Pertencendo a Filial " + nomeFilial + ", de ID igual a: " + String.valueOf(idFilial);
	    	
	    	aviso.solicitarCadastro(ControlesLogin.cpfLogado, solicitacao);
	    	
	    	System.out.println("Solicitação enviada!");
	    }
	    
	    
	    @FXML
	    void abrirTelaSolicitarCadastro(MouseEvent event) {
	    	paneSelecionarOpcao.setVisible(false);
	    	paneSelecionarOpcao.setDisable(true);
	    	
	    	paneCadastrarMotorista.setVisible(true);
	    	paneCadastrarMotorista.setDisable(false);
	    	
	    }
	    
	    
	    @FXML
	    void abrirTelaSelecionarMotorista(MouseEvent event) {

	    }
	    
	    
	    
	    @FXML
	    void abrirTelaMotoristas(MouseEvent event) {

	    }
	    
	    @FXML
	    void abrirTelaAvisos(MouseEvent event) {

	    }

	    @FXML
	    void abrirTelaHistEntregas(MouseEvent event) {

	    }
	    
	    
	    
	    
	    
	    // Essas 3 funções a baixo você pode copiar das outras telas
	    @FXML
	    void minimizarJanela(ActionEvent event) {

	    }
	    
	    @FXML
	    void fecharJanela(ActionEvent event) {

	    }
	    
	    @FXML
	    void voltar(MouseEvent event) {

	    }
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Coloque as funções para carregar as tableviews e combobox aqui
		
	}

}

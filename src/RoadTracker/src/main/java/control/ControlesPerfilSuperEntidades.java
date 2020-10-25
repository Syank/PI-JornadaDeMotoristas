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
	    private ComboBox<?> comboBoxCadastroFilial;
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
	    private ComboBox<?> comboBoxCadastroTurno;
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

	    }

	    @FXML
	    void solicitarExclusao(ActionEvent event) {

	    }
	    
	    
	    
	    
	    
	    @FXML
	    void abrirTelaSolicitarCadastro(MouseEvent event) {
	    	
	    }
	    
	    @FXML
	    void abrirTelaMotoristas(MouseEvent event) {

	    }
	    
	    @FXML
	    void abrirTelaAvisos(MouseEvent event) {

	    }

	    @FXML
	    void abrirTelaSelecionarMotorista(MouseEvent event) {

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

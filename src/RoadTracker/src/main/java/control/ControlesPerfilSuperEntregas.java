package control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Viagem;
import view.Main;
import view.Viagens;

public class ControlesPerfilSuperEntregas implements Initializable {

    @FXML
    private Pane paneSelecionarViagem;
    @FXML
    private TextField campoDeBuscaNome;
    @FXML
    private TextField campoDeBuscaCpf;
    @FXML
    private Button botaoBuscar;
    @FXML
    private TextField campoDeBuscaMotorista;
    @FXML
    private TableView<Viagens> tabela;
    @FXML
    private TableColumn<?, ?> colunaId;
    @FXML
    private TableColumn<?, ?> colunaEmpresaDestino;
    @FXML
    private TableColumn<?, ?> colunaMotorista;
    @FXML
    private Pane paneViagemSelecionada;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoDescartar;
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldInicio;
    @FXML
    private TextField textFieldTotal;
    @FXML
    private DatePicker datePickerPrazo;
    @FXML
    private TextField textFieldDestino;
    @FXML
    private TextField textFieldCarga;
    @FXML
    private TextField textFieldSituacao;
    @FXML
    private ComboBox<?> comboBoxMotorista;
    @FXML
    private ComboBox<?> comboBoxVeiculo;
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
    @FXML
    private Label labelDicaFlutuante;
    private List<Viagens> listaDeViagens;
    private ObservableList<Viagens> obsListViagens;
    
    
    
    
    // Só estão os métodos das ações dos botões aqui, os outros como carregar tableview devem ser criados




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
    void selecionarViagem(ActionEvent event) {

    }
    
    
    
    
    
    @FXML
    void abrirTelaAvisos(MouseEvent event) {

    }

    @FXML
    void abrirTelaMotoristas(MouseEvent event) {

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
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Inicial Supervisor");
    }

    private void carregarTableView(){
    	Viagem viagem = new Viagem();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	obsListViagens = FXCollections.observableArrayList(listaDeViagens);
    	
    	
    	colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaEmpresaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
    	colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("nomeMotorista"));
    	
    	tabela.setItems(obsListViagens);
    }
    
	@FXML
	void confirmarAlteracao(ActionEvent event) {
	}
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableView();
		
	}

}

package control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import model.Motorista;
import model.Veiculo;
import model.Viagem;
import view.Funcionarios;
import view.Main;
import view.Veiculos;
import view.Viagens;

public class ControlesPerfilSuperEntregas implements Initializable {

	Motorista motorista = new Motorista();
	Veiculo veiculo = new Veiculo();
	
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
    private ComboBox<Funcionarios> comboBoxMotorista;
    @FXML
    private ComboBox<Veiculos> comboBoxVeiculo;
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
    
    private int idViagem;
    
	private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
	private ObservableList<Funcionarios> obsListMotorista;
	
	private List<Veiculos> listaDeVeiculos = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculo;
    
    
    
    // Só estão os métodos das ações dos botões aqui, os outros como carregar tableview devem ser criados




    @FXML
    void esconderDicaFlutuante(MouseEvent event) {

    }

    @FXML
    void exibirDicaFlutuante(MouseEvent event) {

    }

    @FXML
    void selecionarViagem(ActionEvent event) {
    	 carregarComboBoxs();
    	 
		Viagens selecionada = tabela.getSelectionModel().getSelectedItem();
		idViagem = selecionada.getId();

		carregarInfoViagem();
    }
    
    @SuppressWarnings("unlikely-arg-type")
	void carregarInfoViagem() {
       	paneSelecionarViagem.setVisible(false);
    	paneSelecionarViagem.setDisable(true);
    	paneViagemSelecionada.setVisible(true);
    	paneViagemSelecionada.setDisable(false);
    	
    	Viagem viagem = new Viagem();
    	viagem = viagem.encontrarViagem(idViagem);
    	
    	textFieldCarga.setText(viagem.getCarga());
    	textFieldDestino.setText(viagem.getDestino());
    	textFieldId.setText(String.valueOf(viagem.getId()));
    	textFieldInicio.setText(viagem.getInicio());
    	textFieldSituacao.setText(viagem.getSituacao());
    	textFieldTotal.setText(viagem.getSituacao());
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(viagem.getFim(), formatter);
    	datePickerPrazo.setValue(localDate);
    	
    	comboBoxMotorista.getSelectionModel().selectFirst();
    	
    	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
    	while(!viagem.getMotorista().getNome().equals(comboBoxMotorista.getSelectionModel().getSelectedItem().getNome())) {
    		comboBoxMotorista.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}
    	
    	
    	
    	//Esse aqui ta meio bugado, esse não é a forma correta de fazer, mas da forma correta não funciona :/
    	String placa = viagem.getVeiculo().getPlaca();
    	Veiculos placaSelecionada = comboBoxVeiculo.getSelectionModel().getSelectedItem();
    	
    	int seguranca1 = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao veiculo da viagem  	
    	while(!placa.equals(placaSelecionada)) {
    		comboBoxVeiculo.getSelectionModel().selectNext();
    		seguranca1++;
    		if(seguranca1 > 100) {
    			break;
    		}
    	}
    }
    
    
    
    @FXML
    void abrirTelaAvisos(MouseEvent event) {
    	carregarTableView();
    	
		paneViagemSelecionada.setVisible(false);
		paneViagemSelecionada.setDisable(true);
		
		paneSelecionarViagem.setVisible(true);
		paneSelecionarViagem.setDisable(false);
		
		Main.trocarTela("Tela Supervisor Avisos");
		
    }

    @FXML
    void abrirTelaMotoristas(MouseEvent event) {
    	carregarTableView();
    	
		paneViagemSelecionada.setVisible(false);
		paneViagemSelecionada.setDisable(true);
		
		paneSelecionarViagem.setVisible(true);
		paneSelecionarViagem.setDisable(false);
		
    	Main.trocarTela("Tela Inicial Supervisor");
    	
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
    	carregarTableView();
    	carregarComboBoxs();
    	if(paneViagemSelecionada.isVisible()) {
    		paneViagemSelecionada.setVisible(false);
    		paneViagemSelecionada.setDisable(true);
    		
    		paneSelecionarViagem.setVisible(true);
    		paneSelecionarViagem.setDisable(false);
    	}else {
    		Main.trocarTela("Tela Inicial Supervisor");
    	}
    	
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
    private void carregarComboBoxs() {
    	listaDeMotoristas = motorista.listarMotoristas();
    	obsListMotorista = FXCollections.observableArrayList(listaDeMotoristas);
		comboBoxMotorista.setItems(obsListMotorista);

    	listaDeVeiculos = veiculo.listarVeiculos();
    	obsListVeiculo = FXCollections.observableArrayList(listaDeVeiculos);
		comboBoxVeiculo.setItems(obsListVeiculo);

    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableView();
		carregarComboBoxs();
		
	}

}

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;
import view.*;

public class ControlesPerfilAdminHistEntregas implements Initializable {

	Motorista motorista = new Motorista();
	Veiculo veiculo = new Veiculo();
	
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
    private Pane paneSelecionarViagem;
    @FXML
    private Pane paneViagemSelecionada;
    
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
    private Button botaoSalvar;
    @FXML
    private Button botaoDescartar;
    
	private List<Viagens> listaDeViagens = new ArrayList<>();
	private ObservableList<Viagens> obsListViagens;
	
	private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
	private ObservableList<Funcionarios> obsListMotorista;
	
	private List<Veiculos> listaDeVeiculos = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculo;
	
    private int idViagem;
    
    
    
	
	
    
    @FXML
    private void salvarAlteracoes(ActionEvent event) {
    	Viagem viagem = new Viagem();
    	
    	
    	int dia = datePickerPrazo.getValue().getDayOfMonth();
    	int mes = datePickerPrazo.getValue().getMonthValue();
    	int ano = datePickerPrazo.getValue().getYear();
    	
    	String prazo = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
    	
    	viagem.alterarDadosViagem(prazo, textFieldDestino.getText(),
    							  comboBoxMotorista.getSelectionModel().getSelectedItem().getCpf(), 
    							  comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca(), 
    							  textFieldCarga.getText(), Integer.parseInt(textFieldId.getText()));
    	
    	textFieldDestino.setDisable(false);
    	textFieldCarga.setDisable(false);
    	comboBoxMotorista.setDisable(false);
    	comboBoxVeiculo.setDisable(false);
    	datePickerPrazo.setDisable(false);
    	
    	desabilitarEdicao();
    	
    }
    @FXML
    private void excluirViagem(ActionEvent event) {
    	Viagem viagem = new Viagem();
    	
    	viagem.excluirViagem(Integer.parseInt(textFieldId.getText()));
    	
    	voltar(event);
    }
	@FXML
	private void selecionarViagem(ActionEvent event) {
		Viagens selecionada = tabela.getSelectionModel().getSelectedItem();
		idViagem = selecionada.getId();

		carregarInfoViagem();
	}
    @FXML
    private void atualizarLista(ActionEvent event) {
    	carregarTableView();
    }
    
    private void carregarInfoViagem() {
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
    private void carregarTableView(){
    	Viagem viagem = new Viagem();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	obsListViagens = FXCollections.observableArrayList(listaDeViagens);
    	
    	
    	colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaEmpresaDestino.setCellValueFactory(new PropertyValueFactory<>("empresaDestino"));
    	colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista"));
    	
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
    
    @FXML
    private void descartarAlteracoes(ActionEvent event) {
    	carregarInfoViagem();
    	desabilitarEdicao();
    }
    @FXML
    private void habilitarEdicao(ActionEvent event) {
    	textFieldDestino.setDisable(false);
    	textFieldCarga.setDisable(false);
    	comboBoxMotorista.setDisable(false);
    	comboBoxVeiculo.setDisable(false);
    	datePickerPrazo.setDisable(false);
    	botaoSalvar.setDisable(false);
    	botaoDescartar.setDisable(false);
    }
    private void desabilitarEdicao() {
    	textFieldInicio.setDisable(true);
    	textFieldTotal.setDisable(true);
    	textFieldDestino.setDisable(true);
    	textFieldCarga.setDisable(true);
    	textFieldSituacao.setDisable(true);
    	comboBoxMotorista.setDisable(true);
    	comboBoxVeiculo.setDisable(true);
    	datePickerPrazo.setDisable(true);
    	botaoSalvar.setDisable(true);
    	botaoDescartar.setDisable(true);
    }
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }
    
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
    }


    @FXML
    void voltar(ActionEvent event) {
    	if(paneViagemSelecionada.isVisible()) {
    		paneViagemSelecionada.setVisible(false);
    		paneViagemSelecionada.setDisable(true);
    		
    		paneSelecionarViagem.setVisible(true);
    		paneSelecionarViagem.setDisable(false);
    		
    	}else {
        	Main.trocarTela("Tela Boas Vindas");
    	}

    	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableView();
		carregarComboBoxs();
		desabilitarEdicao();
		
	}

}

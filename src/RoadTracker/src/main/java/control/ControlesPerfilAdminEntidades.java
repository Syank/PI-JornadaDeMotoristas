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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;
import view.*;

public class ControlesPerfilAdminEntidades implements Initializable {
	
	private static Funcionario funcionario = new Funcionario();
	private static Filial filial = new Filial();
	private static Turnos t = new Turnos(0, null);
	
    //Elementos das panes de avisos
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
    // ----------------------------------
    
    
    //Elemento da pane de selecionar entidade
    @FXML
    private Pane paneSelecionarEntidade;
    // -------------------------------------
    

	//Elementos das panes de funcionários
    @FXML
    private Pane paneFuncionarioSelecionado;
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
    private Label lblNome;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnDescartar;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCpf;
    @FXML
    private PasswordField pfSenha;
    @FXML
    private TextField tfCargaHoraria;
    @FXML
    private ComboBox<Filiais> cbFilial;
    @FXML
    private ComboBox<Cargos> cbCargo;
    @FXML
    private VBox chbDias;
    @FXML
    private Pane paneFuncionarios;
    @FXML
    private Button btSelecionarFuncionario;
    @FXML
    private Button botaoBuscar;
    @FXML
    private TableView<Listas> tabelaFuncionarios;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCpf;
    @FXML
    private TextField campoDeBuscaNome;
    @FXML
    private TextField campoDeBuscaCpf;
    @FXML
    private ComboBox<Turnos> cbTurno;
    
    private List<Cargos> cargos = new ArrayList<>();
    private ObservableList<Cargos> cargosList;
    
    private List<Filiais> filiais = new ArrayList<>();
    private ObservableList<Filiais> filiaisList;
    
    private List<Turnos> turnos = new ArrayList<>();
    private ObservableList<Turnos> turnosList;

    private String cpfFuncionario;
   
    private List<Listas> listaDeFuncionarios = new ArrayList<>();
    
    private ObservableList<Listas> obsListFuncionarios;
    // ---------------------------------
    
  
    //Elementos das panes de filiais
    @FXML
    private Pane paneFiliais;
    @FXML
    private TableView<Filiais> tabelaFiliais;
    @FXML
    private TableColumn<?, ?> colunaFilial;
    @FXML
    private TableColumn<?, ?> colunaEstado;
    @FXML
    private TableColumn<?, ?> colunaIDFilial;
    @FXML
    private TextField campoDeBuscaFilial;
    @FXML
    private TextField campoDeBuscaEstado;
    
    private List<Filiais> listaDeFiliais = new ArrayList<>();
    private ObservableList<Filiais> obsListFiliais;
    
    
    @FXML
    private Pane paneFilialSelecionada;
    @FXML
    private TextField textFieldNomeFilial;
    @FXML
    private TextField textFieldCidadeFilial;
    @FXML
    private TextField textFieldEstadoFilial;
    @FXML
    private Button botaoSalvarAlteracoesFilial;
    @FXML
    private Button botaoDescartarAlteracoesFilial;
    private int idFilial;
    
    // ------------------------------
    
    //Elementos das panes de veiculos
    @FXML
    private Pane paneVeiculos;
    @FXML
    private TableView<Veiculos> tabelaVeiculos;
    @FXML
    private TableColumn<?, ?> colunaPlaca;
    @FXML
    private TableColumn<?, ?> colunaIDVeiculo;
    @FXML
    private TextField campoDeBuscaVeiculo;
    @FXML
    private TextField campoDeBuscaIDVeiculo;
    private List<Veiculos> listaDeVeiculos = new ArrayList<>();
    private ObservableList<Veiculos> obsListVeiculos;
    private String placaVeiculo;
    
    
    
    @FXML
    private Pane paneVeiculoSelecionado;
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
    @FXML
	private Button botaoSalvarAlteracoesVeiculo;
    @FXML
	private Button botaoDescartarAlteracoesVeiculo;
    // ------------------------------

    //Métodos funcionários
    public void carregarComboBoxCargos() {
    	cargos = funcionario.listarCargos();
    	cargosList = FXCollections.observableArrayList(cargos);
    	cbCargo.setItems(cargosList);
   
    }
    public void carregarComboBoxFiliais() {
    	filiais = filial.listarFiliais();
    	filiaisList = FXCollections.observableArrayList(filiais);
    	cbFilial.setItems(filiaisList);
    }
    public void carregarComboBoxTurnos() {
    	turnos = t.listarTurnos();
    	turnosList = FXCollections.observableArrayList(turnos);
    	cbTurno.setItems(turnosList);
    }
    @FXML
    void excluirFuncionario(ActionEvent event) {
		funcionario.removerFuncionario(funcionario.getCpf());
		notificar("Sucesso", "Funcionário excluído", "O funcionário foi excluído dos registros do banco de dados com sucesso");
    }
    @FXML
    void selecionarFuncionario(ActionEvent event) {
    	Listas selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
    	cpfFuncionario = selecionado.getId();
    	paneFuncionarios.setVisible(false);
    	paneFuncionarios.setDisable(true);
    	paneFuncionarioSelecionado.setVisible(true);
    	paneFuncionarioSelecionado.setDisable(false);
		carregarComboBoxCargos();
		carregarComboBoxFiliais();
		carregarComboBoxTurnos();
    	carregarInfoFuncionario();
    }   
    void carregarInfoFuncionario() {
    	funcionario = funcionario.encontrarFuncionario(cpfFuncionario);
    	
    	lblNome.setText(funcionario.getNome());
    	tfNome.setText(funcionario.getNome());
    	tfCpf.setText(funcionario.getCpf());
    	pfSenha.setText(funcionario.getSenha());
    	tfCargaHoraria.setText(funcionario.getCargaHoraria());
    	
    	// Cargo
    	if (funcionario.getCargo().equals("Motorista")) {
    		cbCargo.getSelectionModel().select(0);
    	}
    	else if (funcionario.getCargo().equals("Supervisor")){
    		cbCargo.getSelectionModel().select(1);
    	}
    	else {
    		cbCargo.getSelectionModel().select(2);
    	}
    	
    	// Filial
    	cbFilial.getSelectionModel().select(funcionario.getFilial().getId() - 1);
    	
    	// Turno
    	if (funcionario.getCargo().equals("Matutino")) {
    		cbTurno.getSelectionModel().select(0);
    	}
    	else if (funcionario.getCargo().equals("Vespertino")){
    		cbTurno.getSelectionModel().select(1);
    	}
    	else {
    		cbTurno.getSelectionModel().select(2);
    	}
    	
    	cbDom.setSelected(funcionario.isDom());
    	cbSeg.setSelected(funcionario.isSeg());
    	cbTer.setSelected(funcionario.isTer());
    	cbQua.setSelected(funcionario.isQua());
    	cbQui.setSelected(funcionario.isQui());
    	cbSex.setSelected(funcionario.isSex());
    	cbSab.setSelected(funcionario.isSab());
    }

    @FXML
    void descartarAlteracoes(ActionEvent event) {
    	carregarInfoFuncionario();
    	desabilitarEdicao();
    	System.out.println("Descartou");
    }
    @FXML
    void alterarDados(ActionEvent event) {
    	
    	funcionario.alterarDadosFuncionario(tfNome.getText(), funcionario.getCpf(), pfSenha.getText(), cbCargo.getValue().getCargo(),
    			cbFilial.getValue().getId(), tfCargaHoraria.getText(), cbTurno.getValue().toString(), cbSeg.isSelected(), cbTer.isSelected(), cbQua.isSelected(),
    			cbQui.isSelected(), cbSex.isSelected(), cbSab.isSelected(), cbDom.isSelected());
    	notificar("Sucesso", "Alteração de dados", "Os dados do funcionário " + tfNome.getText() + " foram alterados no banco de dados com sucesso");
    }
    // -------------------------------
    
    
    //Métodos filial
    @FXML
    void habilitarEdicaoFilial(ActionEvent event){
    	textFieldNomeFilial.setDisable(false);
    	textFieldCidadeFilial.setDisable(false);
    	textFieldEstadoFilial.setDisable(false);
    	
    	botaoSalvarAlteracoesFilial.setDisable(false);
    	botaoDescartarAlteracoesFilial.setDisable(false);
    }
    @FXML
    void excluirFilial(ActionEvent event) {
    	Filial filial = new Filial();
    	filial.excluirFilial(idFilial);
    	
    	notificar("Sucesso", "Filial excluída", "A filial foi excluída dos registros do banco de dados com sucesso!");
    }
    @FXML
    void salvarDadosAlteradosFilial(ActionEvent event) {
    	Filial filial = new Filial();
    	filial.alterarDadosFilial(textFieldNomeFilial.getText(), textFieldCidadeFilial.getText(), textFieldEstadoFilial.getText(), idFilial);
    	
    	desabilitarEdicao();
    	
    	notificar("Sucesso", "Filial atualizada", "Os dados da filial " + textFieldNomeFilial.getText() + " foram alterados com sucesso!");
    }
    @FXML
    void descartarAlteracoesFilial(ActionEvent event) {
    	Filial filial = new Filial();
    	filial = filial.encontrarFilial(idFilial);
    	
    	textFieldNomeFilial.setText(filial.getNome());
    	textFieldCidadeFilial.setText(filial.getCidade());
    	textFieldEstadoFilial.setText(filial.getEstado());
    	

    }
    @FXML
    void selecionarFilial(ActionEvent event) {
    	Filiais selecionada = tabelaFiliais.getSelectionModel().getSelectedItem();
    	idFilial = selecionada.getId();
    	abrirTelaFilialSelecionada(event);

    	carregarInfoFilial();
    }
    void carregarInfoFilial() {
    	Filial filial = new Filial();
    	filial = filial.encontrarFilial(idFilial);

    	textFieldCidadeFilial.setText(filial.getCidade());
    	textFieldEstadoFilial.setText(filial.getEstado());
    	textFieldNomeFilial.setText(filial.getNome());
    }
    // -------------------------------------
    
    //Métodos veiculo
    @FXML
    void habilitarEdicaoVeiculo(ActionEvent event){
    	textFieldMarcaRastreador.setDisable(false);
    	textFieldVersaoRastreador.setDisable(false);
    	textFieldIDRastreador.setDisable(false);
    	textFieldPlacaVeiculo.setDisable(false);
    	textFieldFuncionarioVeiculo.setDisable(false);
    	
    	botaoSalvarAlteracoesVeiculo.setDisable(false);
    	botaoDescartarAlteracoesVeiculo.setDisable(false);
    }
    @FXML
    void excluirVeiculo(ActionEvent event) {
    	Veiculo veiculo = new Veiculo();
    	veiculo.excluirVeiculo(placaVeiculo);
    	
    	desabilitarEdicao();
    	
    	notificar("Sucesso", "Veículo excluído", "O veículo foi excluído com sucesso do banco de dados!");
    }
    @FXML
    void salvarDadosAlteradosVeiculo(ActionEvent event) {
    	Veiculo veiculo = new Veiculo();
    	veiculo.alterarDadosVeiculo(textFieldPlacaVeiculo.getText(), 
    								textFieldMarcaRastreador.getText(), 
    								textFieldVersaoRastreador.getText(),
    								Integer.parseInt(textFieldIDRastreador.getText()), 
    								textFieldFuncionarioVeiculo.getText());
    	
    	notificar("Sucesso", "Dados alterados", "Os dados do veículo de placa " + textFieldPlacaVeiculo.getText() + " foram alterados com sucesso!");
    	
    	desabilitarEdicao();
    }
    @FXML
    void descartarAlteracoesVeiculo(ActionEvent event) {
    	Veiculo veiculo = new Veiculo();
    	veiculo = veiculo.encontrarVeiculo(placaVeiculo);
    	
    	textFieldMarcaRastreador.setText(veiculo.getMarca_rastreador());
    	textFieldVersaoRastreador.setText(veiculo.getVersao_rastreador());
    	textFieldIDRastreador.setText(String.valueOf(veiculo.getId_rastreador()));
    	textFieldPlacaVeiculo.setText(veiculo.getPlaca());
    	textFieldFuncionarioVeiculo.setText(veiculo.getFuncionario().getCpf());
    	
    	desabilitarEdicao();
    }
    @FXML
    void selecionarVeiculo(ActionEvent event) {
    	Veiculos selecionado = tabelaVeiculos.getSelectionModel().getSelectedItem();
    	placaVeiculo = selecionado.getPlaca();
    	abrirTelaVeiculoSelecionado(event);

    	carregarInfoVeiculo();
    }
    void carregarInfoVeiculo() {
    	Veiculo veiculo = new Veiculo();
    	veiculo = veiculo.encontrarVeiculo(placaVeiculo);

    	textFieldMarcaRastreador.setText(veiculo.getMarca_rastreador());
    	textFieldVersaoRastreador.setText(veiculo.getVersao_rastreador());
    	textFieldIDRastreador.setText(String.valueOf(veiculo.getId_rastreador()));
    	textFieldPlacaVeiculo.setText(veiculo.getPlaca());
    	textFieldFuncionarioVeiculo.setText(veiculo.getFuncionario().getCpf());
    }
    
    // -------------------------------------

    //Métodos gerais
    @FXML
    void abrirTelaFuncionarios(MouseEvent event) {
    	paneFuncionarios.setVisible(true);
    	paneFuncionarioSelecionado.setVisible(false);
    	paneFiliais.setVisible(false);
    	paneFilialSelecionada.setVisible(false);
    	paneVeiculos.setVisible(false);
    	paneVeiculoSelecionado.setVisible(false);
    	paneSelecionarEntidade.setVisible(false);
    	
    	paneFuncionarios.setDisable(false);
    	paneFuncionarioSelecionado.setDisable(true);
    	paneFiliais.setDisable(true);
    	paneFilialSelecionada.setDisable(true);
    	paneVeiculos.setDisable(true);
    	paneVeiculoSelecionado.setDisable(true);
    	paneSelecionarEntidade.setDisable(true);
    	
    	desabilitarEdicao();
    }
    @FXML
    void abrirTelaFuncionarioSelecionado(ActionEvent event) {
    	paneFuncionarios.setVisible(false);
    	paneFuncionarioSelecionado.setVisible(true);
    	
    	paneFuncionarios.setDisable(true);
    	paneFuncionarioSelecionado.setDisable(false);
    }
    @FXML
    void abrirTelaFiliais(MouseEvent event) {
    	paneFuncionarios.setVisible(false);
    	paneFuncionarioSelecionado.setVisible(false);
    	paneFiliais.setVisible(true);
    	paneFilialSelecionada.setVisible(false);
    	paneVeiculos.setVisible(false);
    	paneVeiculoSelecionado.setVisible(false);
    	paneSelecionarEntidade.setVisible(false);
    	
    	paneFuncionarios.setDisable(true);
    	paneFuncionarioSelecionado.setDisable(true);
    	paneFiliais.setDisable(false);
    	paneFilialSelecionada.setDisable(true);
    	paneVeiculos.setDisable(true);
    	paneVeiculoSelecionado.setDisable(true);
    	paneSelecionarEntidade.setDisable(true);
    	
    	desabilitarEdicao();
    }
    @FXML
    void abrirTelaFilialSelecionada(ActionEvent event) {
    	paneFiliais.setVisible(false);
    	paneFilialSelecionada.setVisible(true);
    	
    	paneFiliais.setDisable(true);
    	paneFilialSelecionada.setDisable(false);
    }
    @FXML
    void abrirTelaVeiculos(MouseEvent event) {
    	paneFuncionarios.setVisible(false);
    	paneFuncionarioSelecionado.setVisible(false);
    	paneFiliais.setVisible(false);
    	paneFilialSelecionada.setVisible(false);
    	paneVeiculos.setVisible(true);
    	paneVeiculoSelecionado.setVisible(false);
    	paneSelecionarEntidade.setVisible(false);
    	
    	paneFuncionarios.setDisable(true);
    	paneFuncionarioSelecionado.setDisable(true);
    	paneFiliais.setDisable(true);
    	paneFilialSelecionada.setDisable(true);
    	paneVeiculos.setDisable(false);
    	paneVeiculoSelecionado.setDisable(true);
    	paneSelecionarEntidade.setDisable(true);
    	
    	desabilitarEdicao();
    }
    @FXML
    void abrirTelaVeiculoSelecionado(ActionEvent event) {
    	paneVeiculos.setVisible(false);
    	paneVeiculoSelecionado.setVisible(true);
    	
    	paneVeiculos.setDisable(true);
    	paneVeiculoSelecionado.setDisable(false);
    }
    void abrirTelaSelecionarEntidade() {
    	paneFuncionarios.setVisible(false);
    	paneFuncionarioSelecionado.setVisible(false);
    	paneFiliais.setVisible(false);
    	paneFilialSelecionada.setVisible(false);
    	paneVeiculos.setVisible(false);
    	paneVeiculoSelecionado.setVisible(false);
    	paneSelecionarEntidade.setVisible(true);
    	
    	paneFuncionarios.setDisable(true);
    	paneFuncionarioSelecionado.setDisable(true);
    	paneFiliais.setDisable(true);
    	paneFilialSelecionada.setDisable(true);
    	paneVeiculos.setDisable(true);
    	paneVeiculoSelecionado.setDisable(true);
    	paneSelecionarEntidade.setDisable(false);
    }
    @FXML
    void habilitarEdicao(ActionEvent event) {
    	tfNome.setDisable(false);
    	tfCpf.setDisable(true);
    	pfSenha.setDisable(false);
    	cbCargo.setDisable(false);
    	cbFilial.setDisable(false);
    	cbTurno.setDisable(false);
    	tfCargaHoraria.setDisable(false);
    	chbDias.setDisable(false);
    	btnSalvar.setDisable(false);
    	btnDescartar.setDisable(false);
    }
    void desabilitarEdicao() {
    	tfNome.setDisable(true);
    	tfCpf.setDisable(true);
    	pfSenha.setDisable(true);
    	cbCargo.setDisable(true);
    	cbTurno.setDisable(true);
    	cbFilial.setDisable(true);
    	tfCargaHoraria.setDisable(true);
    	chbDias.setDisable(true);
    	btnSalvar.setDisable(true);
    	btnDescartar.setDisable(true);
    	
    	textFieldNomeFilial.setDisable(true);
    	textFieldCidadeFilial.setDisable(true);
    	textFieldEstadoFilial.setDisable(true);
    	botaoSalvarAlteracoesFilial.setDisable(true);
    	botaoDescartarAlteracoesFilial.setDisable(true);
    	
    	textFieldMarcaRastreador.setDisable(true);
    	textFieldVersaoRastreador.setDisable(true);
    	textFieldIDRastreador.setDisable(true);
    	textFieldPlacaVeiculo.setDisable(true);
    	textFieldFuncionarioVeiculo.setDisable(true);
    	botaoSalvarAlteracoesVeiculo.setDisable(true);
    	botaoDescartarAlteracoesVeiculo.setDisable(true);
    }
    
    void notificar(String tipoDeAviso, String titulo, String texto) {
    	paneAvisosPrincipal.setDisable(false);
    	paneAvisosPrincipal.setVisible(true);
    	paneAvisosSombra.setVisible(true);
    	paneAvisosSombra.setDisable(false);
    	switch(tipoDeAviso){
    		case "Sucesso":
    			paneAvisosSucesso.setDisable(false);
    			paneAvisosSucesso.setVisible(true);
    			labelAvisosTextoSucesso.setText(texto);
    			labelAvisosTituloSucesso.setText(titulo);
    			break;
    		case "Falha":
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
    public void carregarTableViews() {
    	
    	Funcionario funcionario = new Funcionario();
    	Filial filial = new Filial();
    	Veiculo veiculo = new Veiculo();
    	
    	listaDeFuncionarios = funcionario.listarFuncionarios();
    	listaDeFiliais = filial.listarFiliais();
    	listaDeVeiculos = veiculo.listarVeiculos();
    	
    	//Transforma a array primitiva em Observable Array
    	obsListFuncionarios = FXCollections.observableArrayList(listaDeFuncionarios);
    	obsListFiliais = FXCollections.observableArrayList(listaDeFiliais);
    	obsListVeiculos = FXCollections.observableArrayList(listaDeVeiculos);
    	
    	//"Habilita" as colunas da tableView para receber o valor retornado da classe Listas, nos seus métodos get
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	colunaCpf.setCellValueFactory(new PropertyValueFactory<>("id"));
    	
    	colunaIDFilial.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaFilial.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    	
    	colunaIDVeiculo.setCellValueFactory(new PropertyValueFactory<>("id_rastreador"));
    	colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
    	
    	//Adiciona a Observable Array na TableView
    	tabelaFuncionarios.setItems(obsListFuncionarios);
    	tabelaFiliais.setItems(obsListFiliais);
    	tabelaVeiculos.setItems(obsListVeiculos);
    }
    @FXML
    void atualizarLista(ActionEvent event) {
    	carregarTableViews();
    }
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    	abrirTelaSelecionarEntidade();
    }
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    	abrirTelaSelecionarEntidade();
    }
    @FXML
    void abrirTelaEnt(ActionEvent event) {
    	abrirTelaSelecionarEntidade();
    }
    @FXML
    void voltar(MouseEvent event) {
    	if (paneSelecionarEntidade.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    	else {
    		if (paneFuncionarioSelecionado.isVisible()) {
    			abrirTelaFuncionarios(event);
    		}
    		else if (paneFilialSelecionada.isVisible()) {
    			abrirTelaFiliais(event);
    		}
    		else if (paneVeiculoSelecionado.isVisible()) {
    			abrirTelaVeiculos(event);
    		}
    		else {
    			abrirTelaSelecionarEntidade();
    		}
    	}
    	desabilitarEdicao();
    }
    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
    
    // --------------
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		abrirTelaSelecionarEntidade();
		carregarTableViews();
		desabilitarEdicao();
	}

}
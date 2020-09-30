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
    private TextField pfSenha;
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
    
    private List<Cargos> cargos = new ArrayList<>();
    private ObservableList<Cargos> cargosList;
    
    private List<Filiais> filiais = new ArrayList<>();
    private ObservableList<Filiais> filiaisList;

    private String cpfFuncionario;
   
    private List<Listas> lista = new ArrayList<>();
    
    private ObservableList<Listas> obsList;
    // ---------------------------------
    
  
    //Elementos das panes de filiais
    @FXML
    private Pane paneFiliais;
    @FXML
    private TableView<?> tabelaFiliais;
    @FXML
    private TableColumn<?, ?> colunaFilial;
    @FXML
    private TableColumn<?, ?> colunaEstado;
    @FXML
    private TextField campoDeBuscaFilial;
    @FXML
    private TextField campoDeBuscaEstado;
    
    @FXML
    private Pane paneFilialSelecionada;
    @FXML
    private TextField textFieldNomeFilial;
    @FXML
    private TextField textFieldCidadeFilial;
    @FXML
    private TextField textFieldEstadoFilial;
    
    // ------------------------------
    
    //Elementos das panes de veiculos
    @FXML
    private Pane paneVeiculos;
    @FXML
    private TableView<?> tabelaVeiculos;
    @FXML
    private TableColumn<?, ?> colunaVeiculo;
    @FXML
    private TableColumn<?, ?> colunaIDVeiculo;
    @FXML
    private TextField campoDeBuscaVeiculo;
    @FXML
    private TextField campoDeBuscaIDVeiculo;
    
    @FXML
    private Pane paneVeiculoSelecionado;
    @FXML
    private TextField textFieldMarcaRastreador;
    @FXML
    private TextField textFieldVersaoRastreador;
    @FXML
    private TextField textFieldIDRastrador;
    @FXML
    private TextField textFieldPlacaVeiculo;
    @FXML
    private TextField textFieldFuncionarioVeiculo;
    // ------------------------------
    

    

    //Métodos funcionários
    public void carregarComboBoxCargos() {
    	cargos = funcionario.listarCargos();
    	cargosList = FXCollections.observableArrayList(cargos);
    	cbCargo.setItems(cargosList);
    }
        public void carregarComboBoxFiliais() {
    	filiais = funcionario.listarFiliais();
    	filiaisList = FXCollections.observableArrayList(filiais);
    	cbFilial.setItems(filiaisList);
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
    	carregarInfoFuncionario();
    }   
    void carregarInfoFuncionario() {
    	funcionario = funcionario.encontrarFuncionario(cpfFuncionario);
    	
    	lblNome.setText(funcionario.getNome());
    	tfNome.setText(funcionario.getNome());
    	tfCpf.setText(funcionario.getCpf());
    	pfSenha.setText(funcionario.getSenha());
    	tfCargaHoraria.setText(funcionario.getCargaHoraria());
    	
    	
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
    			cbFilial.getValue().getId(), tfCargaHoraria.getText(), cbSeg.isSelected(), cbTer.isSelected(), cbQua.isSelected(),
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
    }
    @FXML
    void excluirFilial(ActionEvent event) {
    	
    }
    @FXML
    void salvarDadosAlteradosFilial(ActionEvent event) {
    	
    }
    @FXML
    void descartarAlteracoesFilial(ActionEvent event) {
    	
    }
    
    // -------------------------------------
    
    //Métodos veiculo
    @FXML
    void habilitarEdicaoVeiculo(ActionEvent event){
    	textFieldMarcaRastreador.setDisable(false);
    	textFieldVersaoRastreador.setDisable(false);
    	textFieldIDRastrador.setDisable(false);
    	textFieldPlacaVeiculo.setDisable(false);
    	textFieldFuncionarioVeiculo.setDisable(false);
    }
    @FXML
    void excluirVeiculo(ActionEvent event) {
    	
    }
    @FXML
    void salvarDadosAlteradosVeiculo(ActionEvent event) {
    	
    }
    @FXML
    void descartarAlteracoesVeiculo(ActionEvent event) {
    	
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
    	cbFilial.setDisable(true);
    	tfCargaHoraria.setDisable(true);
    	chbDias.setDisable(true);
    	btnSalvar.setDisable(true);
    	btnDescartar.setDisable(true);
    	
    	textFieldNomeFilial.setDisable(false);
    	textFieldCidadeFilial.setDisable(false);
    	textFieldEstadoFilial.setDisable(false);
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
    public void carregarTableView() {
    	
    	Funcionario funcionario = new Funcionario();
    	
    	lista = funcionario.listarFuncionarios();
    	
    	//Transforma a array primitiva em Observable Array
    	obsList = FXCollections.observableArrayList(lista);
    	
    	//"Habilita" as colunas da tableView para receber o valor retornado da classe Listas, nos seus métodos get
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	colunaCpf.setCellValueFactory(new PropertyValueFactory<>("id"));
    	
    	//Adiciona a Observable Array na TableView
    	tabelaFuncionarios.setItems(obsList);
    }
    @FXML
    void atualizarLista(ActionEvent event) {
    	carregarTableView();
    }
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }
    @FXML
    void voltar(MouseEvent event) {
    	if (paneSelecionarEntidade.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}else {
    		if (paneFuncionarioSelecionado.isVisible()) {
    			abrirTelaFuncionarios(event);
    		}else if (paneFilialSelecionada.isVisible()) {
    			abrirTelaFiliais(event);
    		}else if (paneVeiculoSelecionado.isVisible()) {
    			abrirTelaVeiculos(event);
    		}else {
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
		carregarTableView();
		desabilitarEdicao();
	}

}
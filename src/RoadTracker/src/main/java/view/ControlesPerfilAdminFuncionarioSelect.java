package view;

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
import model.Funcionario;

public class ControlesPerfilAdminFuncionarioSelect implements Initializable {
	
	private static Funcionario funcionario = new Funcionario();

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
    private ComboBox<?> cbFilial;

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

    private String cpfFuncionario;
   
    private List<Listas> lista = new ArrayList<>();
    
    private ObservableList<Listas> obsList;
    
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
    void abrirTelaFunc(MouseEvent event) {
    	paneFuncionarios.setVisible(true);
    	paneFuncionarios.setDisable(false);
    	paneFuncionarioSelecionado.setVisible(false);
    	paneFuncionarioSelecionado.setDisable(true);
    	desabilitarEdicao();
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
    void voltar(ActionEvent event) {
    	if (paneFuncionarios.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    	else {
        	paneFuncionarios.setVisible(true);
        	paneFuncionarios.setDisable(false);
        	paneFuncionarioSelecionado.setVisible(false);
        	paneFuncionarioSelecionado.setDisable(true);
    	}
    	desabilitarEdicao();
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
    
    @FXML
    void excluirFuncionario(ActionEvent event) {
		funcionario.removerFuncionario(funcionario.getCpf());
    }
    
    @FXML
    void selecionarFuncionario(ActionEvent event) {
    	Listas selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
    	cpfFuncionario = selecionado.getId();
    	paneFuncionarios.setVisible(false);
    	paneFuncionarios.setDisable(true);
    	paneFuncionarioSelecionado.setVisible(true);
    	paneFuncionarioSelecionado.setDisable(false);
    	carregarInfoFuncionario();
    }   
    
    void carregarInfoFuncionario() {
    	funcionario = funcionario.encontrarFuncionario(cpfFuncionario);
    	
    	lblNome.setText(funcionario.getNome());
    	tfNome.setText(funcionario.getNome());
    	tfCpf.setText(funcionario.getCpf());
    	pfSenha.setText(funcionario.getSenha());
    	tfCargaHoraria.setText(funcionario.getCargaHoraria());
    	//setar o default da filial com o que tem no banco
    	
    	cbDom.setSelected(funcionario.isDom());
    	cbSeg.setSelected(funcionario.isSeg());
    	cbTer.setSelected(funcionario.isTer());
    	cbQua.setSelected(funcionario.isQua());
    	cbQui.setSelected(funcionario.isQui());
    	cbSex.setSelected(funcionario.isSex());
    	cbSab.setSelected(funcionario.isSab());
    }
    
    @FXML
    void habilitarEdicao(ActionEvent event) {
    	tfNome.setDisable(false);
    	tfCpf.setDisable(true);
    	pfSenha.setDisable(false);
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
    	cbFilial.setDisable(true);
    	tfCargaHoraria.setDisable(true);
    	chbDias.setDisable(true);
    	btnSalvar.setDisable(true);
    	btnDescartar.setDisable(true);
    }
    
    @FXML
    void descartarAlteracoes(ActionEvent event) {
    	carregarInfoFuncionario();
    	desabilitarEdicao();
    	System.out.println("Descartou");
    }
    
    @FXML
    void alterarDados(ActionEvent event) {
    	Funcionario func = new Funcionario();
    	func.alterarDadosFuncionario(tfNome.getText(), funcionario.getCpf(), pfSenha.getText(), funcionario.getCargo(),
    			funcionario.getFk_filiais_id(), tfCargaHoraria.getText(), cbSeg.isSelected(), cbTer.isSelected(), cbQua.isSelected(),
    			cbQui.isSelected(), cbSex.isSelected(), cbSab.isSelected(), cbDom.isSelected());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	paneFuncionarios.setVisible(true);
    	paneFuncionarios.setDisable(false);
    	paneFuncionarioSelecionado.setVisible(false);
    	paneFuncionarioSelecionado.setDisable(true);
		carregarTableView();
		desabilitarEdicao();
	}

}

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Funcionario;


public class ControlesPerfilAdminFuncionarios implements Initializable {
	
	public static String cpfFuncionario;

    @FXML
    private TextField campoDeBuscaNome;
    
    @FXML
    private TextField campoDeBuscaCpf;

    @FXML
    private Button botaoBuscar;
    
    //Coisas relacionadas ao TableView
    @FXML
    private TableView<Listas> tabelaFuncionarios;
    @FXML
    private TableColumn<Listas, String> colunaNome;
    @FXML
    private TableColumn<Listas, String> colunaCpf;
    
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
    void selecionarFuncionario(ActionEvent event) {
    	Listas selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
    	System.out.println(selecionado.getId());
    	
    	ControlesPerfilAdminFuncionarioSelecionado.escolherFuncionario(selecionado.getId());
    	
    	Main.trocarTela("Tela Selecionar Funcionario");
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
    	Main.trocarTela("Tela Boas Vindas");
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
	}

}
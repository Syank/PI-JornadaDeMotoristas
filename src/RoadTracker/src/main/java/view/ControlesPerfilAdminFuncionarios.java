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


public class ControlesPerfilAdminFuncionarios implements Initializable {

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
    	//Cria os elementos da lista da TableView
    	//---------------------- OBS: Os dados vindos do banco de dados devem ser inseridos aqui
    	//de preferência em algo como "for funcionario in tabelaFuncionarios:
    	//									lista.add(new Listas(funcionario.cpf, funcionario.nome)"
    	//Qualquer dúvida procurar o Master .-.    ----------------------------------------------------
    	Listas nome1 = new Listas("1203254679", "Ana Carolina");
    	Listas nome2 = new Listas("2365894510", "Ana Clara");
    	Listas nome3 = new Listas("0325698743", "Anna Yukimi");
    	Listas nome4 = new Listas("8471920481", "Bárbara Port");
    	Listas nome5 = new Listas("1928340684", "Giovanni Alves");
    	Listas nome6 = new Listas("3812038456", "Rafael Furtado");
    	
    	//Adiciona os elementos ao array(lista) primitivo
    	lista.add(nome1);
    	lista.add(nome2);
    	lista.add(nome3);
    	lista.add(nome4);
    	lista.add(nome5);
    	lista.add(nome6);
    	
    	//Transforma a array primitiva em Observable Array
    	obsList = FXCollections.observableArrayList(lista);
    	
    	//"Habilita" as colunas da tableView para receber o valor retornado da classe Listas, nos seus métodos get
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	colunaCpf.setCellValueFactory(new PropertyValueFactory<>("id"));
    	
    	//Adiciona a Obersavable Array na TableView
    	tabelaFuncionarios.setItems(obsList);

    }
    
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	System.out.println("Clicou em cad fun ");
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	System.out.println("Clicou em hist ent");
    	Main.trocarTela("Tela Historico de Entregas");
    }
    

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
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

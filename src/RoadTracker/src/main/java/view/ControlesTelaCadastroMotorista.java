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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Funcionario;

public class ControlesTelaCadastroMotorista implements Initializable{
    
    @FXML
    private TextField inputCpf;

    @FXML
    private TextField inputSenha;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputCargaHoraria;
	
	//ComboBoxCargo e suas listas primitivas e Observable
    @FXML
    private ComboBox<ListasComboBoxs> comboBoxCargos;
    private List<ListasComboBoxs> listaComboBoxCargos = new ArrayList<>();
    private ObservableList<ListasComboBoxs> obsListComboBoxCargos;
    
    //ComboBoxTurno e suas listas primitivas e Observable
    @FXML
    private ComboBox<ListasComboBoxs> comboBoxTurnos;
    private List<ListasComboBoxs> listaComboBoxTurnos = new ArrayList<>();
    private ObservableList<ListasComboBoxs> obsListComboBoxTurnos;
    
    //ComboBoxFilial e suas listas primitivas e Observable
    @FXML
    private ComboBox<ListasComboBoxs> comboBoxFilial;
    private List<ListasComboBoxs> listaComboBoxFilial = new ArrayList<>();
    private ObservableList<ListasComboBoxs> obsListComboBoxFilial;
    
    
    
    
    
    
    //Método para criar e carregar o conteúdo das ComboBoxs
    public void carregarComboBoxs() {
    	//Cria os elementos da lista da ComboBox
    	ListasComboBoxs elementoCargos1 = new ListasComboBoxs(1, "Administrador");
    	ListasComboBoxs elementoCargos2 = new ListasComboBoxs(2, "Supervisor");
    	ListasComboBoxs elementoCargos3 = new ListasComboBoxs(3, "Motorista");
    	
    	ListasComboBoxs elementoTurnos1 = new ListasComboBoxs(1, "Matutino");
    	ListasComboBoxs elementoTurnos2 = new ListasComboBoxs(2, "Noturno");
    	
    	ListasComboBoxs elementoFilial1 = new ListasComboBoxs(1, "Caçapava");
    	ListasComboBoxs elementoFilial2 = new ListasComboBoxs(2, "Jacareí");
    	ListasComboBoxs elementoFilial3 = new ListasComboBoxs(3, "São José dos Campos");
    	
    	
    	//Adiciona os elementos ao array(lista) primitivo
    	listaComboBoxCargos.add(elementoCargos1);
    	listaComboBoxCargos.add(elementoCargos2);
    	listaComboBoxCargos.add(elementoCargos3);
    	
    	listaComboBoxTurnos.add(elementoTurnos1);
    	listaComboBoxTurnos.add(elementoTurnos2);
    	
    	listaComboBoxFilial.add(elementoFilial1);
    	listaComboBoxFilial.add(elementoFilial2);
    	listaComboBoxFilial.add(elementoFilial3);
    	
    	
    	//Transforma a array primitiva em Observable Array
    	obsListComboBoxCargos = FXCollections.observableArrayList(listaComboBoxCargos);
    	
    	obsListComboBoxTurnos = FXCollections.observableArrayList(listaComboBoxTurnos);
    	
    	obsListComboBoxFilial = FXCollections.observableArrayList(listaComboBoxFilial);
    	
    	//Adiciona a Obersavable Array na ComboBox
    	comboBoxCargos.setItems(obsListComboBoxCargos);
    	
    	comboBoxTurnos.setItems(obsListComboBoxTurnos);
    	
    	comboBoxFilial.setItems(obsListComboBoxFilial);
    }

    //initialize é executada automáticamente pelo programa ao iniciar o mesmo
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxs();
		
	}
	@FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
	
	@FXML
	void realizarCadastro(ActionEvent event) {
		//Pega o item selecionado nas ComboBoxs, podendo acessar o ID e o Texto
		ListasComboBoxs seleçaoCargo = comboBoxCargos.getSelectionModel().getSelectedItem();
		ListasComboBoxs seleçaoFilial = comboBoxFilial.getSelectionModel().getSelectedItem();
		
		//Cria o objeto Funcionário (quebrei as linhas para caber tudo na tela)
		Funcionario funcionario = new Funcionario();
		
//		funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial);  
		
	}
    
}

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
    private ComboBox<Listas> comboBoxCargos;
    private List<Listas> listaComboBoxCargos = new ArrayList<>();
    private ObservableList<Listas> obsListComboBoxCargos;
    
    //ComboBoxTurno e suas listas primitivas e Observable
    @FXML
    private ComboBox<Listas> comboBoxTurnos;
    private List<Listas> listaComboBoxTurnos = new ArrayList<>();
    private ObservableList<Listas> obsListComboBoxTurnos;
    
    //ComboBoxFilial e suas listas primitivas e Observable
    @FXML
    private ComboBox<Listas> comboBoxFilial;
    private List<Listas> listaComboBoxFilial = new ArrayList<>();
    private ObservableList<Listas> obsListComboBoxFilial;
    
    
    
    
    
    //Mï¿½todo para criar e carregar o conteï¿½do das ComboBoxs
    public void carregarComboBoxs() {
    	//Cria os elementos da lista da ComboBox
    	Listas elementoCargos1 = new Listas("1", "Administrador");
    	Listas elementoCargos2 = new Listas("2", "Supervisor");
    	Listas elementoCargos3 = new Listas("3", "Motorista");
    	
    	Listas elementoTurnos1 = new Listas("1", "Matutino");
    	Listas elementoTurnos2 = new Listas("2", "Noturno");
    	
    	Listas elementoFilial1 = new Listas("1", "Caï¿½apava");
    	Listas elementoFilial2 = new Listas("2", "Jacareï¿½");
    	Listas elementoFilial3 = new Listas("3", "Sï¿½o Josï¿½ dos Campos");
    	
    	
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

    //initialize ï¿½ executada automï¿½ticamente pelo programa ao iniciar o mesmo
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
		Listas seleçaoCargo = comboBoxCargos.getSelectionModel().getSelectedItem();
		Listas seleçaoFilial = comboBoxFilial.getSelectionModel().getSelectedItem();
		
		//Cria o objeto Funcionï¿½rio (quebrei as linhas para caber tudo na tela)
//		new Funcionario(inputCpf.getText(),
//						inputNome.getText(),
//						inputSenha.getText(),
//						seleçaoCargo.getValor(),
//						seleçaoFilial.getId());
		
//		funcionario.cadastrarFuncionario(nome, cpf, senha, cargo, filial);  
		
	}
    
}

package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ControlesTelaCadastroMotorista implements Initializable{

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
    
    //Método para criar e carregar o conteúdo das ComboBoxs
    public void carregarComboBoxs() {
    	//Cria os elementos da lista da ComboBox
    	ListasComboBoxs elementoCargos1 = new ListasComboBoxs(1, "Administrador");
    	ListasComboBoxs elementoCargos2 = new ListasComboBoxs(2, "Supervisor");
    	ListasComboBoxs elementoCargos3 = new ListasComboBoxs(3, "Motorista");
    	
    	ListasComboBoxs elementoTurnos1 = new ListasComboBoxs(1, "Matutino");
    	ListasComboBoxs elementoTurnos2 = new ListasComboBoxs(2, "Noturno");
    	
    	
    	//Adiciona os elementos ao array(lista) primitivo
    	listaComboBoxCargos.add(elementoCargos1);
    	listaComboBoxCargos.add(elementoCargos2);
    	listaComboBoxCargos.add(elementoCargos3);
    	
    	listaComboBoxTurnos.add(elementoTurnos1);
    	listaComboBoxTurnos.add(elementoTurnos2);
    	
    	
    	//Transforma a array primitiva em Observable Array
    	obsListComboBoxCargos = FXCollections.observableArrayList(listaComboBoxCargos);
    	
    	obsListComboBoxTurnos = FXCollections.observableArrayList(listaComboBoxTurnos);
    	
    	//Adiciona a Obersavable Array na ComboBox
    	comboBoxCargos.setItems(obsListComboBoxCargos);
    	
    	comboBoxTurnos.setItems(obsListComboBoxTurnos);
    }

    //initialize é executada automáticamente pelo programa ao iniciar o mesmo
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxs();
		
	}
    
}

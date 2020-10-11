package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.Main;

public class ControlesPerfilAdminAvisos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelAvisos;

    @FXML
    private Pane paneVisualizarAvisos;

    @FXML
    private Button btSelecionarAviso;

    @FXML
    void abrirTelaCadEnt(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }
    
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
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
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }  

    @FXML
    void selecionarAviso(ActionEvent event) {

    }

    @FXML
    void initialize() {
       
    }
}

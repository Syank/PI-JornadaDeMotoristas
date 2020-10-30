package control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import view.Main;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class ControlesPerfilSuperAvisos {

    @FXML
    private Label labelAvisos;

    @FXML
    private Pane paneVisualizarAvisos;

    @FXML
    private TableView<?> tabelaAvisos;

    @FXML
    private TableColumn<?, ?> colunaTituloAviso;

    @FXML
    private TableColumn<?, ?> colunaRemetente;

    @FXML
    private TableColumn<?, ?> colunaDataAviso;

    @FXML
    private Button btSelecionarAviso;

    @FXML
    private Pane paneAvisoSelecionado;

    @FXML
    private TextField campoIDAviso;

    @FXML
    private TextArea msg;

    @FXML
    private DatePicker dataDoAviso;

    @FXML
    private TextField remetente;

    @FXML
    private CheckBox visualizado;

    @FXML
    void abrirTelaAvisos(MouseEvent event) {
    	Main.trocarTela("Tela Supervisor Avisos");
    }

    @FXML
    void abrirTelaMotoristas(MouseEvent event) {
    	Main.trocarTela("Tela Inicial Supervisor");
    }
    
    @FXML
    void abrirTelaEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Supervisor Entregas");
    }

    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }

    @FXML
    void selecionarAviso(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }

}
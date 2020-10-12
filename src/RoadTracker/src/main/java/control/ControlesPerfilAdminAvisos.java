package control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Aviso;
import view.Avisos;
import view.Main;
import view.Viagens;

public class ControlesPerfilAdminAvisos {

    @FXML
    private Label labelAvisos;

    @FXML
    private Pane paneVisualizarAvisos;

    @FXML
    private TableView<Avisos> tabelaAvisos;

    @FXML
    private TableColumn<?, ?> colunaTituloAviso;

    @FXML
    private TableColumn<?, ?> colunaFuncDestino;

    @FXML
    private TableColumn<?, ?> colunaDataAviso;

    @FXML
    private Button btSelecionarAviso;

    @FXML
    private Pane paneAvisoSelected;

    @FXML
    private TextField campoIDAviso;

    @FXML
    private TextField destinatario;

    @FXML
    private TextField campoTipoAviso;

    @FXML
    private TextArea msg;

    @FXML
    private DatePicker dataDoAviso;

    @FXML
    private TextField remetente;

    @FXML
    private CheckBox visualizado;


	private List<Avisos> listaAvisos = new ArrayList<>();
	private ObservableList<Avisos> obsListAvisos;
	private int idAviso;

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
    	if (paneVisualizarAvisos.isVisible()) {
    		Main.trocarTela("Tela Boas Vindas");
    	}
    	else {
    		paneAvisoSelected.setDisable(true);
    		paneAvisoSelected.setVisible(false);
    		paneVisualizarAvisos.setDisable(false);
    		paneVisualizarAvisos.setVisible(true);
    	}
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
    public void selecionarAviso(ActionEvent event) {
		Avisos selecionado = tabelaAvisos.getSelectionModel().getSelectedItem();
		idAviso = selecionado.getId();
		carregarInfoAviso();
		paneAvisoSelected.setDisable(false);
		paneAvisoSelected.setVisible(true);
		paneVisualizarAvisos.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
    }
    
    public void carregarInfoAviso() {
    	Aviso aviso = new Aviso();
    	aviso = aviso.encontrarAviso(idAviso);
		
		campoIDAviso.setText(String.valueOf(aviso.getId()));
		campoTipoAviso.setText(aviso.getTipo());
		remetente.setText(aviso.getFuncionario().getCpf());
		destinatario.setText(aviso.getFuncionario_destino());
		visualizado.setSelected(aviso.isVisualizado());
		msg.setText(aviso.getMensagem());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(aviso.getData(), formatter);
    	dataDoAviso.setValue(localDate);
    }
    
	@FXML
	void excluir(ActionEvent event) {
		Aviso aviso = new Aviso();
//		aviso.excluir();
	}
    
	public void carregarTableViews() {
		Aviso aviso = new Aviso();
		listaAvisos = aviso.listarAvisos();
		obsListAvisos = FXCollections.observableArrayList(listaAvisos);
		colunaTituloAviso.setCellValueFactory(new PropertyValueFactory<>("tituloAviso"));
		colunaFuncDestino.setCellValueFactory(new PropertyValueFactory<>("funcDestino"));
		colunaDataAviso.setCellValueFactory(new PropertyValueFactory<>("dataAviso"));
		tabelaAvisos.setItems(obsListAvisos);
	}
	
    @FXML
    void initialize() {
       carregarTableViews();
    }
}

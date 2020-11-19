  
package control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import model.Logs;
import view.Avisos;
import view.Main;

public class ControlesPerfilAdminAvisos implements Initializable{

	public static boolean carregarInfos = false;
	
	@FXML
    private Label labelAvisos;
    @FXML
    private Pane paneVisualizarAvisos;
    @FXML
    private TableView<Avisos> tabelaAvisos;
    @FXML
    private TableColumn<?, ?> colunaTituloAviso;
    @FXML
    private TableColumn<?, ?> colunaRemetente;
    @FXML
    private TableColumn<?, ?> colunaDataAviso;
    @FXML
    private Button btSelecionarAviso;
    @FXML
    private TextField campoIDAviso;
    @FXML
    private TextField remetente;
    @FXML
    private CheckBox visualizado;
    @FXML
    private TextArea msg;
    @FXML
    private DatePicker dataDoAviso;
    @FXML
    private Pane paneAvisoSelecionado;
    @FXML
    private Pane paneSelecionarOpcao;
    @FXML
    private Pane paneVisualizarLogs;
    @FXML
    private TableView<Logs> tabelaLogs;
    @FXML
    private TableColumn<?, ?> colunaRegistroLog;
    @FXML
    private TableColumn<?, ?> colunaFuncionarioLog;
    @FXML
    private TableColumn<?, ?> colunaDataLog;
    @FXML
    private Button btSelecionarLog;
    @FXML
    private Pane paneLogSelecionado;
    @FXML
    private TextField campoIDlog;
    @FXML
    private TextArea msgLog;
    @FXML
    private DatePicker dataDoLog;
    @FXML
    private TextField responsavel;

	private List<Avisos> listaAvisos = new ArrayList<>();
	private ObservableList<Avisos> obsListAvisos;
	
	private int idAviso;
	
	private int idLog;

    @FXML
    void abrirTelaCadEnt(MouseEvent event) {
    	carregarInfos = true;
    	voltarAvisos();
    	Main.trocarTela("Tela Cadastrar Funcionarios");

    }
    
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	carregarInfos = true;
    	voltarAvisos();
    	Main.trocarTela("Tela Funcionarios");

    }
    
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	carregarInfos = true;
    	voltarAvisos();
    	Main.trocarTela("Tela Historico de Entregas");

    }
    
    @FXML
    void abrirTelaAvisos(MouseEvent event) {
   		paneAvisoSelecionado.setVisible(false);
   		paneAvisoSelecionado.setDisable(true);
		paneVisualizarAvisos.setDisable(false);
		paneVisualizarAvisos.setVisible(true);
    	carregarInfos = true;
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	carregarInfos = true;
    	paneSelecionarOpcao.setVisible(true);
    	
    	if (paneAvisoSelecionado.isVisible()) {
			paneVisualizarAvisos.setDisable(false);
			paneAvisoSelecionado.setVisible(false);
			paneAvisoSelecionado.setDisable(true);
    	}
    	else if (paneLogSelecionado.isVisible()) {
			paneVisualizarLogs.setVisible(false);
			paneVisualizarLogs.setDisable(true);
    	}
    	else if (paneVisualizarAvisos.isVisible() || paneVisualizarLogs.isVisible()) {
        	paneSelecionarOpcao.setVisible(true);
        	paneVisualizarAvisos.setVisible(false);
        	paneVisualizarLogs.setVisible(false);
    		Main.trocarTela("Tela Boas Vindas");
    	}
    }
    
    @FXML
    void excluir(ActionEvent event) {
    	Aviso aviso = new Aviso();
    	
    	aviso.excluirAviso(Integer.parseInt(campoIDAviso.getText()));
    	
    	voltar(event);
    }

    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }  

    @FXML
    public void selecionarAviso(ActionEvent event) {
		Avisos selecionado = tabelaAvisos.getSelectionModel().getSelectedItem();
		idAviso = selecionado.getId();
		carregarInfoAviso();
		paneAvisoSelecionado.setDisable(false);
		paneAvisoSelecionado.setVisible(true);
		paneVisualizarAvisos.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
    }
    
    @FXML
    void abrirTelaLogs(MouseEvent event) {
    	paneSelecionarOpcao.setVisible(false);
    	paneVisualizarLogs.setVisible(true);
    }
    
    @FXML
    void abrirAvisos(MouseEvent event) {
    	paneSelecionarOpcao.setVisible(false);
    	paneVisualizarAvisos.setVisible(true);
    }
    @FXML
    void selecionarLog(ActionEvent event) {
		Logs logSelecionado = tabelaLogs.getSelectionModel().getSelectedItem();
		idLog = logSelecionado.getId();
		carregarInfoLog();
		paneLogSelecionado.setDisable(false);
		paneLogSelecionado.setVisible(true);
		paneVisualizarLogs.setDisable(true);
		paneVisualizarLogs.setVisible(false);
    }
    
    public void carregarInfoLog() {
    	Logs log = new Logs();
    	log = log.encontrarLog(idLog);
		
		campoIDlog.setText(String.valueOf(log.getId()));
		msgLog.setText(log.getRegistro());
		responsavel.setText(log.getCpf());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(log.getData(), formatter);
    	dataDoLog.setValue(localDate);
    }
    
    public void carregarInfoAviso() {
    	Aviso aviso = new Aviso();
    	aviso = aviso.encontrarAviso(idAviso);
		
		campoIDAviso.setText(String.valueOf(aviso.getId()));
		visualizado.setSelected(aviso.isResolvido());
		msg.setText(aviso.getMensagem());
		
		// Esse try é um remendo no código pois corrigir isso envolveria mudar muitas classes
		try {
			remetente.setText(aviso.getMotorista().getCpf());
		}
		catch(Exception erro) {
			remetente.setText(aviso.getEmissor());
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(aviso.getData(), formatter);
    	dataDoAviso.setValue(localDate);
    }
    
    public void voltarAvisos() {
		paneAvisoSelecionado.setVisible(false);
		paneAvisoSelecionado.setDisable(true);
		paneVisualizarAvisos.setVisible(false);
		paneVisualizarAvisos.setDisable(false);
    }
    
	public void carregarTableViews() {
		Aviso aviso = new Aviso();
		
		listaAvisos = aviso.listarAvisos();
		
		obsListAvisos = FXCollections.observableArrayList(listaAvisos);
		
		colunaTituloAviso.setCellValueFactory(new PropertyValueFactory<>("tituloAviso"));
		colunaDataAviso.setCellValueFactory(new PropertyValueFactory<>("dataAviso"));
		colunaRemetente.setCellValueFactory(new PropertyValueFactory<>("motorista"));
		
		tabelaAvisos.setItems(obsListAvisos);
	}
    
	
	
	
    void tarefasEmLoop() {
    	// Considere que cada if aqui dentro é uma "função"
    	
    	if(carregarInfos) {
    		carregarTableViews();
    		carregarInfos = false;
    	}
    	
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask(){


			@Override
			public void run() {
				Platform.runLater(() -> tarefasEmLoop());
			}
		}, 0, 1000);
	}
}

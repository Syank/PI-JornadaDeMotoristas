package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Aviso;
import model.Motorista;
import view.Main;

public class ControlesPerfilMotAvisos implements Initializable {

    @FXML
    private Label labelAvisos;

    @FXML
    private Pane paneCadastrarAviso;

    @FXML
    private TextArea addMsg;

    @FXML
    private CheckBox pneufurado;

    @FXML
    private CheckBox envTerceiros;

    @FXML
    private CheckBox resolvido;

    @FXML
    private CheckBox fProx;

    @FXML
    private TableView<?> tabelaAvisos;

    @FXML
    private TableColumn<?, ?> colunaTituloAviso;

    @FXML
    private TableColumn<?, ?> colunaFuncDestino;

    @FXML
    private TableColumn<?, ?> colunaDataAviso;

    @FXML
    private Button btSelecionarAviso;

    @FXML
    private TextField campoIDAviso;

    @FXML
    private TextField destinatario;

    @FXML
    private TextArea msg;

    @FXML
    private DatePicker dataDoAviso;

    @FXML
    private TextField remetente;

    @FXML
    private CheckBox visualizado;

	private Labeled addDestinatario;

    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	limparCampos();
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
    	Main.trocarTela("Mot Viagens");
    	limparCampos();
    }

    @FXML
    void abrirRealizarViagem(MouseEvent event) {
    	Main.trocarTela("Viagem Selecionada");
    	limparCampos();
    }

    @FXML
    public void confirmarAviso(ActionEvent event) {
    	Aviso aviso = new Aviso();
    	Motorista motorista = new Motorista();
    	
    	String destino = "";
    	
    	addDestinatario = null;
		try {
    		destino = addDestinatario.getText();		
    		
    	}catch (NullPointerException falha) {
    		System.out.println("Campo de destino incorreto");
    	}
    	
    	if(destino.length() == 11) {
    		if(motorista.encontrarMotorista(destino) != null) {
    			aviso.cadastrarAviso(addDestinatario.getText(), ControlesLogin.cpfLogado, addMsg.getText());
        		System.out.println("Mensagem cadastrada");
    		}else {
    			System.out.println("Não existe motorista com esse cpf");
    		}
    		
    	}else {
    		System.out.println("CPF de destino inválido");
    	}

    }

    @FXML
    void excluir(ActionEvent event) {
		addMsg.setText("");
    }

    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    } 

    @FXML
    void irVisualizarAvisos(MouseEvent event) {

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
    	Main.trocarTela("Mot Viagens");
    }
    
	
	public void limparCampos() {
		addMsg.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}

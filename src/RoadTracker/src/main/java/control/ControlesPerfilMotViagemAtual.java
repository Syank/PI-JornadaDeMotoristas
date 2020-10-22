package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Motorista;
import model.Viagem;
import view.Main;
import view.Viagens;

public class ControlesPerfilMotViagemAtual implements Initializable {
	
	Viagem viagemAtual = null;
    
	 @FXML
	 private Label labelDestino;
	 @FXML
	 private Label labelPlaca;
	 @FXML
	 private Label labelPrazo;
	 @FXML
	 private Label labelHorasTotais;
	 @FXML
	 private Label labelCarga;
	 @FXML
	 private Label labelSituacao;
	 @FXML
	 private Label labelAtencao;
	 @FXML
	 private Button botaoFinalizarComecar;
	 @FXML
	 private Button botaoExpediente;
	 @FXML
	 private Label labelExpMax;
	 @FXML
	 private Label labelExpHoje;
	 @FXML
	 private Button botaoAlimentacao;
	 @FXML
	 private Label labelAlimMax;
	 @FXML
	 private Label labelAlimHoje;
	 @FXML
	 private Button botaoDescanso;
	 @FXML
	 private Label labelDescMax;
	 @FXML
	 private Label labelDescHoje;

	private List<Viagens> listaDeViagens = new ArrayList<>();
    
	 
	 
	 
	 
	 
	 
	 


    @FXML
    public void iniciarExpediente(ActionEvent event) {	
    }
    @FXML
    public void finalizarExpediente(ActionEvent event) {	
    }
    
    
    @FXML
    public void pausaDescanso(ActionEvent event) {	
    }
    @FXML
    public void voltaDescanso(ActionEvent event) {	
    }
    
    
    @FXML
    public void pausaAlimentacao(ActionEvent event) {	
    }
    @FXML
    public void voltaAlimentacao(ActionEvent event) {	
    }
    
    
    @FXML
    public void finalizarEntrega(ActionEvent event) {	
    }
    
    
    
    @FXML
    public void carregarViagem(ActionEvent event) {
    	Viagem viagem = new Viagem();

    	
    	listaDeViagens = viagem.listarViagens();
    	
    	listaDeViagens.forEach(item -> {
    		if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
    			if(item.getSituacao().equals("Em andamento")) {
    				viagemAtual = viagem.encontrarViagem(item.getId());
    			}
    		}
    	});
    	
    	if(viagemAtual != null) {
    		botaoFinalizarComecar.setText("Finalizar viagem");
        	botaoFinalizarComecar.setOnAction(null);
        	
    		labelDestino.setText(labelDestino.getText() + viagemAtual.getDestino());
    		labelPlaca.setText(labelPlaca.getText() + viagemAtual.getVeiculo().getPlaca());
    		labelPrazo.setText(labelPrazo.getText() + viagemAtual.getFim());
    		labelHorasTotais.setText(labelHorasTotais.getText() + viagemAtual.getTotal());
    		labelCarga.setText(labelCarga.getText() + viagemAtual.getCarga());
    		labelSituacao.setText(labelSituacao.getText() + viagemAtual.getSituacao());
    		
    		labelAtencao.setVisible(false);
    		
    		Motorista motorista = new Motorista();
    		motorista = motorista.encontrarMotorista(ControlesLogin.cpfLogado);
    		
    		labelExpMax.setText(labelExpMax.getText() + motorista.getCargaHoraria() + 'h');
    		labelExpHoje.setText(labelExpHoje.getText() + motorista.getTrabalhado_hoje() + 'h');
    		
       		labelAlimMax.setText(labelAlimMax.getText() + "1h");
       		labelAlimHoje.setText(labelAlimHoje.getText() + motorista.getAlimentacao_hoje() + 'h');
       		
       		labelDescMax.setText(labelDescMax.getText() + "1h");
    		labelDescHoje.setText(labelDescHoje.getText() + motorista.getDescansado_hoje() + 'h');
    		
    	}
    	
    	
    }
    
    
    @FXML
    void abrirCriarAviso(MouseEvent event) {
    	Main.trocarTela("Criar Aviso");
    }

    @FXML
    void abrirMinhasViagens(MouseEvent event) {
    	Main.trocarTela("Mot Viagens");
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }
	@FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	} 
}

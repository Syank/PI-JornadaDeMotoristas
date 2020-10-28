package control;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Aviso;
import model.Filial;
import model.Motorista;
import model.Viagem;
import view.Filiais;
import view.Funcionarios;
import view.Main;
import view.Turnos;
import view.Viagens;

public class ControlesPerfilSuperEntidades implements Initializable{

	 	@FXML
	    private Pane paneMotoristaSelecionado;
	    @FXML
	    private VBox boxInfoExtraMotorista2;
	    @FXML
	    private TextField tfCargaHoraria;
	    @FXML
	    private CheckBox cbDom;
	    @FXML
	    private CheckBox cbSeg;
	    @FXML
	    private CheckBox cbTer;
	    @FXML
	    private CheckBox cbQua;
	    @FXML
	    private CheckBox cbQui;
	    @FXML
	    private CheckBox cbSex;
	    @FXML
	    private CheckBox cbSab;
	    @FXML
	    private Button btnSalvar;
	    @FXML
	    private Button btnDescartar;
	    @FXML
	    private Label lblNome;
	    @FXML
	    private ComboBox<?> cbCargo;
	    @FXML
	    private ComboBox<Filiais> cbFilial;
	    @FXML
	    private VBox boxInfoExtraMotorista1;
	    @FXML
	    private ComboBox<Turnos> cbTurno;
	    @FXML
	    private TextField textFieldSalarioMotorista;
	    @FXML
	    private TextField tfNome;
	    @FXML
	    private TextField tfCpf;
	    @FXML
	    private TextField textFieldEmail;
	    @FXML
	    private PasswordField pfSenha;
	    @FXML
	    private Label labelSituacaoMotorista;
	    @FXML
	    private Pane paneCadastrarMotorista;
	    @FXML
	    private ComboBox<Filiais> comboBoxCadastroFilial;
	    @FXML
	    private Pane paneInfosExtrasMotorista;
	    @FXML
	    private CheckBox checkBoxDomingo;
	    @FXML
	    private CheckBox checkBoxSegunda;
	    @FXML
	    private CheckBox checkBoxTerca;
	    @FXML
	    private CheckBox checkBoxQuarta;
	    @FXML
	    private CheckBox checkBoxQuinta;
	    @FXML
	    private CheckBox checkBoxSexta;
	    @FXML
	    private CheckBox checkBoxSabado;
	    @FXML
	    private ComboBox<Turnos> comboBoxCadastroTurno;
	    @FXML
	    private TextField textFieldCadastroCargaHoraria;
	    @FXML
	    private TextField textFieldCadastroSalario;
	    @FXML
	    private TextField textFieldCadastroNome;
	    @FXML
	    private TextField textFieldCadastroCpf;
	    @FXML
	    private TextField textFieldCadastroEmail;
	    @FXML
	    private PasswordField textFieldCadastroSenha;
	    @FXML
	    private PasswordField textFieldCadastroConfirmarSenha;
	    @FXML
	    private Pane paneMotoristas;
	    @FXML
	    private Button btSelecionarFuncionario;
	    @FXML
	    private Button botaoBuscar;
	    @FXML
	    private TableView<Funcionarios> tabelaFuncionarios;
	    @FXML
	    private TableColumn<?, ?> colunaNome;
	    @FXML
	    private TableColumn<?, ?> colunaCpf;
	    @FXML
	    private TableColumn<?, ?> colunaCargo;
	    @FXML
	    private TextField campoDeBuscaNome;
	    @FXML
	    private TextField campoDeBuscaCpf;
	    @FXML
	    private Pane paneSelecionarOpcao;
	    @FXML
	    private Label labelDicaFlutuante;
	    @FXML
	    private Pane paneAvisosPrincipal;
	    @FXML
	    private Pane paneAvisosSombra;
	    @FXML
	    private Pane paneAvisosSucesso;
	    @FXML
	    private Label labelAvisosTituloSucesso;
	    @FXML
	    private Label labelAvisosTextoSucesso;
	    @FXML
	    private Pane paneAvisosFalha;
	    @FXML
	    private Label labelAvisosTituloFalha;
	    @FXML
	    private Label labelAvisosTextoFalha;
	    @FXML
	    private Pane paneAvisosConfirmar;
	    @FXML
	    private Label labelAvisosTituloConfirmar;
	    @FXML
	    private Label labelAvisosTextoConfirmar;
	    @FXML
	    private PasswordField passwordFieldConfirmarSenha;
	    
	    private String cpfMotorista;
	    
		private List<Turnos> turnos = new ArrayList<>();
		private ObservableList<Turnos> turnosList;
		private Turnos t = new Turnos(0, null);

		
		private List<Filiais> filiais = new ArrayList<>();
		private ObservableList<Filiais> filiaisList;
		private static Filial filial = new Filial();
	    
	    public List<Viagens> listaDeViagensMotorista = new ArrayList<>();
	    
		private boolean confirmado = false;
		private String funcao;
	    
		private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
		private ObservableList<Funcionarios> obsListMotoristas;
	    
	    // S� est�o os m�todos das a��es dos bot�es aqui, os outros como carregar tableview devem ser criados
	    
	    


		
		public void carregarComboBoxTurnos() {
			turnos = t.listarTurnos();
			turnosList = FXCollections.observableArrayList(turnos);
			cbTurno.setItems(turnosList);
		}
		public void carregarComboBoxFiliais() {
			filiais = filial.listarFiliais();
			filiaisList = FXCollections.observableArrayList(filiais);
			cbFilial.setItems(filiaisList);

		}


	    @FXML
	    void descartarAlteracoes(ActionEvent event) {
	    	carregarInfosMotorista();
	    	desabilitarEdicao();
	    }

	    @FXML
	    void esconderDicaFlutuante(MouseEvent event) {

	    }

	    @FXML
	    void exibirDicaFlutuante(MouseEvent event) {

	    }

	    
	    
	    @FXML
	    void selecionarFuncionario(ActionEvent event) {
	    	Funcionarios selecionado = tabelaFuncionarios.getSelectionModel().getSelectedItem();
	    	
	    	cpfMotorista = selecionado.getCpf();
	    	
	    	paneMotoristas.setVisible(false);
	    	paneMotoristas.setDisable(true);
	    	paneMotoristaSelecionado.setVisible(true);
	    	paneMotoristaSelecionado.setDisable(false);
	    	
	    	
	    	desabilitarEdicao();
	    	carregarComboBoxTurnos();
	    	carregarComboBoxFiliais();
	    	carregarInfosMotorista();
	    }

	    void carregarInfosMotorista() {
	    	Motorista motorista = new Motorista().encontrarMotorista(cpfMotorista);
	    	
	    	tfNome.setText(motorista.getNome());
	    	tfCpf.setText(motorista.getCpf());
	    	textFieldEmail.setText(motorista.getEmail());
	    	pfSenha.setText(motorista.getSenha());
	    	textFieldSalarioMotorista.setText(motorista.getSalario());
	    	tfCargaHoraria.setText(motorista.getCargaHoraria());
	    	
	    	cbDom.setSelected(motorista.getDom());
	    	cbSeg.setSelected(motorista.getSeg());
	    	cbTer.setSelected(motorista.getTer());
	    	cbQua.setSelected(motorista.getQua());
	    	cbQui.setSelected(motorista.getQui());
	    	cbSex.setSelected(motorista.getSex());
	    	cbSab.setSelected(motorista.getSab());
	    	
	    	cbFilial.getSelectionModel().select(motorista.getFilial().getId() - 1);
			if (motorista.getTurno().equals("Matutino")) {
				cbTurno.getSelectionModel().select(0);
			} else if (motorista.getTurno().equals("Vespertino")) {
				cbTurno.getSelectionModel().select(1);
			} else {
				cbTurno.getSelectionModel().select(2);
			}
	    			
			
	        List<Viagens> listaDeViagens = new ArrayList<>();
	        listaDeViagensMotorista.clear();
	        
	    	Viagem viagem = new Viagem();
	    	
	    	listaDeViagens = viagem.listarViagens();
	    	
	    	
	    	labelSituacaoMotorista.setText("Situa��o: Parado");
	    	//Essa "coisa" abaixo � um 'for coisa in lista' embelezado do java
	    	listaDeViagens.forEach(item -> {
	    		if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
	    			if(item.getSituacao().equals("Em andamento")) {
	    				labelSituacaoMotorista.setText("Situa��o: Em viagem");
	    			}
	    		}
	    	});
	    	
	    }
	    
	    @FXML
	    void solicitarCadastro(ActionEvent event) {
	    	Aviso aviso = new Aviso();
	    	
	    	String solicitacao = "";
	    	
	    	String nome = textFieldCadastroNome.getText();
	    	String cpf = textFieldCadastroCpf.getText();
	    	String email = textFieldCadastroEmail.getText();
	    	String senha = textFieldCadastroSenha.getText();
	    	String cargaHoraria = textFieldCadastroCargaHoraria.getText();
	    	String salario = textFieldCadastroSalario.getText();
	    	
	    	int idFilial = comboBoxCadastroFilial.getValue().getId();
	    	String nomeFilial = new Filial().encontrarFilial(idFilial).getNome();
	    	String turno = comboBoxCadastroTurno.getValue().getTurno();
	    	
	    	boolean dom = checkBoxDomingo.isSelected();
	    	boolean seg = checkBoxSegunda.isSelected();
	    	boolean ter = checkBoxTerca.isSelected();
	    	boolean qua = checkBoxQuarta.isSelected();
	    	boolean qui = checkBoxQuinta.isSelected();
	    	boolean sex = checkBoxSexta.isSelected();
	    	boolean sab = checkBoxSabado.isSelected();
	    	String diasDeTrabalho = "";
	    	
	    	if(dom) {
	    		diasDeTrabalho += "Domingo";
	    	}
	    	if(seg) {
	    		diasDeTrabalho += ", Segunda-Feira";
	    	}
	    	if(ter) {
	    		diasDeTrabalho += ", Ter�a-Feira";
	    	}
	    	if(qua) {
	    		diasDeTrabalho += ", Quarta-Feira";
	    	}
	    	if(qui) {
	    		diasDeTrabalho += ", Quinta-Feira";
	    	}
	    	if(sex) {
	    		diasDeTrabalho += ", Sexta-Feira";
	    	}
	    	if(sab) {
	    		diasDeTrabalho += " e S�bado";
	    	}
	    	if(!dom) {
	    		diasDeTrabalho = diasDeTrabalho.substring(2); // Tira ", " caso n�o trabalhe domingo
	    	}
	    	
	    	solicitacao = "Solicito o cadastro do motorista com as seguintes informa��es:\n"
	    				+ "Nome: " + nome + "\n"
	    				+ "CPF: " + cpf + "\n"
	    				+ "E-mail: " + email + "\n"
	    				+ "Senha: " + senha + "\n"
	    				+ "Carga Hor�ria: " + cargaHoraria + "\n"
	    				+ "Sal�rio: " + salario + "\n"
	    				+ "Turno: " + turno + "\n"
	    				+ "Dias de trabalho: " + diasDeTrabalho + "\n"
	    				+ "Pertencendo a Filial " + nomeFilial + ", de ID igual a: " + String.valueOf(idFilial);
	    	
	    	aviso.solicitarCadastro(ControlesLogin.cpfLogado, solicitacao);
	    	
	    	System.out.println("Solicita��o enviada!");
	    }
	    
		@FXML
		void requisitarAlteracaoFuncionario(ActionEvent event) {
			funcao = "Funcionario";
			notificar("Confirmar", "Confirmar senha do usu�rio", "Por favor, confirme sua senha no campo abaixo para confirmar as altera��es nos dados");
		}
	    @FXML
	    void alterarDados(ActionEvent event) {
	    	Motorista motorista = new Motorista().encontrarMotorista(cpfMotorista);
	    	if(confirmado) {
	    		if (Integer.parseInt(textFieldSalarioMotorista.getText()) < 1701.38) {
	    			notificar("Falha", "Sal�rio baixo", "O sal�rio digitado � muito baixo. Escreva um sal�rio v�lido.");
	    		}
	    		else if (Integer.parseInt(tfCargaHoraria.getText()) > 12) {
	    			notificar("Falha de cadastro", "Carga hor�ria", "A carga hor�ria di�ria previamente acordada pode ser no m�ximo de 12 horas. Verifique o valor e tente novamente.");
	    		}
	    		else {
	    			motorista.alterarDadosMotorista(motorista.getCpf(), tfNome.getText(), 
	    					textFieldEmail.getText(), pfSenha.getText(), 
	    					textFieldSalarioMotorista.getText(), tfCargaHoraria.getText(), 
	    					cbFilial.getValue().getId(), cbTurno.getValue().getTurno(),
	    					cbSeg.isSelected(), cbTer.isSelected(), cbQua.isSelected(), cbQui.isSelected(), cbSex.isSelected(), cbSab.isSelected(), cbDom.isSelected());

	    			notificar("Sucesso", "Altera��o de dados",
	    					"Os dados do funcion�rio " + tfNome.getText() + " foram alterados no banco de dados com sucesso");
	    			carregarTableView();
	    		}



	    	}
	    	else {
	    		notificar("Falha", "Senha de confirma��o incorreta", "A senha de verifica��o estava incorreta, tente novamente");
	    	}
	    	confirmado = false;
	    	funcao = "";
	    }
	    
	    @FXML
	    void abrirTelaSolicitarCadastro(MouseEvent event) {
	    	paneSelecionarOpcao.setVisible(false);
	    	paneSelecionarOpcao.setDisable(true);
	    	
	    	paneCadastrarMotorista.setVisible(true);
	    	paneCadastrarMotorista.setDisable(false);
	    	
	    }
	    
	    
	    @FXML
	    void abrirTelaSelecionarMotorista(MouseEvent event) {
	    	paneSelecionarOpcao.setVisible(false);
	    	paneSelecionarOpcao.setDisable(true);
	    	
	    	paneMotoristas.setVisible(true);
	    	paneMotoristas.setDisable(false);
	    	
	    }
	    
	    
	    @FXML
	    void abrirTelaMotoristas(MouseEvent event) {

	    }
	    
	    @FXML
	    void abrirTelaAvisos(MouseEvent event) {
//	    	Main.trocarTela("Tela Avisos");
	    }

	    @FXML
	    void abrirTelaHistEntregas(MouseEvent event) {
	    	Main.trocarTela("Tela Supervisor Entregas");
	    }
	    

	    // Essas 3 fun��es a baixo voc� pode copiar das outras telas
	    @FXML
	    void minimizarJanela(ActionEvent event) {
	    	Main.minimizar();
	    }
	    
	    @FXML
	    void fecharJanela(ActionEvent event) {
	    	System.exit(0);
	    }
	    
	    @FXML
	    void voltar(MouseEvent event) {
	    	if(paneMotoristaSelecionado.isVisible()) {
	    		paneMotoristaSelecionado.setVisible(false);
	    		paneMotoristaSelecionado.setDisable(true);
	    		
	    		paneMotoristas.setVisible(true);
	    		paneMotoristas.setDisable(false);
	    		
	    	}else if(paneMotoristas.isVisible()) {
	    		paneMotoristas.setVisible(false);
	    		paneMotoristas.setDisable(true);
	    		
	    		paneSelecionarOpcao.setVisible(true);
	    		paneSelecionarOpcao.setDisable(false);
	    		
	    	}else if(paneCadastrarMotorista.isVisible()) {
	    		paneCadastrarMotorista.setVisible(false);
	    		paneCadastrarMotorista.setDisable(true);
	    		
	    		paneSelecionarOpcao.setVisible(true);
	    		paneSelecionarOpcao.setDisable(false);
	    	}else {
	    		Main.trocarTela("Tela Login");
	    	}
	    }
	
	
	    @FXML
	    void habilitarEdicao(ActionEvent event) {
	    	tfNome.setDisable(false);
	    	tfCpf.setDisable(false);
	    	textFieldEmail.setDisable(false);
	    	pfSenha.setDisable(false);
	    	textFieldSalarioMotorista.setDisable(false);
	    	
	    	boxInfoExtraMotorista2.setDisable(false);
	    	
	    	cbFilial.setDisable(false);
			cbTurno.setDisable(false);
			
			btnSalvar.setDisable(false);
			btnDescartar.setDisable(false);
	    }
	    

	    void desabilitarEdicao() {
	    	tfNome.setDisable(true);
	    	tfCpf.setDisable(true);
	    	textFieldEmail.setDisable(true);
	    	pfSenha.setDisable(true);
	    	textFieldSalarioMotorista.setDisable(true);
	    	
	    	boxInfoExtraMotorista2.setDisable(true);
	    	
	    	cbFilial.setDisable(true);
			cbTurno.setDisable(true);
			
			btnSalvar.setDisable(true);
			btnDescartar.setDisable(true);
	    }
	
	    
		void notificar(String tipoDeAviso, String titulo, String texto) {
			paneAvisosPrincipal.setDisable(false);
			paneAvisosPrincipal.setVisible(true);
			paneAvisosSombra.setVisible(true);
			paneAvisosSombra.setDisable(false);
			
			switch (tipoDeAviso) {
			case "Sucesso":
				paneAvisosSucesso.setDisable(false);
				paneAvisosSucesso.setVisible(true);
				labelAvisosTextoSucesso.setText(texto);
				labelAvisosTituloSucesso.setText(titulo);
				break;
			case "Falha":
				paneAvisosFalha.setDisable(false);
				paneAvisosFalha.setVisible(true);
				labelAvisosTextoFalha.setText(texto);
				labelAvisosTituloFalha.setText(titulo);
				break;
			case "Confirmar":
				paneAvisosConfirmar.setDisable(false);
				paneAvisosConfirmar.setVisible(true);
				labelAvisosTextoConfirmar.setText(texto);
				labelAvisosTituloConfirmar.setText(titulo);
				passwordFieldConfirmarSenha.setText("");
				break;
			}
			
		}

		
		@FXML
		void confirmarAlteracao(ActionEvent event) {
			if(paneAvisosConfirmar.isVisible()) {
				if(passwordFieldConfirmarSenha.getText().equals(ControlesLogin.senha)) {
					confirmado = true;
				}else {
					confirmado = false;
				}
			}
			
			fecharAviso(event);
			
			switch(funcao){
			case "Funcionario":
				alterarDados(event);
				break;
			}
			
		}
		@FXML
		void fecharAviso(ActionEvent event) {		
			paneAvisosPrincipal.setDisable(true);
			paneAvisosPrincipal.setVisible(false);
			paneAvisosSombra.setVisible(false);
			paneAvisosSombra.setDisable(true);
			paneAvisosSucesso.setDisable(true);
			paneAvisosSucesso.setVisible(false);
			paneAvisosFalha.setDisable(true);
			paneAvisosFalha.setVisible(false);
			paneAvisosConfirmar.setDisable(true);
			paneAvisosConfirmar.setVisible(false);
			
			desabilitarEdicao();
			
		}
	    
		
		void carregarTableView() {
			Motorista motorista = new Motorista();

			listaDeMotoristas = motorista.listarMotoristas();

			// Transforma a array primitiva em Observable Array
			obsListMotoristas = FXCollections.observableArrayList(listaDeMotoristas);

			// "Habilita" as colunas da tableView para receber o valor retornado da classe
			// Listas, nos seus m�todos get
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colunaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

			// Adiciona a Observable Array na TableView
			tabelaFuncionarios.setItems(obsListMotoristas);

		}
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	carregarTableView();
		
	}

}
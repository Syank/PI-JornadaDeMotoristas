package control;

import java.net.URL;
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


	public static boolean atualizarTableViewEComboBox = false;
	
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






	public void carregarComboBoxTurnos() {
		turnos = t.listarTurnos();
		turnosList = FXCollections.observableArrayList(turnos);
		cbTurno.setItems(turnosList);
		comboBoxCadastroTurno.setItems(turnosList);
	}

	public void carregarComboBoxFiliais() {
		filiais = filial.listarFiliais();
		filiaisList = FXCollections.observableArrayList(filiais);
		cbFilial.setItems(filiaisList);
		comboBoxCadastroFilial.setItems(filiaisList);


	}


	@FXML
	void descartarAlteracoes(ActionEvent event) {
		carregarInfosMotorista();
		desabilitarEdicao();
	}

	@FXML
	void esconderDicaFlutuante(MouseEvent event) {
		labelDicaFlutuante.setVisible(false);

	}

	@FXML
	void exibirDicaFlutuante(MouseEvent event) {
		if(event.getTarget().toString().contains("tfNome")) {
			labelDicaFlutuante.setText("Nome");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("tfCpf")) {
			labelDicaFlutuante.setText("CPF");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldEmail")) {
			labelDicaFlutuante.setText("Email");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("pfSenha")) {
			labelDicaFlutuante.setText("Senha");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("cbCargo")) {
			labelDicaFlutuante.setText("Cargo");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("cbFilial")) {
			labelDicaFlutuante.setText("Filial");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("cbTurno")) {
			labelDicaFlutuante.setText("Turno");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldSalarioMotorista")) {
			labelDicaFlutuante.setText("Motorista");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("tfCargaHoraria")) {
			labelDicaFlutuante.setText("Carga horária");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroNome")) {
			labelDicaFlutuante.setText("Nome");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroCpf")) {
			labelDicaFlutuante.setText("CPF");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroEmail")) {
			labelDicaFlutuante.setText("Email");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroSenha")) {
			labelDicaFlutuante.setText("Senha");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroConfirmarSenha")) {
			labelDicaFlutuante.setText("Confirmar senha");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("comboBoxCadastroFilial")) {
			labelDicaFlutuante.setText("Filial");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("comboBoxCadastroTurno")) {
			labelDicaFlutuante.setText("Turno");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroCargaHoraria")) {
			labelDicaFlutuante.setText("Carga horária");
			labelDicaFlutuante.setVisible(true);
		}
		else if (event.getTarget().toString().contains("textFieldCadastroSalario")) {
			labelDicaFlutuante.setText("Salário");
			labelDicaFlutuante.setVisible(true);
		}

		labelDicaFlutuante.setLayoutX(event.getSceneX());
		labelDicaFlutuante.setLayoutY(event.getSceneY());

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

	   	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que está selecionado na combobox é igual ao funcionário da viagem
    	while(!motorista.getFilial().getNome().equals(cbFilial.getSelectionModel().getSelectedItem().getNome())) {
    		cbFilial.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}
		
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


		labelSituacaoMotorista.setText("Situação: Parado");
		//Essa "coisa" abaixo é um 'for coisa in lista' embelezado do java
		listaDeViagens.forEach(item -> {
			if(item.getMotorista().getCpf().equals(ControlesLogin.cpfLogado)) {
				if(item.getSituacao().equals("Em andamento")) {
					labelSituacaoMotorista.setText("Situação: Em viagem");
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
			diasDeTrabalho += ", Terça-Feira";
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
			diasDeTrabalho += " e Sábado";
		}
		if(!dom) {
			diasDeTrabalho = diasDeTrabalho.substring(2); // Tira ", " caso não trabalhe domingo
		}

		solicitacao = "Solicito o cadastro do motorista com as seguintes informações:\n"
				+ "Nome: " + nome + "\n"
				+ "CPF: " + cpf + "\n"
				+ "E-mail: " + email + "\n"
				+ "Senha: " + senha + "\n"
				+ "Carga Horária: " + cargaHoraria + "\n"
				+ "Salário: " + salario + "\n"
				+ "Turno: " + turno + "\n"
				+ "Dias de trabalho: " + diasDeTrabalho + "\n"
				+ "Pertencendo a Filial " + nomeFilial + ", de ID igual a: " + String.valueOf(idFilial);

		aviso.solicitarCadastro(ControlesLogin.cpfLogado, solicitacao);

		System.out.println("Solicitação enviada!");
	}

	@FXML
	void requisitarAlteracaoFuncionario(ActionEvent event) {
		funcao = "Funcionario";
		notificar("Confirmar", "Confirmar senha do usuário", "Por favor, confirme sua senha no campo abaixo para confirmar as alterações nos dados");
	}
	@FXML
	void alterarDados(ActionEvent event) {
		Motorista motorista = new Motorista().encontrarMotorista(cpfMotorista);
		if(confirmado) {
			if (Integer.parseInt(textFieldSalarioMotorista.getText()) < 1701.38) {
				notificar("Falha", "Salário baixo", "O salário digitado é muito baixo. Escreva um salário válido.");
			}
			else if (Integer.parseInt(tfCargaHoraria.getText()) > 12) {
				notificar("Falha de cadastro", "Carga horária", "A carga horária diária previamente acordada pode ser no máximo de 12 horas. Verifique o valor e tente novamente.");
			}
			else {
				motorista.alterarDadosMotorista(motorista.getCpf(), tfNome.getText(), 
						textFieldEmail.getText(), pfSenha.getText(), 
						textFieldSalarioMotorista.getText(), tfCargaHoraria.getText(), 
						cbFilial.getValue().getId(), cbTurno.getValue().getTurno(),
						cbSeg.isSelected(), cbTer.isSelected(), cbQua.isSelected(), cbQui.isSelected(), cbSex.isSelected(), cbSab.isSelected(), cbDom.isSelected());

				notificar("Sucesso", "Alteração de dados",
						"Os dados do funcionário " + tfNome.getText() + " foram alterados no banco de dados com sucesso");
				carregarTableView();
			}



		}
		else {
			notificar("Falha", "Senha de confirmação incorreta", "A senha de verificação estava incorreta, tente novamente");
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
		paneCadastrarMotorista.setVisible(false);
		paneCadastrarMotorista.setDisable(true);

		paneSelecionarOpcao.setVisible(true);
		paneSelecionarOpcao.setDisable(false);

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);

		paneMotoristaSelecionado.setVisible(false);
		paneMotoristaSelecionado.setDisable(true);
	}

	@FXML
	void abrirTelaAvisos(MouseEvent event) {
		paneCadastrarMotorista.setVisible(false);
		paneCadastrarMotorista.setDisable(true);

		paneSelecionarOpcao.setVisible(true);
		paneSelecionarOpcao.setDisable(false);

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);

		paneMotoristaSelecionado.setVisible(false);
		paneMotoristaSelecionado.setDisable(true);

		ControlesPerfilSuperAvisos.atualizarInfos = true;
		Main.trocarTela("Tela Supervisor Avisos");
	}

	@FXML
	void abrirTelaHistEntregas(MouseEvent event) {
		paneCadastrarMotorista.setVisible(false);
		paneCadastrarMotorista.setDisable(true);

		paneSelecionarOpcao.setVisible(true);
		paneSelecionarOpcao.setDisable(false);

		paneMotoristas.setVisible(false);
		paneMotoristas.setDisable(true);

		paneMotoristaSelecionado.setVisible(false);
		paneMotoristaSelecionado.setDisable(true);

		Main.trocarTela("Tela Supervisor Entregas");
	}


	// Essas 3 funções a baixo você pode copiar das outras telas
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
		// Listas, nos seus métodos get
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

		// Adiciona a Observable Array na TableView
		tabelaFuncionarios.setItems(obsListMotoristas);

	}


	void tarefasEmLoop() {
		// Considere que cada if aqui dentro é uma "função"

		if(atualizarTableViewEComboBox) {
			carregarTableView();
			carregarComboBoxFiliais();
			atualizarTableViewEComboBox = false;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarComboBoxTurnos();

		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask(){


			@Override
			public void run() {
				Platform.runLater(() -> tarefasEmLoop());
			}
		}, 0, 1000);
	}

}

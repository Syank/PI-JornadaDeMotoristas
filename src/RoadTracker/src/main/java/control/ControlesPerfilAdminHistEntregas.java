package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.*;

public class ControlesPerfilAdminHistEntregas {

    @FXML
    private TextField campoDeBuscaNome;

    @FXML
    private TextField campoDeBuscaCpf;

    @FXML
    private Button botaoBuscar;

    @FXML
    private Button botaoSelecionar;
    
    @FXML
    private TextField campoDeBuscaMotorista;

    @FXML
    private TableView<Listas> tabela;

    @FXML
    private TableColumn<Listas, String> colunaId;

    @FXML
    private TableColumn<Listas, String> colunaEmpresaDestino;

    @FXML
    private TableColumn<Listas, String> colunaMotorista;
    
    
    
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	System.out.println("Clicou em cad func");
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }
    
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	System.out.println("Clicou em func");
    	Main.trocarTela("Tela Funcionarios");
    }


    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Boas Vindas");
    }
    
    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

}

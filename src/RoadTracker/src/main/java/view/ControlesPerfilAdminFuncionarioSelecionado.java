package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ControlesPerfilAdminFuncionarioSelecionado {

    @FXML
    private Button botaoBuscar;

    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }

    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }

}

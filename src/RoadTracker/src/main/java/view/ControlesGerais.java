package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ControlesGerais {
	
	
	// Funções para trocar telas
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }
    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	Main.trocarTela("Tela Historico de Entregas");
    }
    @FXML
    void abrirTelaFuncionarios(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
    }
    @FXML
    void selecionarFuncionario(ActionEvent event) {
    	Main.trocarTela("Tela Selecionar Funcionario");
    }
    
    
    
    // Função para voltar à tela de login
    @FXML
    void voltar(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }
    
    // Função para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.exit(0);
    }
}

package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ControlesPerfilAdminCadMot {

    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	System.out.println("Clicou em func");
    	Main.trocarTela("Tela Funcionarios");
    }

    @FXML
    void abrirTelaHistEntregas(MouseEvent event) {
    	System.out.println("Clicou em hist ent");
    	Main.trocarTela("Tela Historico de Entregas");
    }

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

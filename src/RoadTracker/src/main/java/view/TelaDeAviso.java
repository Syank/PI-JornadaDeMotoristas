package view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class TelaDeAviso{
	Stage telaAviso = new Stage();
	
    @FXML
    private Button botao;
	
	public void display(String titulo) throws IOException {

		telaAviso.initModality(Modality.APPLICATION_MODAL);
		//telaAviso.initStyle(StageStyle.UNDECORATED);
		
		Parent fxmlAviso = FXMLLoader.load(getClass().getResource("FXMLTelaDeAviso.fxml"));
		
		Scene cenaTelaAviso = new Scene(fxmlAviso);
		
	 
		telaAviso.setScene(cenaTelaAviso);
		telaAviso.showAndWait();

	}

    @FXML
    void cancelarAcao(ActionEvent event) {
    	System.out.println("Cancelado");
    	//Platform.runLater(() -> telaAviso.close());
    	System.out.println("2");

    }

    @FXML
    void confirmarAcao(ActionEvent event) {
    	System.out.println("Confirmado");
    }
	
    @FXML
    void fecharJanela(ActionEvent event) {
    	System.out.println("Fechado");
    	telaAviso.close();
    }


    
}

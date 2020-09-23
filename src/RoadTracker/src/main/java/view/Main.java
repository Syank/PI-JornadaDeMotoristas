package view;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	// Inicializando váriaveis para guardar as telas
	private static Stage stage;
	private static Scene tela1;
	private static Scene tela2;
	private static Scene tela3;
	private static Scene tela4;
	private static Scene tela6;



	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;

		
		primaryStage.setTitle("RoadTracker");  // Muda o título da janela
		primaryStage.initStyle(StageStyle.UNDECORATED);  // Tira a borda padrão do SO da janela
		// Carrega as telas
		Pane fxmlTela1 = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
		tela1 = new Scene(fxmlTela1);
	
		Pane fxmlTela2 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminFuncionariosSelect.fxml"));
		tela2 = new Scene(fxmlTela2);
		
		Pane fxmlTela3 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminCadMot.fxml"));
		tela3 = new Scene(fxmlTela3);
		
		Pane fxmlTela4 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminEntregas.fxml"));
		tela4 = new Scene(fxmlTela4);

		Pane fxmlTela6 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminBoasVindas.fxml"));
		tela6 = new Scene(fxmlTela6);

		 
		// Seta a janela atual e a exibe
		primaryStage.setScene(tela1);
		primaryStage.show();
		
	}
	
	

	public static void trocarTela(String escolha){
		switch (escolha) {
			case "Tela Login":
				stage.setScene(tela1);
				break;
			case "Tela Funcionarios":
				stage.setScene(tela2);
				break;
			case "Tela Cadastrar Funcionarios":
				stage.setScene(tela3);
				break;
			case "Tela Historico de Entregas":
				stage.setScene(tela4);
				break;
			case "Tela Boas Vindas":
				stage.setScene(tela6);
				break;

		}
	}

	
	public static void minimizar() {
		stage.setIconified(true);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

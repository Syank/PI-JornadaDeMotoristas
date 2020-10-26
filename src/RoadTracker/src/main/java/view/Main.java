package view;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	// Inicializando váriaveis para guardar as telas
	private static Stage stage;
	private static Scene tela1;
	private static Scene tela2;
	private static Scene tela3;
	private static Scene tela4;
	private static Scene tela5;
	private static Scene tela6;
	private static Scene tela7;
	private static Scene tela8;
	private static Scene tela9;
	private static Scene tela10;

	private static double offSetX;
	private static double offSetY;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;

		primaryStage.setTitle("RoadTracker");  // Muda o título da janela
		primaryStage.initStyle(StageStyle.UNDECORATED);  // Tira a borda padrão do SO da janela
		
		// Carrega as telas
		Pane fxmlTela1 = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
		tela1 = new Scene(fxmlTela1);
	
		Pane fxmlTela2 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminEntidades.fxml"));
		tela2 = new Scene(fxmlTela2);

		Pane fxmlTela3 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminCadastrarEntidades.fxml"));
		tela3 = new Scene(fxmlTela3);
		
		Pane fxmlTela4 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminEntregas.fxml"));
		tela4 = new Scene(fxmlTela4);

		Pane fxmlTela5 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminBoasVindas.fxml"));
		tela5 = new Scene(fxmlTela5);

		Pane fxmlTela6 = FXMLLoader.load(getClass().getResource("FXMLPerfilAdminAvisos.fxml"));
		tela6 = new Scene(fxmlTela6);
		
		Pane fxmlTela7 = FXMLLoader.load(getClass().getResource("FXMLPerfilMotViagens.fxml"));
		tela7 = new Scene(fxmlTela7);
		
		Pane fxmlTela8 = FXMLLoader.load(getClass().getResource("FXMLPerfilMotViagemAtual.fxml"));
		tela8 = new Scene(fxmlTela8);
		
		Pane fxmlTela9 = FXMLLoader.load(getClass().getResource("FXMLPerfilMotAvisos.fxml"));
		tela9 = new Scene(fxmlTela9);
		
		Pane fxmlTela10 = FXMLLoader.load(getClass().getResource("FXMLPerfilSuperEntidades.fxml"));
		tela10 = new Scene(fxmlTela10);
		
	//	Pane fxmlTela11 = FXMLLoader.load(getClass().getResource("FXMLPerfilSuperEntregas.fxml"));
	//	tela11 = new Scene(fxmlTela11);
		
		// Aplicando o método de mover tela para todas as telas
		Scene[] telas = {tela1, tela2, tela3, tela4, tela5, tela6, tela7, tela8, tela9, tela10};

		for(int i = 0; i < telas.length; i++) {
			telas[i].setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					offSetX = event.getSceneX();
					offSetY = event.getSceneY();
				}
			});
			telas[i].setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					stage.setOpacity(0.75);
					
					stage.setX(event.getScreenX() - offSetX);
					stage.setY(event.getScreenY() - offSetY);
				}
			});
			telas[i].setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					stage.setOpacity(1.0);
				}
			});
		}
		
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
				stage.setScene(tela5);
				break;
			case "Tela Avisos":
				stage.setScene(tela6);
				break;
			case "Mot Viagens":
				stage.setScene(tela7);
				break;
			case "Viagem Selecionada":
				stage.setScene(tela8);
				break;
			case "Criar Aviso":
				stage.setScene(tela9);
				break;
			case "Tela Inicial Supervisor":
				stage.setScene(tela10);
		}
	}
	
	public static void minimizar() {
		stage.setIconified(true);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

package basics.components;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *  ${TODO} Klassenbeschreibung
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: HelloMain.java 31604 10/5/2017 15:46  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class Main extends Application {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Test.fxml"));
		AnchorPane contentPane = fxmlLoader.load();
		primaryStage.setScene(new Scene(contentPane, WIDTH, HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

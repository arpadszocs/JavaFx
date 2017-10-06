package basics.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: HelloMain.java 31604 10/5/2017 15:40  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class HelloMain extends Application {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Test.fxml"));
		AnchorPane contentPane = fxmlLoader.load();
		Scene scene = new Scene(contentPane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

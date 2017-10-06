package basics.nestedControllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: NestedMain.java 31604 10/6/2017 10:36  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/6/2017
 */
public class NestedMain extends Application {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Parent.fxml"));
		AnchorPane contentPane = fxmlLoader.load();
		primaryStage.setScene(new Scene(contentPane, WIDTH, HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

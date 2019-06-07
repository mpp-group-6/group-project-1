package ui;
	
import java.nio.file.Paths;
import java.util.Optional;

import controller.MainController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends BaseWindow {
	Stage primaryStage;
	@FXML
	TextField userName;
	@FXML
	TextField password;
	@FXML
	Button button;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Parent root =
					FXMLLoader.load(Paths.get(fxmlFolder, "Login.fxml").toUri().toURL());
			//Paths.get(fxmlFolder, "Login.fxml").toString()
			Scene scene = new Scene(root);
			
			//scene.getStylesheets().add(getClass().getResource("resources/bootstrap3.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			
			primaryStage.show();
//			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void login(ActionEvent event) {
		System.out.println("Login "+userName.getText()+"; ");
		
		Node node = (Node)event.getSource();
		node.getScene().getWindow().hide();
		
		try {
             
			//System.out.println(getClass().getResource("views/Main.fxml"));
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(getClass().getResource("view/Main.fxml"));
//			Parent XD = loader.load();
//
//            MainController stage2Controller = (MainController)loader.getController();
			MainController controller = new MainController();
			controller.loadView();
            //stage2Controller.loadView();
            // Show the scene containing the root layout.
//            Scene scene = new Scene(XD);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
		//primaryStage.hide();
	}
	@FXML
	private void closeAction(MouseEvent event){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation ");
		alert.setHeaderText("You are about to close");
		alert.setContentText("Do you confirm?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    // ... user chose OK
			Platform.exit();
		} else {
		    // ... user chose CANCEL or closed the dialog
		}	
	}
	public static void main(String[] args) {
		launch(args);
	}
}

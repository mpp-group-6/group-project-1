package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AddMember  extends Stage implements LibWindow {
	public static final AddMember INSTANCE = new AddMember();
	
	private boolean isInitialized = false;
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}	
		
	public void init() {
		
		
			try {
				//BorderPane root = new BorderPane();
				Parent root = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
				//Scene scene = new Scene(root,569,465);
				root.getStylesheets().add(getClass().getResource("addMember.css").toExternalForm());
				//scene.getStylesheets().add(getClass().getResource("/ressources/fxml/library.css").toExternalForm());
		        //setScene(scene);
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
		
		
}

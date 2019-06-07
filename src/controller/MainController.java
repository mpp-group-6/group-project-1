package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.dao.LibraryMemberRepository;
=======
import java.util.List;
import java.util.ResourceBundle;

import business.value.Permission;
>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
<<<<<<< HEAD
import ui.AllMembersWindow;
import ui.ListAllMembers;
=======
import ui.CheckoutWindow;
>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca

public class MainController implements Initializable {
	public static final String fxmlFolder = Paths.get(System.getProperty("user.dir"), "resources", "fxml").toString();
	public static MainController mainController;
	@FXML
	Label labelMenu;
	@FXML
	TextArea logArea;
	@FXML
	Menu memberItemMenu;
	@FXML
	Menu BooksItemMenu;
	@FXML
	Menu CheckOutItemMenu;
	@FXML
	AnchorPane centralPane;

	public MainController() {
		super();
		memberItemMenu = new Menu();
		BooksItemMenu = new Menu();
		CheckOutItemMenu = new Menu();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		mainController = this;
		List<Permission> listPermission = SystemController.currentAuth;
		memberItemMenu.setVisible(false);
		BooksItemMenu.setVisible(false);
		CheckOutItemMenu.setVisible(false);
		if (listPermission.contains(Permission.LIBRARIAN)) {
			CheckOutItemMenu.setVisible(true);
		}
		if (listPermission.contains(Permission.ADMIN)) {
			memberItemMenu.setVisible(true);
			BooksItemMenu.setVisible(true);
		}
		if (listPermission.contains(Permission.ADMIN) && listPermission.contains(Permission.LIBRARIAN)) {
			memberItemMenu.setVisible(true);
			BooksItemMenu.setVisible(true);
			CheckOutItemMenu.setVisible(true);
		}
	}

	@FXML
	private void hidePanAction(ActionEvent event) {
		System.out.println("Hide Button");
	}

	@FXML
	private void newBookCopyMenuAction(ActionEvent event) throws IOException {
		labelMenu.setText("Creation of a new copy of a book");
		messageConsole("#Activation new Book Copy Menu Action");
		System.out.println("#Activation new Book Copy Menu Action");

		AnchorPane pane = FXMLLoader.load(Paths.get(fxmlFolder, "NewBookCopy.fxml").toUri().toURL());
		
		centralPane.getChildren().setAll(pane);
<<<<<<< HEAD
		//content.getChildren().setAll(FXMLLoader.load("vista2.fxml"));
//		centralPan		
=======
		
>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca
	}

	@FXML
	private void listBookMenuAction(ActionEvent event) throws IOException {
		labelMenu.setText("List of the book in the Library");
		messageConsole("#Activation List of the book Menu Action");
		System.out.println("#Activation List of the book Menu Action");

		AnchorPane pane = FXMLLoader.load(Paths.get(fxmlFolder, "ListBook.fxml").toUri().toURL());

		centralPane.getChildren().setAll(pane);
	}

	

	@FXML
<<<<<<< HEAD
	private void viewBooksMenuAction(ActionEvent event){
		labelMenu.setText("List Of Books recorded");
		System.out.println("Activation view Books Menu Action");
		messageConsole("#Activation view Books Menu Action");
	}
	
	@FXML
	private void listMembersMenuAction(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(Paths.get(fxmlFolder, "ListAllMembers.fxml").toUri().toURL());
		
		centralPane.getChildren().setAll(pane);
		
		labelMenu.setText("List of all members");
		
		DataAccess da=new DataAccessFacade();
		HashMap<String,LibraryMember> hash=da.readMemberMap();
		for(Entry ent : hash.entrySet()) {
			LibraryMember mb=(LibraryMember) ent.getValue();
			messageConsole(mb.toString());
			//System.out.println(mb);
		}
	
				
	}

	@FXML
	private void registerMembersMenuAction(ActionEvent event)throws IOException{
		AnchorPane pane = FXMLLoader.load(Paths.get(fxmlFolder, "AddMember.fxml").toUri().toURL());
		
		
		//centralPane = new AnchorPane();
		centralPane.getChildren().setAll(pane);
=======
	private void listMembersMenuAction(ActionEvent event) {
		labelMenu.setText("List Of Members recorded");
		System.out.println("Activation view Members Menu Action");
		messageConsole("#Activation view Members Menu Action");
	}

	@FXML
	private void registerMembersMenuAction(ActionEvent event) {
>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca
		labelMenu.setText("Register New Member");
		System.out.println("Activation Register New Member Menu Action");
		messageConsole("#Activation Register New Member Menu Action");
	}

	@FXML
	private void checkOutBookMenuAction(ActionEvent event) {
		labelMenu.setText("Check-Out Book");
		System.out.println("Activation Check-Out Book Menu Action");
		centralPane.getChildren().setAll(CheckoutWindow.getView());
		messageConsole("#Activation Check-Out Book Menu Action");
	}

	@FXML
	private void closeApllicationMenuAction(ActionEvent event) {
		Platform.exit();
	}

	public void loadView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Paths.get(fxmlFolder, "Main.fxml").toUri().toURL());
		Parent XD = loader.load();

<<<<<<< HEAD
        // Show the scene containing the root layout.
        Scene scene = new Scene(XD);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("addMember.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
=======
		// Show the scene containing the root layout.
		Scene scene = new Scene(XD);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca
	}

	public void messageConsole(String message) {
		Text text_1 = new Text("" + message + "\n");
		text_1.setFill(Color.RED);

		// set font of the text
		text_1.setFont(Font.font("Verdana", 15));
		System.out.println(message);
		logArea.setText("" + message + "\n" + logArea.getText());

	}

	public void messageConsole(String message, String sumMessage) {
		Date date = new Date();
		Text text_1 = new Text("" + message + "; ");
		text_1.setFill(Color.RED);
		
		text_1.setFont(Font.font("Verdana", 15));

		Text text_2 = new Text(sumMessage + "\n");
		text_2.setFill(Color.WHITESMOKE);
		
		text_2.setFont(Font.font("Verdana", 15));
		System.out.println(message);
		
		logArea.setText("" + message + "\n" + sumMessage + "\n" + logArea.getText());
	}

}

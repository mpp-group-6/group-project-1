package ui;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import javax.naming.Context;



import business.Address;
import business.Book;
import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListAllMembers implements Initializable{
	public static final String fxmlFolder = Paths.get(System.getProperty("user.dir"), 
	        "resources", "fxml").toString();
	
	@FXML
	TableView<LibraryMember> tabMember;
	
	@FXML
	TableColumn<LibraryMember, String> memberId;	
	@FXML
	TableColumn<LibraryMember, String> firstNa;	
	@FXML
	TableColumn<LibraryMember, String> lastNa;
	@FXML
	TableColumn<LibraryMember, String> t_phone;	
	@FXML
	TableColumn<Address, String> t_street;
	@FXML
	TableColumn<Address, String> t_city;	
	@FXML
	TableColumn<Address, String> t_state;
	@FXML
	TableColumn<Address, String> t_zip;
	
	
	@FXML
	Button btn_test;
	
	@FXML
	public void testBotton() {
		
		t_street=new TableColumn<Address, String>();
		
		DataAccess da=new DataAccessFacade();
		HashMap<String,LibraryMember> hash=da.readMemberMap();
		
		List<LibraryMember> result2 = hash.values().stream()
				.collect(Collectors.toList());
		
		//List<String> list = hash.values().stream()
	      //        .map(b -> b.getFirstName()+":"+b.getLastName()+":"+b.getTelephone()+":"+b.getAddress().getStreet()+":"+b.getAddress().getCity()+":"+b.getAddress().getState()+":"+b.getAddress().getZip())
	        //      .collect(Collectors.toList());
		
		firstNa.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("memberId"));
		firstNa.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("FirstName"));
		lastNa.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("LastName"));
		t_phone.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("telephone"));
		t_street.setCellValueFactory(new PropertyValueFactory<Address,String>("street"));
		t_city.setCellValueFactory(new PropertyValueFactory<Address,String>("city"));
		t_state.setCellValueFactory(new PropertyValueFactory<Address,String>("state"));
		t_zip.setCellValueFactory(new PropertyValueFactory<Address,String>("zip"));
		
		tabMember.setItems(FXCollections.observableArrayList(result2));
	
	}
	
	
	
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
				//FXMLLoader.load(getClass().getResource("/ui/ListAllMembers.fxml"));//
				Parent root = FXMLLoader.load(Paths.get(fxmlFolder, "ListAllMembers.fxml").toUri().toURL());//FXMLLoader.load(getClass().getResource("ListAllMembers.fxml"));
				//Scene scene = new Scene(root,569,465);
				root.getStylesheets().add(getClass().getResource("addMember.css").toExternalForm());
				//scene.getStylesheets().add(getClass().getResource("/ressources/fxml/library.css").toExternalForm());
		        //setScene(scene);
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
t_street=new TableColumn<Address, String>();
		
		DataAccess da=new DataAccessFacade();
		HashMap<String,LibraryMember> hash=da.readMemberMap();
		
		List<LibraryMember> result2 = hash.values().stream()
				.collect(Collectors.toList());
		
		//List<String> list = hash.values().stream()
	      //        .map(b -> b.getFirstName()+":"+b.getLastName()+":"+b.getTelephone()+":"+b.getAddress().getStreet()+":"+b.getAddress().getCity()+":"+b.getAddress().getState()+":"+b.getAddress().getZip())
	        //      .collect(Collectors.toList());
		
		firstNa.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("FirstName"));
		lastNa.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("LastName"));
		t_phone.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("telephone"));
		t_street.setCellValueFactory(new PropertyValueFactory<Address,String>("street"));
		t_city.setCellValueFactory(new PropertyValueFactory<Address,String>("city"));
		t_state.setCellValueFactory(new PropertyValueFactory<Address,String>("state"));
		t_zip.setCellValueFactory(new PropertyValueFactory<Address,String>("zip"));
		
		tabMember.setItems(FXCollections.observableArrayList(result2));
		
	}
	
	

}

/**
 * 
 */
package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import business.Book;
import business.BookCopy;
import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author pogoromuald
 *
 */
public class BookController  implements Initializable{
	@FXML
	Book book;
	@FXML
	BookCopy bookCopy;
	@FXML
	ComboBox<String> listBooks;
	@FXML
	TableView<Book> tableBook;
	@FXML
	TableColumn<Book, String> titleNameColum;
	@FXML
	TableColumn<Book, String> isbnNameColum;
	@FXML
	TableColumn<Book, String> autorNameColum;
	@FXML
	TableColumn<Book, String> copyNameColum;
	@FXML
	TextField numCopyBook;
	DataAccessFacade daFacade = new DataAccessFacade();
	public BookController() {
		super();
		listBooks = new ComboBox<>(); 
		
		tableBook = new TableView<>();
		titleNameColum = new TableColumn<>();
		isbnNameColum = new TableColumn<>();
		autorNameColum = new TableColumn<>();
		copyNameColum = new TableColumn<>();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		HashMap<String,Book> hmapBook =  daFacade.readBooksMap();
		List<Book> result2 = hmapBook.values().stream()
				.collect(Collectors.toList());
		
		//List<String> list = result2.stream().;
		List<String> list = 
				hmapBook.values().stream()
	              .map(b -> b.getTitle()+":"+b.getIsbn())
	              .collect(Collectors.toList());
		
		listBooks.getItems().clear();
		listBooks.getItems().addAll(list);
		MainController.mainController.messageConsole("#List of Books : "+list);
		
		titleNameColum.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
		isbnNameColum.setCellValueFactory(new PropertyValueFactory<Book,String>("isbn"));
		autorNameColum.setCellValueFactory(new PropertyValueFactory<Book,String>("isbn"));
		copyNameColum.setCellValueFactory(new PropertyValueFactory<Book,String>("isbn"));
		tableBook.setItems(FXCollections.observableArrayList(result2));
	}

	@FXML
	private void comboBookSelectAction(ActionEvent event){
		MainController.mainController.messageConsole("#Book Selected : ",listBooks.getValue());
	}
	
	@FXML
	private void saveBookCopy(ActionEvent event) {
		MainController.mainController.messageConsole("#Save of The Copy of The Book : "+listBooks.getValue());
		MainController.mainController.messageConsole("Num Copy : "+numCopyBook.getText());
	}

}

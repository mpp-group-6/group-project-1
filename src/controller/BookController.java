/**
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import business.Author;
import business.Book;
import business.BookCopy;
import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
//	@FXML
//	TableColumn<Book, String> autorNameColum;
//	@FXML
//	TableColumn<Book, String> copyNameColum;
	@FXML
	Label autorOfListBookPage;
	@FXML 
	Label numCopyOfListBookPage;
	@FXML
	TextField numCopyBook;
	@FXML
	Label labelMessageNewBookCopyPage;

	DataAccessFacade daFacade = new DataAccessFacade();
	public BookController() {
		super();
		listBooks = new ComboBox<>(); 
		
		tableBook = new TableView<>();
		titleNameColum = new TableColumn<>();
		isbnNameColum = new TableColumn<>();
		
		autorOfListBookPage = new Label();
		numCopyOfListBookPage = new Label();
		
		numCopyBook = new TextField();
		labelMessageNewBookCopyPage = new Label();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		HashMap<String,Book> hmapBook =  daFacade.readBooksMap();
		List<Book> result2 = hmapBook.values().stream()
				.collect(Collectors.toList());
		
		
		List<String> list = 
				hmapBook.values().stream()
	              .map(b -> b.getTitle()+":"+b.getIsbn())
	              .collect(Collectors.toList());
		
		listBooks.getItems().clear();
		listBooks.getItems().addAll(list);
		
		titleNameColum.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
		isbnNameColum.setCellValueFactory(new PropertyValueFactory<Book,String>("isbn"));

		tableBook.setItems(FXCollections.observableArrayList(result2));
		tableBook.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	Book b = tableBook.getSelectionModel().getSelectedItem();
		    	MainController.mainController.messageConsole("#Selection book : "+b.getTitle());
		    	List<Author> listAuthor = b.getAuthors();
		    	String authors = "";
		    	for (Author author : listAuthor) {
		    		authors +=author.getFirstName()+" "+author.getLastName()+" ";
				}

		    	autorOfListBookPage.setText(authors);
		    	numCopyOfListBookPage.setText(String.valueOf(b.getNumCopies()));
		    }
		});
		
		autorOfListBookPage.setText("");
		numCopyOfListBookPage.setText("");
		
		numCopyBook.setText("");
		labelMessageNewBookCopyPage.setText("");
		
	}

	@FXML
	private void comboBookSelectAction(ActionEvent event){
		MainController.mainController.messageConsole("#Book Selected : ",listBooks.getValue());
	}
	
	@FXML
	private void saveBookCopy(ActionEvent event) throws Exception {
		MainController.mainController.messageConsole("#Save of The Copy of The Book : "+listBooks.getValue());
		MainController.mainController.messageConsole("Num Copy : "+numCopyBook.getText());
		String[] data = listBooks.getValue().trim().split(":");
		Optional<Book> opBook = daFacade.readBooksMap().values().stream().filter(e -> e.getIsbn().equals(data[1])).findFirst();
		Book book = opBook.get();
		for(Integer i=1; i<=Integer.parseInt(numCopyBook.getText());i++)
			book.addCopy();

		daFacade.saveBook(book);
		numCopyBook.setText("");
		labelMessageNewBookCopyPage.setText("Message : New copies recorded");

	}
	
	@FXML
    private void buttonListAction(ActionEvent event) {
	    MainController.mainController.messageConsole("#Save of The Copy of The Book : ");
	    
	}

}

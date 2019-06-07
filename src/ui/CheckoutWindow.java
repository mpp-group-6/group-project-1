package ui;

import java.nio.file.Paths;
import java.util.function.Function;
import business.CheckoutRecord;
import business.CheckoutEntry;
import controller.CheckoutController;
import dataaccess.exception.BookNotFound;
import exception.BookCopyNotAvailable;
import exception.LibraryMemberNotFound;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ui.objects.CheckoutRecordTable;

public class CheckoutWindow
{
    
    @SuppressWarnings("unchecked")
    public static Pane getView(Function<Pane, Boolean> stageChangerFunction) {
        GridPane form = new GridPane();
        form.setVgap(20);
        form.setHgap(20);
        form.setPadding(new Insets(200));
        Label memberIdLabel = new Label("memberID");
        TextField memberIdInput = new TextField();
        Label ISBNLabel = new Label("ISBN");
        TextField isbnInput = new TextField();
        Button checkoutButton = new Button("checkout");
        form.add(memberIdLabel, 0, 0);
        form.add(memberIdInput, 1, 0);
        form.add(ISBNLabel, 0, 1);
        form.add(isbnInput, 1, 1);
        form.add(checkoutButton, 0, 2);
        checkoutButton.setOnAction(event->{
            CheckoutController checkoutController = new CheckoutController();
            try
            {
                Double preferedWidth = 660.0;
                CheckoutRecord record = checkoutController.checkout(memberIdInput.getText(), isbnInput.getText());
                VBox vbox = new VBox();
                Label label = new Label(String.format("Checkout record for %s, %s", record.getMember().getFirstName(), record.getMember().getLastName()));
                Label memberIdDisplay = new Label(String.format("MemberId: %s", record.getMember().getMemberId()));
                @SuppressWarnings("rawtypes")
                TableView table = new TableView<>();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(20));
                TableColumn<String, CheckoutRecordTable> checkoutDate = new TableColumn<>("Checkout Date");
                checkoutDate.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
                TableColumn<String, CheckoutRecordTable> dueDate = new TableColumn<>("Due Date");
                dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
                TableColumn<String, CheckoutRecordTable> isbn = new TableColumn<>("isbn");
                isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
                TableColumn<String, CheckoutRecordTable> bookTitle = new TableColumn<>("Book Title");
                bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
                TableColumn<String, CheckoutRecordTable> authors = new TableColumn<>("Authors");
                authors.setCellValueFactory(new PropertyValueFactory<>("Authors"));
//                TableColumn<String, CheckoutRecordTable> copiesLeft = new TableColumn<>("Available Copies Remaining");
//                copiesLeft.setCellValueFactory(new PropertyValueFactory<>("copiesLeft"));
                TableColumn<String, CheckoutRecordTable> copyId = new TableColumn<>("Copy Id");
                copyId.setCellValueFactory(new PropertyValueFactory<>("copyId"));
                table.getColumns().addAll(bookTitle, isbn, authors, copyId, checkoutDate, dueDate);
                table.setMinWidth(preferedWidth);
                record.getCheckoutEntries().forEach(item->table.getItems().add(new CheckoutRecordTable(item)));
                vbox.getChildren().addAll(label, memberIdDisplay, table);
                vbox.setMinWidth(preferedWidth);
                stageChangerFunction.apply(vbox);
            }
            catch (LibraryMemberNotFound e)
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Member not registered");
                alert.show();
            }
            catch (BookNotFound e)
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Book not found");
                alert.show();
            }
            catch (BookCopyNotAvailable e)
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("No copies are available for this book");
                alert.show();
            }
        });
        form.setAlignment(Pos.CENTER);
        return form;
        
    }
}

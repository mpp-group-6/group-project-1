package ui;

<<<<<<< HEAD
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
=======

>>>>>>> d329b9c2c33bd36b05b61cb7b276226d333c1381
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
<<<<<<< HEAD
import javafx.scene.layout.VBox;

public class CheckoutWindow
{
    
    @SuppressWarnings("unchecked")
    public static Pane getView(Function<Pane, Boolean> stageChangerFunction) {
=======
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CheckoutWindow
{
    public static Pane getView() {
>>>>>>> d329b9c2c33bd36b05b61cb7b276226d333c1381
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
                TableColumn<String, CheckoutEntry> checkoutDate = new TableColumn<>("Checkout Date");
                checkoutDate.setCellValueFactory(new PropertyValueFactory<>("checkoutDateString"));
                TableColumn<String, CheckoutEntry> dueDate = new TableColumn<>("Due Date");
                dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDateString"));
                TableColumn<String, CheckoutEntry> checkoutItem = new TableColumn<>("Checkout Item");
                checkoutItem.setCellValueFactory(new PropertyValueFactory<>("checkoutItem"));
                table.getColumns().addAll(checkoutItem, checkoutDate, dueDate);
                table.setMinWidth(preferedWidth);
                record.getCheckoutEntries().forEach(item->table.getItems().add(item));
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

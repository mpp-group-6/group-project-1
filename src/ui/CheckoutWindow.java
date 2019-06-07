package ui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CheckoutWindow
{
    public static Pane getView() {
        GridPane form = new GridPane();
        form.setVgap(20);
        form.setHgap(20);
        form.setPadding(new Insets(100));
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
        form.setAlignment(Pos.CENTER);
        return form;
        
    }
}

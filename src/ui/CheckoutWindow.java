package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CheckoutWindow
{
    public Pane getView() {
        Pane view = new AnchorPane();
        Pane form = new GridPane();
        Label memberIdLabel = new Label("memberID");
        TextField memberIdInput = new TextField();
        Label ISBNLabel = new Label("ISBN");
        TextField isbnInput = new TextField();
        Button checkoutButton = new Button("checkout");
//        form.
        return null;
        
    }
}

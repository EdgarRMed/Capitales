package App.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContinentController implements Initializable {

    @FXML
    Label continentNameLabel;

    @FXML
    // Regeresa al menú principal
    public void backToMainScene (ActionEvent event) throws IOException {
            URL url = new File("src/App/View/mainView.fxml").toURI().toURL();
            Parent mainViewParent = FXMLLoader.load(url);
            Scene continentViewScene = new Scene(mainViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(continentViewScene);
            window.show();
    }

    @FXML
    public void setContinentName(String name){
        continentNameLabel.setText(name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

package App.Controller;

import App.Model.Model;
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

    protected Model model = new Model(); // Instancia del modelo que puede ser leida por el controlador

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

    public void printButtonsContent(){
        String []content = model.generateCapitalsForButtons(model.arrayOceania, model.oceania);
        for (int i=0;i<5;i++)
            System.out.println(content[i]);
    }

    @FXML
    public void setContinentName(String name){
        continentNameLabel.setText(name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

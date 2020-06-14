package App.Controller;

import App.Model.Model;
import App.Model.Nodo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    Label paisLabel;
    @FXML
    Button capitalBtn1;
    @FXML
    Button capitalBtn2;
    @FXML
    Button capitalBtn3;
    @FXML
    Button capitalBtn4;
    @FXML
    AnchorPane continentAnchor;
    @FXML
    VBox vboxContinent;

    Nodo aux;
    int correctas, incorrectas;


    // Regresa al menú principal
    @FXML
    public void backToMainScene(ActionEvent event) throws IOException {
        URL url = new File("src/App/View/mainView.fxml").toURI().toURL();
        Parent mainViewParent = FXMLLoader.load(url);
        Scene continentViewScene = new Scene(mainViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(continentViewScene);
        window.show();
    }

    public void cambiarPais() {
        paisLabel.setText("Capital de: "+aux.pais+"");
        capitalBtn1.setText(aux.possibleCapitals[0]);
        capitalBtn2.setText(aux.possibleCapitals[1]);
        capitalBtn3.setText(aux.possibleCapitals[2]);
        capitalBtn4.setText(aux.possibleCapitals[3]);
    }

    @FXML
    public void avanzarPais(ActionEvent event) {
        capitalBtn1.setStyle("-fx-background-color: white");
        capitalBtn2.setStyle("-fx-background-color: white");
        capitalBtn3.setStyle("-fx-background-color: white");
        capitalBtn4.setStyle("-fx-background-color: white");
        String nombreBoton = ((Button) event.getSource()).getText();

        if (nombreBoton.equals("Anterior")) {
            if (aux.ant != null) {
                aux = aux.ant;
            }
        } else {
            if (aux.sig != null) {
                aux = aux.sig;
            }
        }

        cambiarPais();

        if (aux.seleccionado != 0) {
            String buttonId = "#capitalBtn" + aux.seleccionado;
            Button selectedButton = (Button) vboxContinent.lookup(buttonId);
            selectedButton.setStyle("-fx-background-color: linear-gradient(#80ffdb, #72efdd)");
        }

    }

    @FXML
    public void calificarSeleccion(ActionEvent event) {
        capitalBtn1.setStyle("-fx-background-color: white");
        capitalBtn2.setStyle("-fx-background-color: white");
        capitalBtn3.setStyle("-fx-background-color: white");
        capitalBtn4.setStyle("-fx-background-color: white");

        String nombreBoton = ((Button) event.getSource()).getId();
        aux.correcto = nombreBoton.equals(aux.capital);
        aux.seleccionado = Integer.parseInt(String.valueOf(nombreBoton.charAt(nombreBoton.length()-1)));

        Button selectedButton = ((Button) event.getSource());

        selectedButton.getStyleClass().add("button1");
        selectedButton.setStyle("-fx-background-color: linear-gradient(#80ffdb, #72efdd)");

    }

    @FXML
    public void setContinentName(String name){
        continentNameLabel.setText(name);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

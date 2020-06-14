package App.Controller;

import App.Model.ArPa;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
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
    @FXML
    ImageView banderaPais;

    ArPa continente;
    Nodo aux;
    int correctas, incorrectas;
    private boolean dioClickEnNo = false;


    // Regresa al menú principal
    @FXML
    public void backToMainScene(ActionEvent event) throws IOException {
        if (!dioClickEnNo)
            calcularPuntaje();
        setChartValues();
        URL url = new File("src/App/View/mainView.fxml").toURI().toURL();
        Parent mainViewParent = FXMLLoader.load(url);
        Scene continentViewScene = new Scene(mainViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(continentViewScene);
        window.show();
    }

    public void cambiarPais() {
        if (!continente.segundaOportunidad)
            paisLabel.setText("Capital de: " + aux.pais + "");
        else
            paisLabel.setText("Capital de:");
        capitalBtn1.setText(aux.possibleCapitals[0]);
        capitalBtn2.setText(aux.possibleCapitals[1]);
        capitalBtn3.setText(aux.possibleCapitals[2]);
        capitalBtn4.setText(aux.possibleCapitals[3]);
        String imagePath = "App/images/" + continentNameLabel.getText() + "/" + aux.pais + ".png";
        banderaPais.setImage(new Image(getClass().getClassLoader().getResource(imagePath).toExternalForm()));
    }

    @FXML
    public void avanzarPais(ActionEvent event) throws IOException {
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
            } else if (continente.segundaOportunidad) {
                calcularPuntaje();
                backToMainScene(event);
            } else {
                calcularPuntaje();
                dioClickEnNo = true;
                int respuesta = preguntarSegundaOportunidad();
                if (respuesta == 0) {
                    continente.eliminarCorrectos();
                    aux = continente.raiz;
                    continente.segundaOportunidad = true;
                } else {
                    backToMainScene(event);
                }
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
        aux.correcto = ((Button) event.getSource()).getText().equals(aux.capital);
        aux.seleccionado = Integer.parseInt(String.valueOf(nombreBoton.charAt(nombreBoton.length() - 1)));

        Button selectedButton = ((Button) event.getSource());

        selectedButton.getStyleClass().add("button1");
        selectedButton.setStyle("-fx-background-color: linear-gradient(#80ffdb, #72efdd)");

    }

    @FXML
    // Cambia los valores de la grafica dependiendo las respuestas del usuario
    public void setChartValues() {
        float totalCountries;
        switch (continentNameLabel.getText()) {
            case "América":
                totalCountries = 35;
                MainController.correctAmerica = (correctas * 100) / totalCountries;
                break;
            case "Europa":
                totalCountries = 50;
                MainController.correctEurope = (correctas * 100) / totalCountries;
                break;
            case "Asia":
                totalCountries = 48;
                MainController.correctAsia = (correctas * 100) / totalCountries;
                break;
            case "África":
                totalCountries = 54;
                MainController.correctAfrica = (correctas * 100) / totalCountries;
                break;
            case "Oceanía":
                totalCountries = 14;
                MainController.correctOceania = (correctas * 100) / totalCountries;
                break;
        }
    }

    public int preguntarSegundaOportunidad() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "Total de aciertos: "+correctas+"\n\n ¿Desea volver a responder las preguntas incorrectas?",
                "Segunda oportunidad", JOptionPane.YES_NO_OPTION);
        return respuesta;
    }

    public void calcularPuntaje() {
        for (Nodo i = aux; i != null; i = i.ant) {
            if (i.correcto)
                correctas++;
            else
                incorrectas++;
        }
    }

    @FXML
    public void setContinentName(String name) {
        continentNameLabel.setText(name);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

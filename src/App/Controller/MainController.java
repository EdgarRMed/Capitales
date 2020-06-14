package App.Controller;

import App.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    protected static float correctAmerica;
    protected static float correctEurope;
    protected static float correctAsia;
    protected static float correctAfrica;
    protected static float correctOceania;

    @FXML
    private Button americaBtn;
    @FXML
    private Button europeBtn;
    @FXML
    private Button asiaBtn;
    @FXML
    private Button africaBtn;
    @FXML
    private Button oceaniaBtn;

    protected Model model = new Model();


    @FXML
    private BarChart<?, ?> mainChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    // Se mueve a la ventana de juego
    private void createNewContinentScene(ActionEvent event) throws IOException {
        String nombreContinente = ((Button) event.getSource()).getText();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("App/View/continentView.fxml"));
        Parent mainViewParent = loader.load();
        ContinentController continentController = loader.getController();
        continentController.setContinentName(nombreContinente);

        continentController.correctas = 0;
        continentController.incorrectas = 0;

        switch (nombreContinente) {
            case "América":
                correctAmerica = 0;
                model.generateCapitalsForButtons(model.arrayAmerica, model.americaFile);
                continentController.continente = model.arrayAmerica;
                continentController.aux = model.arrayAmerica.getRaiz();
                continentController.cambiarPais();

                break;
            case "Europa":
                correctEurope = 0;
                model.generateCapitalsForButtons(model.arrayEurope, model.europeFile);
                continentController.continente = model.arrayEurope;
                continentController.aux = model.arrayEurope.getRaiz();
                continentController.cambiarPais();

                break;
            case "Asia":
                correctAsia = 0;
                model.generateCapitalsForButtons(model.arrayAsia, model.asiaFile);
                continentController.continente = model.arrayAsia;
                continentController.aux = model.arrayAsia.getRaiz();
                continentController.cambiarPais();

                break;
            case "África":
                correctAfrica = 0;
                model.generateCapitalsForButtons(model.arrayAfrica, model.africaFile);
                continentController.continente = model.arrayAfrica;
                continentController.aux = model.arrayAfrica.getRaiz();
                continentController.cambiarPais();

                break;
            case "Oceanía":
                correctOceania = 0;
                model.generateCapitalsForButtons(model.arrayOceania, model.oceaniaFile);
                continentController.continente = model.arrayOceania;
                continentController.aux = model.arrayOceania.getRaiz();
                continentController.cambiarPais();

                break;
        }

        Scene continentViewScene = new Scene(mainViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(continentViewScene);
        window.show();
    }

    public void setChart() {
        XYChart.Series set1 = new XYChart.Series<>();

        set1.getData().add(new XYChart.Data("América", correctAmerica));
        set1.getData().add(new XYChart.Data("Europa", correctEurope));
        set1.getData().add(new XYChart.Data("Asia", correctAsia));
        set1.getData().add(new XYChart.Data("África", correctAfrica));
        set1.getData().add(new XYChart.Data("Oceanía", correctOceania));
        mainChart.getData().addAll(set1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setChart();
    }
}

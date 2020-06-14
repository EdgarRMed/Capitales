package App.Controller;

import App.Model.Model;
import App.Model.Nodo;
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
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
        // Se pasan valores al controlador de la ventana continente
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("src/App/View/continentView.fxml"));
//        ContinentController continentController = loader.getController();
//        if (continentController == null)
//            System.out.println("puto");
//        //continentController.setContinentName(americaBtn.getText());
//
//        URL url = new File("src/App/View/continentView.fxml").toURI().toURL();
//        Parent mainViewParent = FXMLLoader.load(url);
//        Scene continentViewScene = new Scene(mainViewParent);
//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        window.setScene(continentViewScene);
//        window.show();

        String nombreContinente = ((Button) event.getSource()).getText();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("App/View/continentView.fxml"));
        Parent mainViewParent = loader.load();
        ContinentController continentController = loader.getController();
        continentController.setContinentName(nombreContinente);

        continentController.correctas = 0;
        continentController.incorrectas = 0;

        switch (nombreContinente) {
            case "América":
                model.generateCapitalsForButtons(model.arrayAmerica, model.americaFile);
                continentController.aux = model.arrayAmerica.getRaiz();
                continentController.cambiarPais();

                break;
            case "Europa":
                model.generateCapitalsForButtons(model.arrayEurope, model.europeFile);
                continentController.aux = model.arrayEurope.getRaiz();
                continentController.cambiarPais();

                break;
            case "Asia":
                model.generateCapitalsForButtons(model.arrayAsia, model.asiaFile);
                continentController.aux = model.arrayAsia.getRaiz();
                continentController.cambiarPais();

                break;
            case "África":
                model.generateCapitalsForButtons(model.arrayAfrica, model.africaFile);
                continentController.aux = model.arrayAfrica.getRaiz();
                continentController.cambiarPais();

                break;
            case "Oceanía":
                model.generateCapitalsForButtons(model.arrayOceania, model.oceaniaFile);
                continentController.aux = model.arrayOceania.getRaiz();
                continentController.cambiarPais();

                break;
        }

        Scene continentViewScene = new Scene(mainViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(continentViewScene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series set1 = new XYChart.Series<>();

        set1.getData().add(new XYChart.Data("América", 50.0));
        set1.getData().add(new XYChart.Data("Europa", 30.0));
        set1.getData().add(new XYChart.Data("Asia", 20.0));
        set1.getData().add(new XYChart.Data("África", 70.0));
        set1.getData().add(new XYChart.Data("Oceanía", 45.0));
        mainChart.getData().addAll(set1);
    }
}

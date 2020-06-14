package App.Controller;

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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
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


    @FXML
    private BarChart<?, ?> mainChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    // Se mueve a la ventana de juego
    private void createNewContinentScene (ActionEvent event) throws IOException {
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

        System.out.println(getClass().getClassLoader().getResource("App/View/continentView.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("App/View/continentView.fxml"));
        Parent mainViewParent = loader.load();
        ContinentController continentController = loader.getController();
        continentController.setContinentName(((Button)event.getSource()).getText());

        Scene continentViewScene = new Scene(mainViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
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

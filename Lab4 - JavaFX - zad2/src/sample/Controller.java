package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Pane pane;
    @FXML
    private Button button;
    @FXML
    private TextField fieldA;
    @FXML
    private TextField fieldB;
    @FXML
    private TextField fieldC;
    @FXML
    private ComboBox <String> combo;

    private static ScatterChart chart;
    private static NumberAxis xAxis;
    private static NumberAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combo.getItems().addAll("Area chart","Scatter chart", "Line chart");
        combo.getSelectionModel().select(0);
        pane.getChildren().add(EmptyClass.createContent());
    }

    private  String a,b,c;

    public void onClick () {

        a = fieldA.getText();
        b = fieldB.getText();
        c = fieldC.getText();

        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int cc = Integer.parseInt(c);

        System.out.println("f(x) = " + a + "x^2 + " + b + "x + " + c);

        switch (combo.getValue()) {
           case "Area chart":
                pane.getChildren().add(AreaClass.createContent(aa, bb, cc));
                break;
            case "Scatter chart":
                pane.getChildren().add(ScatterClass.createContent(aa, bb, cc));
                break;
            case "Line chart":
                pane.getChildren().add(LineClass.createContent(aa, bb, cc));
                break;
        }
    }


}

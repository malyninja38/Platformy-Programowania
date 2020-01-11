package sample;

import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

class EmptyClass  {

    static Parent createContent() {

        NumberAxis xAxis = new NumberAxis("X-Axis", -15.0d, 15.0d, 1.0d);
        NumberAxis yAxis = new NumberAxis("Y-Axis", -15.0d, 15.0d, 1.0d);

        final XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
        series3.setName(":)");

        ScatterChart chart = new ScatterChart(xAxis, yAxis);
        chart.setPrefSize(763,649);

        chart.getData().add(series3);

        return chart;
    }


}

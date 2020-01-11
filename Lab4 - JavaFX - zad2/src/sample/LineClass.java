package sample;

import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;

 class LineClass  {

    static Parent createContent(int a, int b ,int c) {

       NumberAxis xAxis = new NumberAxis("X-Axis", -15.0d, 15.0d, 1.0d);
       NumberAxis yAxis = new NumberAxis("Y-Axis", -15.0d, 15.0d, 1.0d);

        final XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
        series3.setName("Line Chart");
        for(int i = -15; i < 15; i ++){
            series3.getData().addAll(new XYChart.Data (i,  a*(i*i)+b*i+c));
        }
        LineChart chart = new LineChart(xAxis, yAxis);
        chart.setPrefSize(763,649);

        chart.getData().add(series3);

        return chart;
    }


}

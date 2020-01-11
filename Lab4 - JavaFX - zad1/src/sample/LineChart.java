/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class LineChart extends Application {

    private ScatterChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;



    public Parent createContent() {

        xAxis = new NumberAxis("X-Axis", 0.0d, 15.0d, 1.0d);
        yAxis = new NumberAxis("Y-Axis", -100.0d, 100.0d, 10.0d);

        final Series<Number, Number> series = new Series<>();
        series.setName("f(x) = 0");
        for(int i = 0; i < 20; i ++){ series.getData().addAll(new Data(i, 0.0)); }
        chart = new ScatterChart(xAxis, yAxis);

        final Series<Number, Number> series2 = new Series<>();
        series2.setName("f(x) = x^2 - x + 3");
        for(int i = 0; i < 20; i ++){ series2.getData().addAll(new Data (i, (i *i) - i + 3)); }
        chart = new ScatterChart(xAxis, yAxis);

        final Series<Number, Number> series3 = new Series<>();
        series3.setName("f(x) = -x^2");
        for(int i = 0; i < 20; i ++){ series3.getData().addAll(new Data (i, -1*(i *i))); }
        chart = new ScatterChart(xAxis, yAxis);

        chart.getData().add(series);
        chart.getData().add(series2);
        chart.getData().add(series3);


        return chart;
    }


    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

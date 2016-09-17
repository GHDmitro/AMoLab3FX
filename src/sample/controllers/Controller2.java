package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.interf.Points;
import sample.service.Point;
import sample.service.PointsImpl;

//import java.awt.event.ActionEvent;

//import java.awt.*;

/**
 * Created by macbookair on 08.04.16.
 */
public class Controller2 {
//    private XYChart.Series<Double, Double> series = Controller1.series;
    private Points points = PointsImpl.getInstance();
    private Point point;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnNo;
    @FXML
    private TextField textX1;
    @FXML
    private TextField textX2;
    @FXML
    private TextField textN;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void actionSave(ActionEvent actionEvent) {
        Point x1;
        Point x2;
        Integer n;

        try {
//            x1 = Double.parseDouble(textX1.getText());
//            x2 = Double.parseDouble(textX2.getText());
//            n = Integer.parseInt(textXN.getText());
//            x1 = points.getOriginal().get(Integer.valueOf(textX1.getText()));
//            x2 = points.getOriginal().get(Integer.valueOf(textX2.getText()));
//            points.addPoint(new SimpleDoubleProperty(x1.getX()),
//                    new SimpleDoubleProperty(x2.getX()),
//                    Integer.parseInt(textN.getText()));
            points.addPoint(Integer.valueOf(textX1.getText()), Integer.valueOf(textX2.getText()),
                    Integer.valueOf(textN.getText()));
//            for (int i = 0; i < points.getListNewPoints().size(); i++) {
//                Point p = points.getOriginal().get(i);
//                series.getData().add(new XYChart.Data<Double, Double>(p.getX(), p.getY()));
//            }
//            Controller1.lineChart.getData().add(series);
            actionClose(actionEvent);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

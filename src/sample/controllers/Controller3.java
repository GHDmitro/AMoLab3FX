package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.interf.Points;
import sample.service.PointsImpl;

/**
 * Created by macbookair on 16.04.16.
 */
public class Controller3 {

    private Points points = PointsImpl.getInstance();
    @FXML
    private Button btnNodeCap;
    @FXML
    private TextField fieldNode;

    public void actionNodeCap(ActionEvent actionEvent) {
        String s = fieldNode.getText();
        if (s != null) {
            int k = Integer.parseInt(s);
            if (k >= 0) {
                points.setNode(k - 1);
            }
        }
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}

package sample.controllers;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.interf.Points;
import sample.service.Point;
import sample.service.PointsImpl;

import java.io.IOException;
import java.util.List;

//import java.awt.*;

public class Controller1 {


    public Button plusButton;
    private Rectangle zoomRect ;
    private BooleanBinding disableControls ;
    private ObjectProperty<Point2D> mouseAnchor;
    @FXML
    private Slider zoomSlider;
    private boolean flug = false;
    private Points points = PointsImpl.getInstance();
    @FXML
    private Button btnNode;
    @FXML
    private TableView tableCoordinate;
    @FXML
    private TableColumn<Point, SimpleDoubleProperty> columnX;
    @FXML
    private TableColumn<Point, SimpleDoubleProperty> columnY;
    @FXML
    private TextField fieldStepen;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnMistake;
    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private Button btnDraw;
    @FXML
    private GridPane gridpane;
    Group group;
//    @FXML
//    public void initialize() {
//        zoomRect = new Rectangle();
//        zoomRect.setManaged(false);
//        zoomRect.setFill(Color.LIGHTSEAGREEN.deriveColor(0, 1, 1, 0.5));
//        zoomRect.widthProperty().lessThan(5)
//                .or(zoomRect.heightProperty().lessThan(5));
//        mouseAnchor = new SimpleObjectProperty<>();
//        lineChart.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                mouseAnchor.set(new Point2D(event.getX(), event.getY()));
//                zoomRect.setWidth(0);
//                zoomRect.setHeight(0);
//            }
//        });
//        lineChart.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                double x = event.getX();
//                double y = event.getY();
//                zoomRect.setX(Math.min(x, mouseAnchor.get().getX()));
//                zoomRect.setY(Math.min(y, mouseAnchor.get().getY()));
//                zoomRect.setWidth(Math.abs(x - mouseAnchor.get().getX()));
//                zoomRect.setHeight(Math.abs(y - mouseAnchor.get().getY()));
//            }
//        });
//
//        disableControls = zoomRect.widthProperty().lessThan(5)
//                .or(zoomRect.heightProperty().lessThan(5));


//        ObjectProperty<Point2D> mouseAnchor  = new SimpleObjectProperty<>();
////        Node zoomingNode = lineChart;
//        zoomingNode.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//            }
//        });
//        zoomingNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//            }
//        });

//    }
//
//        zoomSlider.setMin(0.5);
//        zoomSlider.setMax(1.5);
//        zoomSlider.setValue(1);
//        zoomSlider.valueProperty().addListener((o, oldval, newval) -> zoom((Double) newval));
//        group = new Group();
//        group.getChildren().add(lineChart.getClip());


////        XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
//        columnX.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("X"));
//        columnY.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("Y"));
//        tableCoordinate.setItems(points.getListNewPoints());
//
////
////        columnDNE.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("mistakeNE"));
////        columnDN.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("mistakeN"));
////        columnKD.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("mistakeK"));
////        tableDelta.setItems(points.getListNewPoints());
////        columnNE.setCellValueFactory(new PropertyValueFactory<>());
//
//    }

//

    public void actionDraw(ActionEvent actionEvent) {

        System.out.println(lineChart.getData().size());
        if (lineChart.getData().size() == 2){
            lineChart.getData().remove(1);
        }
//        lineChart.getData().set(2,null);
//        initialize();
        if (flug) {

            lineChart.getData().clear();
            columnX.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("X"));
            columnY.setCellValueFactory(new PropertyValueFactory<Point, SimpleDoubleProperty>("Y"));
            tableCoordinate.setItems(points.getListNewPoints());

            XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();

            for (int i = 0; i < points.getOriginal1().size(); i++) {
                Point p = points.getOriginal1().get(i);
                series.getData().add(new XYChart.Data<Number, Number>(p.getX().doubleValue(), p.getY().doubleValue()));
            }
            series.setName("Узловой график");
//            series.getChart()
            lineChart.setCreateSymbols(false);
            lineChart.getData().add(series);
            flug = false;
        }else {


//        }
            XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();

            for (int i = 0; i < points.getAllPoints().size(); i++) {
                Point p = points.getAllPoints().get(i);
                series1.getData().add(new XYChart.Data<Number, Number>(p.getX().doubleValue(), p.getY().doubleValue()));
            }
            series1.setName("Интерполяционный график");
            lineChart.setCreateSymbols(false);
            lineChart.getData().add(series1);
        }

//        });

    }

    public void actionAdd(ActionEvent actionEvent) throws IOException {
        Object source = actionEvent.getSource();
        if (!(source instanceof Button)) {
            return;
        }
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../serv.fxml"));
        stage.setTitle("Работа с точками");
        stage.setMinHeight(235);
        stage.setMinWidth(320);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void addMistake(ActionEvent actionEvent) {
        String stepen = fieldStepen.getText();
        int n = Integer.parseInt(stepen);
        Point selectedPoint = (Point) tableCoordinate.getSelectionModel().getSelectedItem();
        ObservableMap<Point, List<ObservableList<String>>> map = points.getMistakes(selectedPoint, n);
        List<ObservableList<String>> all = map.get(selectedPoint);
//                gridPane.addColumn(0, (Node[]) all.get(0).toArray());
//                gridPane.addColumn(1, (Node[]) all.get(1).toArray());
//                gridPane.addColumn(2, (Node[]) all.get(2).toArray());

//                List<Integer> a = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        ObservableList<String> observableList0 = all.get(0);
//                ObservableList<Integer> observableList0 = FXCollections.observableList(a);
        ObservableList<String> observableList1 = all.get(1);
        ObservableList<String> observableList2 = all.get(2);
//                GridPane gridpane = new GridPane();
        gridpane.add(new Label("Delta N"), 0, 0);
        gridpane.add(new Label("Delta N exact"), 1, 0);
        gridpane.add(new Label("Delta K"), 2, 0);
        gridpane.getChildren().remove(3, gridpane.getChildren().size());

//                lineChart.getData().clear();


        for (int i = 0; i < observableList0.size(); i++) {

//                    Point p = points.getAllPoints().get(i);
//                    if (i < observableList0.size()) {
            Label l = new Label();
            // bind text to content at list position
//                    System.out.println(points.round(observableList0.get(i)));
            l.textProperty().bind(Bindings.valueAt(observableList0, i).asString());
            gridpane.add(l, 0, i + 1);
            l = new Label();
            l.textProperty().bind(Bindings.valueAt(observableList1, i).asString());
            gridpane.add(l, 1, i + 1);
            l = new Label();
            l.textProperty().bind(Bindings.valueAt(observableList2, i).asString());
            gridpane.add(l, 2, i + 1);
//                    }
        }

    }

    public void actionNode(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../nodes.fxml"));
        stage.setTitle("Задание графика по узлам");
        stage.setMinHeight(200);
        stage.setMinWidth(300);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
        flug = true;
    }





//    public void btnDraw(ActionEvent actionEvent) {
//
//    }
//    private void zoom(Rectangle zoomRect, LineChart<Number, Number> chart){
//        Point2D zoomTopLeft = new Point2D(zoomRect.getX(), zoomRect.getY());
//        Point2D zoomBottomRight = new Point2D(zoomRect.getX() + zoomRect.getWidth(), zoomRect.getY() + zoomRect.getHeight());
//        final NumberAxis yAxis = (NumberAxis) chart.getYAxis();
//        Point2D yAxisInScene = yAxis.localToScene(0, 0);
//        final NumberAxis xAxis = (NumberAxis) chart.getXAxis();
//        Point2D xAxisInScene = xAxis.localToScene(0, 0);
//        double xOffset = zoomTopLeft.getX() - yAxisInScene.getX() ;
//        double yOffset = zoomBottomRight.getY() - xAxisInScene.getY();
//        double xAxisScale = xAxis.getScale();
//        double yAxisScale = yAxis.getScale();
//        xAxis.setLowerBound(xAxis.getLowerBound() + xOffset / xAxisScale);
//        xAxis.setUpperBound(xAxis.getLowerBound() + zoomRect.getWidth() / xAxisScale);
//        yAxis.setLowerBound(yAxis.getLowerBound() + yOffset / yAxisScale);
//        yAxis.setUpperBound(yAxis.getLowerBound() - zoomRect.getHeight() / yAxisScale);
//        System.out.println(yAxis.getLowerBound() + " " + yAxis.getUpperBound());
//        zoomRect.setWidth(0);
//        zoomRect.setHeight(0);
//
//
//    }

//    public void actionPlus(ActionEvent actionEvent) {
////        plusButton.disableProperty().bind(disableControls);
//        zoom(zoomRect, lineChart);
//    }
//
//    public void acttionMinus(ActionEvent actionEvent) {
//        final NumberAxis xAxis = (NumberAxis)lineChart.getXAxis();
//        xAxis.setLowerBound(0);
//        xAxis.setUpperBound(1000);
//        final NumberAxis yAxis = (NumberAxis)lineChart.getYAxis();
//        yAxis.setLowerBound(0);
//        yAxis.setUpperBound(1000);
//
//        zoomRect.setWidth(0);
//        zoomRect.setHeight(0);
//    }

//    public void actionMouseDragget(MouseEvent event) {
//        double x = event.getX();
//        double y = event.getY();
//        zoomRect.setX(Math.min(x, mouseAnchor.get().getX()));
//        zoomRect.setY(Math.min(y, mouseAnchor.get().getY()));
//        zoomRect.setWidth(Math.abs(x - mouseAnchor.get().getX()));
//        zoomRect.setHeight(Math.abs(y - mouseAnchor.get().getY()));
//    }
//
//    public void actionMousePresed(MouseEvent event) {
//
//        mouseAnchor.set(new Point2D(event.getX(), event.getY()));
//        zoomRect.setWidth(0);
//        zoomRect.setHeight(0);
//    }
}

















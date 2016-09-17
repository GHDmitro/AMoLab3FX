package sample.interf;

import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import sample.service.Point;

import java.util.List;

/**
 * Created by macbookair on 08.04.16.
 */
public interface Points {

    void setNode(int k);
    void addPoint(int n1, int n2, int capacity);
    ObservableList<Point> getOriginal();
    ObservableList<Point> getOriginal1();
    ObservableList<Point> getListNewPoints();
    ObservableList<Point> getAllPoints();
    ObservableMap<Point, List<ObservableList<String>>> getMistakes(Point point, int n);
    String round(double x);

}

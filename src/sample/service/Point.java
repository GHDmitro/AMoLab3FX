package sample.service;

import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by macbookair on 08.04.16.
 */
public class Point {

    private SimpleDoubleProperty X;
    private SimpleDoubleProperty Y;
//    private SimpleDoubleProperty mistakeN ;
//    private SimpleDoubleProperty mistakeNE;
//    private SimpleDoubleProperty mistakeK ;



    public Point() {
    }

    public Point(double x, double y) {
        X = new SimpleDoubleProperty(x);
        Y = new SimpleDoubleProperty(y);
    }

//    public double getMistakeN() {
//        return mistakeN.get();
//    }
//
//    public SimpleDoubleProperty mistakeNProperty() {
//        return mistakeN;
//    }
//
//    public double getMistakeNE() {
//        return mistakeNE.get();
//    }
//
//    public SimpleDoubleProperty mistakeNEProperty() {
//        return mistakeNE;
//    }
//
//    public double getMistakeK() {
//        return mistakeK.get();
//    }
//
//    public SimpleDoubleProperty mistakeKProperty() {
//        return mistakeK;
//    }
//
//    public void setMistakeN(double mistakeN) {
//        this.mistakeN = new SimpleDoubleProperty(mistakeN);
////        this.mistakeN.set(mistakeN);
//    }
//
//    public void setMistakeNE(double mistakeNE) {
////        this.mistakeNE.set(mistakeNE);
//        this.mistakeNE = new SimpleDoubleProperty(mistakeNE);
//    }
//
//    public void setMistakeK(double mistakeK) {
//        this.mistakeK = new SimpleDoubleProperty(mistakeK);
////        this.mistakeK.set(mistakeK);
//    }

    public Double getX() {
        return X.get();
    }

    public void setX(double x) {
        X.set(x);
    }

    public Double getY() {
        return Y.get();
    }

    public void setY(double y) {
        Y.set(y);
    }
}

package sample.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import sample.interf.Points;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by macbookair on 08.04.16.
 */
public class PointsImpl implements Points {
    private static final double a = 0;
    private static final double b = 2;
    private int k;
    private boolean flug = false;
    private List<Double> listX;
    private List<Double> listY;
    private ObservableList<Point> listNewPoints = FXCollections.observableArrayList();
    //    private ObservableList<Point> listNewPoints2 = FXCollections.observableArrayList();
    private ObservableList<Point> original = FXCollections.observableArrayList();
    private ObservableList<Point> original1 = FXCollections.observableArrayList();
    //    private ObservableList<Point> original2 = FXCollections.observableArrayList();
    private static PointsImpl ourInstance = new PointsImpl();

    public static PointsImpl getInstance() {
        return ourInstance;
    }

    private PointsImpl() {
//        for (int i = 0; i < getListX().size(); i++) {
//            original.add(new Point(listX.get(i),listY.get(i)));
//        }


//        original2.setAll(original);
//        listNewPoints.addAll(original);

    }


    @Override
    public void setNode(int k) {
        this.k = k;
        flug = true;
        listX = getListX();
        listY = getListY(listX);
//        ObservableList<Point> list = FXCollections.observableArrayList();
        original.clear();
        original1.clear();
        listNewPoints.clear();
        for (int i = 0; i < listX.size(); i++) {
            double x123 = listX.get(i);
            double x234 = listY.get(i);
            original.add(new Point(x123, x234));
            if (i < (listX.size()-1)) {
                double x12 = (listX.get(i+1) - x123)/201.0;
                double xq = x123;
                for (int j = 0; j < 200; j++) {
                    xq += x12;
                    double y214 = getY(xq);
                    original1.add(new Point(xq, y214));
                }
            }
            original1.add(new Point(x123, x234));
        }
    }

    @Override //получаем start idx плотность и степерь интерполяции
    public void addPoint(int startIdx, int N, int n) {
        listNewPoints.clear();
        double x1;
        int n1 ;
        if (n <= k && n > 0){
            n1 = n;
        }else n1 = k;
        int index;
        double l;
//        double x1 = original.get(n1).getX();
//        double x2 = original.get(n2).getX();
        for (int i = startIdx; i < (n1 ); i++) {

//            if (i < k - 1) {
//            if (i < (listX.size() - 1)) {
                x1 = original.get(i).getX();
                l = (original.get(i + 1).getX() - x1) / ((double) (N + 1));
//            } else {
//                x1 = original.get(k - 2).getX();
//                l = (original.get(k - 1).getX() - x1) / ((double) (N + 1));
//            }
            index = i;
//            getindex(x1);
            double x = 0;
            Double y = null;
            Point point = null;
            for (int j = 1; j <= N; j++) {
                ++index;
                x = x1 + ((double) j) * l;
//                if (n <= k) {
                    y = getYfromL(x, listX, listY, n1);
//                } else {
//                    y = getYfromL(x, listX, listY, k);
//                }
                if (y != null) {
                    point = new Point(x, y);
//                    point = setMistake(point);
//                    index
                    listNewPoints.add(point);
                }

            }
        }
//        listNewPoints2.setAll(listNewPoints);
//        original2.addAll(listNewPoints2);

        System.out.println(listNewPoints.toString());
    }

    @Override
    public ObservableList<Point> getListNewPoints() {
//        if (flug) {
            ObservableList<Point> list = listNewPoints;
//        list.addAll(listNewPoints);
            list.addAll(original);

            return list.sorted((e1, e2) -> {
                if (e1.getX() < e2.getX()) {
                    return -1;
                } else if (e1.getX() > e2.getX()) {
                    return 1;
                } else return 0;
            });
//        } else return null;

//        if (listNewPoints.size()==0){
//            return null;
//        }else {
//            return listNewPoints.sorted((e1, e2) -> {
//                if (e1.getX() < e2.getX()) {
//                    return -1;
//                } else if (e1.getX() > e2.getX()) {
//                    return 1;
//                } else return 0;
//            });
//        }
    }
    @Override
    public ObservableList<Point> getOriginal(){
        return original;
    }

    @Override
    public ObservableList<Point> getOriginal1() {
        ObservableList<Point> list = original1;
//        return list.sorted((e1, e2) -> {
//            if (e1.getX() < e2.getX()) {
//                return -1;
//            } else if (e1.getX() > e2.getX()) {
//                return 1;
//            } else return 0;
//        });
        return original1;
    }

    @Override
    public ObservableList<Point> getAllPoints() {
//        if (listNewPoints.size() > 0) {
//
//        }
        ObservableList<Point> list = FXCollections.observableArrayList(listNewPoints);
//
//        list.addAll(original);
        return list.sorted((e1, e2) -> {
            if (e1.getX() < e2.getX()) {
                return -1;
            } else if (e1.getX() > e2.getX()) {
                return 1;
            } else return 0;
        });
    }

    //подается точка и степень интерполяции
    @Override
    public ObservableMap<Point, List<ObservableList<String>>> getMistakes(Point point, int n) {
        ObservableMap<Point, List<ObservableList<String>>> mistakesMap = FXCollections.observableHashMap();
        double yF = getY(point.getX());
        int n1;
        if (n <= k){
            n1 = n;
        }else {
            n1 = k;
        }
        Double yL1 = null;
//        = point.getY();
        Double yke = null;
        Double yN = null;
        Double yL2 = null;
        Double yNE = null;
//        double yk = 0;
        ObservableList<String> listYKE = FXCollections.observableArrayList();
        ObservableList<String> listYN = FXCollections.observableArrayList();
        ObservableList<String> listYNE = FXCollections.observableArrayList();
        List<ObservableList<String>> allList = new ArrayList<>();
        if (!original.contains(point)) {
            for (int i = 0; i < n1; i++) {
                try {
                    if (i < (listX.size() - 1)) {
                        yL1 = getYfromL(point.getX(), listX, listY, i);
                        yL2 = getYfromL(point.getX(), listX, listY, i + 1);
                    } else {
                        yL1 = getYfromL(point.getX(), listX, listY, listX.size() - 2);
                        yL2 = getYfromL(point.getX(), listX, listY, listX.size() - 1);
                    }
                    if (yL1 != null && yL2 != null) {
//                    0.00000000000000000098;
//                    DecimalFormat df = new DecimalFormat()
                        yNE = yL1 - yF;  //похибка
                        yN = yL1 - yL2;
                        listYNE.add(round(yNE.doubleValue()));
                        listYN.add(round(yN.doubleValue()));
                        yke = (1.0 - (yNE / yN));  ////??????????????
                        listYKE.add(round(yke));
                    } else {
                        System.out.println("Error");
                    }
                } catch (NullPointerException | ArithmeticException e) {
                    e.printStackTrace();
                }
//            point.setMistakeNE(yke);
//
//            try {
//                y1 = getYfromL(point.getX(), listX, listY, n - 1);
//                y2 = getYfromL(point.getX(), listX, listY, n);
//                if (y1 != null && y2 != null) {
//                    yN = y1 - y2;
//                    point.setMistakeN(yN);
//
//                    point.setMistakeK(1.0 - (yke / yN));
//                }
//
//            } catch (NullPointerException | ArithmeticException e) {
//                e.printStackTrace();
//            }
            }
        }
        allList.add(listYN);
        allList.add(listYNE);
        allList.add(listYKE);
        mistakesMap.put(point, allList);
        return mistakesMap;
    }

//    private int getindex(double x){
//        for (int i = 0; i < listNewPoints.size(); i++) {
//            if (listNewPoints.get(i).getX()== x){
//                return i;
//            }
//        }
//        return -1;
//    }

    private double getY(double x) {
        return (1.0 / (0.5 + Math.pow(x, 2.0)));
    }

    private List<Double> getListX() {
        double h;
        List<Double> list = null;
        try {
            h = (b - a) / k;
            list = new LinkedList<>();
            for (int j = 0; j < (k + 1); j++) {
                list.add(a + h * (double) j);
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<Double> getListY(List<Double> listX) {
        List<Double> list = new LinkedList<>();
        for (int i = 0; i < (k + 1); i++) {
            list.add(getY(listX.get(i)));
        }
        return list;
    }

    private Double getYfromL(double x, List<Double> listX, List<Double> listY, int n) {
        double yfromL = 0;
        double p = 1.0;
        int n1;
        if (n <= k && n>0){
            n1 = n;
        }else n1 = k;
        for (int i = 0; (i <= n1); i++) {
            for (int j = 0; (j <= n1); j++) {
                if (i != j) {
                    try {
                        double xs = listX.get(j);
                        if (x == xs) {
                            return new Double(0);
                        }
                        p *= (x - xs) / (listX.get(i) - listX.get(j));
                    } catch (ArithmeticException | NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
            yfromL += p * listY.get(i);
            p = 1.0;
        }
        return yfromL;
    }

    public String round(double x) {

        String d = String.valueOf(x);
        String as = null;
        String g;
        if (d.contains("E")) {
            as = d.substring(d.indexOf("E"));
            d = d.substring(0, 6) + as;
        } else if (d.substring(d.indexOf(".") + 1).length() > 3) {
            if (d.substring(0, 1).equalsIgnoreCase("-")) {
                d = d.substring(0, 8);
            }else {
                d = d.substring(0, 7);
            }
        }

        return d;
    }

}
















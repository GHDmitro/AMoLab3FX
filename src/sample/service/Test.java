package sample.service;

import sample.interf.Points;

/**
 * Created by macbookair on 08.04.16.
 */
public class Test {
    public static void main(String[] args) {
        Points points = PointsImpl.getInstance();
        double f = 34.294857348E-5;
//        f = points.round(f);

        System.out.println((points.round(f)));

//        f = points.round(f);
        System.out.println(f);
    }

    static void add(int i) {
        i += 2;
    }
//    public static void main(String[] args) {
//        Points points = PointsImpl.getInstance();
//        ObservableList<Point> list = points.getListNewPoints();
//        list.forEach((e) -> {
////            System.out.print("X = "+e.getX()+"; Y = "+e.getY() +";    ");
//            System.out.print("Y = "+e.getY() +";    ");
//        });
//        System.out.println();
//
//        points.addPoint(list.get(2).getX(), list.get(3).getX(), 3);
//
//        System.out.println("----------------------------------");
//
//        list.forEach((e) -> {
////            System.out.print("X = "+e.getX()+"; Y = "+e.getY() +";    ");
//            System.out.print("Y = "+e.getY() +";    ");
//        });
//    }
}

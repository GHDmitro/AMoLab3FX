package sample.jkwvn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by macbookair on 07.04.16.
 */
public class Algorithm {
    private static final double a = 0;
    private static final double b = 2;
    private static final int n = 10;
//    public static void main(String[] args) {
//        List<Double> lX = getListX();
//        List<Double> lY = getListY(lX);
//        List<Double> lL = new LinkedList<>();
//        double xPriv = 0;
//        for (int i = 0; i < (lX.size() - 1); i++) {
//            try {
//                xPriv = (lX.get(i) + lX.get(i + 1)) / 2.0;
//                lL.add(getYfromL(xPriv, lX, lY));
//            }catch (NullPointerException e){
//                e.printStackTrace();
//            }
//        }
//        System.out.println(lY.toString() +"\n");
//        System.out.println(lL.toString());
//    }

//    public Point getPoint

    private List<Double> getListX(){
        double h;
        List<Double> list = null;
        try {
            h = (b - a) / 10.0;
            list = new LinkedList<>();
        for (int j = 0; j < (n + 1); j++) {
            list.add(a + h * (double) j);
        }
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        return list;
    }
    private List<Double> getListY(List listX){
        List<Double> list = new LinkedList<>();
        for (int i = 0; i < (n + 1); i++) {
            list.add(1.0/(0.5 + Math.pow((double) listX.get(i), 2.0)));
        }
        return list;
    }
    private double getYfromL(double x, List<Double> listX, List<Double> listY){
        double yfromL = 0;
        double p = 1;
        for (int i = 0; i < (n + 1); i++) {

            for (int j = 0; j < (n + 1); j++) {
                if (i == j){
                    continue;
                }
                try {
                    double xs = listX.get(j);
                    if (xs == x){
                        return listY.get(j);
                    }
                    p *= (x - xs) / (listX.get(i) - listX.get(j));
                }catch (ArithmeticException | NullPointerException e ){
                    e.printStackTrace();
                }
            }
            yfromL += p * listY.get(i);
            p = 1;

        }
        return yfromL;
    }

//    private static double getP(int i)
}


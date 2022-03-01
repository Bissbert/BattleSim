package ch.bissbert.battleSim.util;

import ch.bissbert.battleSim.data.unit.Unit;

public class MovementUtil {
    private MovementUtil() {
    }

    public static double distanceBetween(double x1, double y1, double x2, double y2) {
        return Math.sqrt(
                Math.pow(Math.max(x1, x2) - Math.min(x1, x2), 2)
                        +
                        Math.pow(Math.max(y1, y2) - Math.min(y1, y2), 2)
        );
    }

    public static double distanceBetween(Unit unit1, Unit unit2){
        return distanceBetween(unit1.getX(), unit1.getY(), unit2.getX(), unit2.getY());
    }

    public static double[] pointBetween(double[] v1, double[] v2, double distance) {

        //distance between 2 points

        double totalDistToPoint = Math.sqrt(
                Math.pow(Math.max(v1[0], v2[0]) - Math.min(v1[0], v2[0]), 2)
                        +
                        Math.pow(Math.max(v1[1], v2[1]) - Math.min(v1[1], v2[1]), 2)
        );

        System.out.println("Distance to point" + totalDistToPoint);

        //calculate the coordinates for the points at distance distance

        double x3 = v1[0] + (distance / totalDistToPoint) * (v2[0] - v1[0]);
        double y3 = v1[1] + (distance / totalDistToPoint) * (v2[1] - v1[1]);

        //saving values to

        System.out.println("The new coordinates: (" + x3 + "," + y3 + ")");
        final double[] v3 = new double[2];

        v3[0] = x3;
        v3[1] = y3;

        return v3;
    }

    public static double[] pointBetweenV2(double[] v1, double[] v2, double distance) {
        double distCounter = Math.pow(Math.max(v1[0], v2[0]) - Math.min(v1[0], v2[0]), 2);

        for (int i = 1; i < v1.length; i++) {
            distCounter = Math.sqrt(Math.pow(Math.max(v1[i], v2[i]) - Math.min(v1[i], v2[i]), 2) + distCounter);
        }

        double[] point = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            point[i] = v1[i] + (distance / distCounter) * (v2[i] - v1[i]);
        }

        return point;
    }
}

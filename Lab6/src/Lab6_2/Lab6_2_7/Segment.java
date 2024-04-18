package Lab6_2.Lab6_2_7;

import java.util.ArrayList;
import java.util.List;

public class Segment {

    double x1, x2, y1, y2;

    public Segment(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public List<double[]> getIntersectionPoints(Segment other) {
        List<double[]> intersections = new ArrayList<>();

        double x1 = this.x1, y1 = this.y1;
        double x2 = this.x2, y2 = this.y2;
        double x3 = other.x1, y3 = other.y1;
        double x4 = other.x2, y4 = other.y2;

        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if (den != 0) {
            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
            double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;

            if (t >= 0 && t <= 1 && u >= 0 && u <= 1) {
                double intersectX = x1 + t * (x2 - x1);
                double intersectY = y1 + t * (y2 - y1);
                intersections.add(new double[]{intersectX, intersectY});
            } else {
                System.out.println("The segments do not intersect");
            }
        } else {
            System.out.println("The segments are parallel");
        }

        return intersections;
    }
}
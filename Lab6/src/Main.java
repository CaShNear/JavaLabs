import Lab6_2.Lab6_2_6.Dot;
import Lab6_2.Lab6_2_6.Line;
import Lab6_2.Lab6_2_7.Segment;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // Вариант 1 задание 6

        ArrayList<Integer> pos_neg = new ArrayList<Integer>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Lab6_1/Lab6_1_6.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                pos_neg.add(Integer.valueOf(line));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        pos_neg.sort(Collections.reverseOrder());

        for (Integer sortedInt : pos_neg) {
            System.out.println(sortedInt);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 1 задание 7

        ArrayList<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Lab6_1/Lab6_1_7.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Collections.sort(lines);

        for (String sortedLine : lines) {
            System.out.println(sortedLine);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 6

        List<Dot> dots = new ArrayList<>();
        dots.add(new Dot(1, 2));
        dots.add(new Dot(2, 4));
        dots.add(new Dot(3, 6));
        dots.add(new Dot(1, 3));
        dots.add(new Dot(2, 2));

        HashMap<Line, Integer> intersectionLinePoint = new HashMap<>();

        for (int i = 0; i < dots.size(); i++){
            Dot dot1 = dots.get(i);
            for (int j = i + 1; j < dots.size(); j++){
                Dot dot2 = dots.get(j);
                Line lineCompare = new Line(dot1, dot2);
                intersectionLinePoint.put(lineCompare, intersectionLinePoint.getOrDefault(lineCompare, 0) + 1);
            }
        }

        FileWriter writer = new FileWriter("lines.txt", true);

        for (Map.Entry<Line, Integer> entry : intersectionLinePoint.entrySet()){
            Line lineOut = entry.getKey();
            int countDots  = (int) (1 + Math.sqrt(1 + 8 * entry.getValue())) / 2;
            intersectionLinePoint.put(lineOut, countDots);
            String writerLine = String.format("Line equation: ( %f ) * x + ( %f ) * y + ( %f ) = 0; Number of crossed points: %d%n",
            lineOut.getA(), lineOut.getB(), lineOut.getC(), countDots);
            writer.write(writerLine);
            System.out.printf(writerLine);
        }
        writer.close();

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 7

        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(2, 4, 3, 5));
        segments.add(new Segment(1, 4, 4, 1));
        segments.add(new Segment(4, 4, 1, 5));

        TreeMap<Double, double[]> intersectionPointsWithMinAbscissa = new TreeMap<>();

        for (int i = 0; i < segments.size(); i++) {
            Segment s1 = segments.get(i);
            for (int j = i + 1; j < segments.size(); j++) {
                Segment s2 = segments.get(j);
                List<double[]> intersectionPoints = s1.getIntersectionPoints(s2);
                for (double[] point : intersectionPoints) {
                    double x = point[0];
                    double y = point[1];
                    intersectionPointsWithMinAbscissa.put(x, new double[]{x, y});
                    System.out.println("Intersection point: (" + x + ", " + y + ")");
                }
            }
        }

        if (!intersectionPointsWithMinAbscissa.isEmpty()) {
            double[] minPoint = intersectionPointsWithMinAbscissa.firstEntry().getValue();
            System.out.println("Intersection point with minimum abscissa: (" + minPoint[0] + ", " + minPoint[1] + ")");
        } else {
            System.out.println("No intersection points");
        }

    }

}
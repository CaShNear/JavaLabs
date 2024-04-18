import Lab5_1.ContinuedFractionNew;
import Lab5_1.FractionNew;
import Lab5_2.HouseNew;
import Lab5_2.PhoneNew;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Вариант 1 задание 6

        System.out.print("Enter x for first continued fraction: ");
        int x = Integer.parseInt(in.nextLine());
        System.out.print("Enter n for first continued fraction: ");
        int n = Integer.parseInt(in.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("Enter %d element of array for first continued fraction: ", i+1));
            a[i] = Integer.parseInt(in.nextLine());
        }
        ContinuedFractionNew firstFraction = new ContinuedFractionNew(x, n, a);
        System.out.println("Value of first continued fraction: " + firstFraction.getResult());
        System.out.print("Enter x for second continued fraction: ");
        x = Integer.parseInt(in.nextLine());
        System.out.print("Enter n for second continued fraction: ");
        n = Integer.parseInt(in.nextLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("Enter %d element of array for second continued fraction: ", i+1));
            a[i] = Integer.parseInt(in.nextLine());
        }
        ContinuedFractionNew secondFraction = new ContinuedFractionNew(x, n, a);
        System.out.println("Value of second continued fraction: " + secondFraction.getResult());
        System.out.println("Addition of two continued fractions: " + ContinuedFractionNew.add(firstFraction, secondFraction).getResult());
        System.out.println("Subtraction of two continued fractions: " + ContinuedFractionNew.subtract(firstFraction, secondFraction).getResult());
        System.out.println("Multiplication of two continued fractions: " + ContinuedFractionNew.multiply(firstFraction, secondFraction).getResult());
        System.out.println("Division of two continued fractions: " + ContinuedFractionNew.divide(firstFraction, secondFraction).getResult());

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 1 задание 7

        System.out.print("Enter length of array: ");
        n = Integer.parseInt(in.nextLine());
        FractionNew[] fractionArray = new FractionNew[n];
        for (int i = 0; i < n; i++){
            System.out.print("Enter " + i+1 + " numerator: ");
            int numerator = Integer.parseInt(in.nextLine());
            System.out.print("Enter " + i+1 + " divider: ");
            int divider = Integer.parseInt(in.nextLine());
            fractionArray[i] = FractionNew.correction(numerator, divider);
        }

        System.out.print("Original array of fraction: ");
        for (int i = 0; i < n; i++){
            System.out.print(fractionArray[i].getNumerator() + "/" + fractionArray[i].getDivider() + " ");
        }
        System.out.println();

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 6

        System.out.print("Enter count of houses: ");
        n = Integer.parseInt(in.nextLine());
        HouseNew[] houseList = new HouseNew[n];
        for (int i = 0; i < n; i++){
            System.out.print(String.format("Enter number of %d house: ", i+1));
            int houseNumber = Integer.parseInt(in.nextLine());
            System.out.print(String.format("Enter square of %d house: ", i+1));
            double square = Double.parseDouble(in.nextLine());
            System.out.print(String.format("Enter floor of %d house: ", i+1));
            int floor = Integer.parseInt(in.nextLine());
            System.out.print(String.format("Enter count of rooms of %d house: ", i+1));
            int roomsCount = Integer.parseInt(in.nextLine());
            houseList[i] = new HouseNew(i+1, houseNumber, square, floor, roomsCount);
        }
        System.out.println("Original list of houses:");
        for (int i = 0; i < n; i++){
            System.out.println(houseList[i].toString());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 7

        System.out.print("Enter count of phones: ");
        n = Integer.parseInt(in.nextLine());
        PhoneNew[] phoneBook = new PhoneNew[n];
        for (int i = 0; i < n; i++){
            System.out.print(String.format("Enter surname of %d person: ", i+1));
            String surname = in.nextLine();
            System.out.print(String.format("Enter name of %d person: ", i+1));
            String name = in.nextLine();
            System.out.print(String.format("Enter patronymic of %d person: ", i+1));
            String patronymic = in.nextLine();
            System.out.print(String.format("Enter city call time of %d person in seconds: ", i+1));
            int cityCallTimeInSeconds = Integer.parseInt(in.nextLine());
            System.out.print(String.format("Enter intercity call time of %d person in seconds: ", i+1));
            int intercityCallTimeInSeconds = Integer.parseInt(in.nextLine());
            phoneBook[i] = new PhoneNew(i+1, surname, name, patronymic, cityCallTimeInSeconds, intercityCallTimeInSeconds);
        }
        System.out.println("Original phonebook:");
        for (int i = 0; i < n; i++){
            System.out.println(phoneBook[i].toString());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 3 задание 6

        String inputFile = "files/Akhmatova_input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.toLowerCase().replaceAll("[^а-яА-Я ]", "").split("\\s+");
                HashMap<String, Integer> wordCount = new HashMap<>();
                for (String word : lineSplit){
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
                List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
                list.sort(Map.Entry.comparingByValue());

                System.out.println(i + " line:");
                for (Map.Entry<String, Integer> entry : list) {
                    System.out.println(entry.getKey() + ", Count: " + entry.getValue());
                }
                i++;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 3 задание 7

        System.out.println("Reading file Zabolotsky_input.txt");

        inputFile = "files/Zabolotsky_input.txt";
        String outputFile = "files/Zabolotsky_output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                String totalLine = "";
                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalLine = totalLine.concat(Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ");
                    }
                }
                bw.write(totalLine);
                bw.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Outputting data in file Zabolotsky_output.txt");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 4 задание 6

        System.out.println("Reading file input.txt");

        inputFile = "files/input.txt";
        outputFile = "files/output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split("\\s+");
                long amount = Arrays.stream(lineSplit)
                        .filter(word -> word.matches("\\b\\w{3,5}\\b"))
                        .count();
                amount -= amount % 2;
                List<String> filteredWords = new ArrayList<>();
                for (String word : lineSplit){
                    if (word.length() >= 3 && word.length() <= 5 && amount != 0) {
                        amount--;
                    }
                    else{
                        filteredWords.add(word);
                    }
                }
                bw.write(String.join(" ", filteredWords));
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Outputting data in file output.txt");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 4 задание 7

        System.out.println("Reading file input.java");

        inputFile = "files/input.java";
        outputFile = "files/output.java";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim().replaceAll("\\s+", " ");
                bw.write(trimmedLine);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Outputting data in file output.java");

    }

}
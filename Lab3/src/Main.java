import Lab3_1.ContinuedFraction;
import Lab3_1.Fraction;
import Lab3_2.House;
import Lab3_2.Phone;
import Lab3_3.Variant_6.Rose;
import Lab3_3.Variant_7.Tree;
import Lab3_4.Variant_6.DesignDepartment;
import Lab3_4.Variant_7.TelephoneStation;

import java.util.Scanner;

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
        ContinuedFraction firstFraction = new ContinuedFraction(x, n, a);
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
        ContinuedFraction secondFraction = new ContinuedFraction(x, n, a);
        System.out.println("Value of second continued fraction: " + secondFraction.getResult());
        System.out.println("Addition of two continued fractions: " + ContinuedFraction.add(firstFraction, secondFraction).getResult());
        System.out.println("Subtraction of two continued fractions: " + ContinuedFraction.subtract(firstFraction, secondFraction).getResult());
        System.out.println("Multiplication of two continued fractions: " + ContinuedFraction.multiply(firstFraction, secondFraction).getResult());
        System.out.println("Division of two continued fractions: " + ContinuedFraction.divide(firstFraction, secondFraction).getResult());

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 1 задание 7

        System.out.print("Enter length of array: ");
        n = Integer.parseInt(in.nextLine());
        Fraction[] fractionArray = new Fraction[n];
        for (int i = 0; i < n; i++){
            System.out.print("Enter " + i+1 + " numerator: ");
            int numerator = Integer.parseInt(in.nextLine());
            System.out.print("Enter " + i+1 + " divider: ");
            int divider = Integer.parseInt(in.nextLine());
            fractionArray[i] = Fraction.correction(numerator, divider);
        }

        System.out.print("Original array of fraction: ");
        for (int i = 0; i < n; i++){
            System.out.print(fractionArray[i].getNumerator() + "/" + fractionArray[i].getDivider() + " ");
        }
        System.out.println();

        System.out.print("Changed array of fraction: ");
        Fraction.method(fractionArray);
        for (int i = 0; i < n; i++){
            System.out.print(fractionArray[i].getNumerator() + "/" + fractionArray[i].getDivider() + " ");
        }
        System.out.println();

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 6

        System.out.print("Enter count of houses: ");
        n = Integer.parseInt(in.nextLine());
        House[] houseList = new House[n];
        for (int i = 0; i < n; i++){
            System.out.print(String.format("Enter number of %d house: ", i+1));
            int houseNumber = Integer.parseInt(in.nextLine());
            System.out.print(String.format("Enter square of %d house: ", i+1));
            double square = Double.parseDouble(in.nextLine());
            System.out.print(String.format("Enter floor of %d house: ", i+1));
            int floor = Integer.parseInt(in.nextLine());
            System.out.print(String.format("Enter count of rooms of %d house: ", i+1));
            int roomsCount = Integer.parseInt(in.nextLine());
            houseList[i] = new House(i+1, houseNumber, square, floor, roomsCount);
        }
        System.out.println("Original list of houses:");
        for (int i = 0; i < n; i++){
            System.out.println(houseList[i].toString());
        }

        System.out.print("Enter count of rooms, that should be searched by: ");
        int count = Integer.parseInt(in.nextLine());
        System.out.println(String.format("Houses, that have %d rooms:", count));
        for (int i = 0; i < n; i++){
            if (houseList[i].getRoomsCount() == count){
                System.out.println(houseList[i].toString());
            }
        }

        System.out.print("Enter bottom floor limit, that should be searched by: ");
        int bottomFloorLimit = Integer.parseInt(in.nextLine());
        System.out.print("Enter upper floor limit, that should be searched by: ");
        int upperFloorLimit = Integer.parseInt(in.nextLine());
        System.out.println(String.format("Houses, that have %d rooms and are below %d and %d floor:",
                count, bottomFloorLimit, upperFloorLimit));
        for (int i = 0; i < n; i++){
            if ((houseList[i].getRoomsCount() == count) && (houseList[i].getFloor() >= bottomFloorLimit) &&
                    (houseList[i].getFloor() <= upperFloorLimit)){
                System.out.println(houseList[i].toString());
            }
        }

        System.out.print("Enter square, that should be searched by: ");
        double squareCompare = Double.parseDouble(in.nextLine());
        System.out.println(String.format("Houses, which square is more than %f:", squareCompare));
        for (int i = 0; i < n; i++){
            if (houseList[i].getSquare() > squareCompare){
                System.out.println(houseList[i].toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 7

        System.out.print("Enter count of phones: ");
        n = Integer.parseInt(in.nextLine());
        Phone[] phoneBook = new Phone[n];
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
            phoneBook[i] = new Phone(i+1, surname, name, patronymic, cityCallTimeInSeconds, intercityCallTimeInSeconds);
        }
        System.out.println("Original phonebook:");
        for (int i = 0; i < n; i++){
            System.out.println(phoneBook[i].toString());
        }

        System.out.print("Enter time in seconds to compare with city call times: ");
        int time = Integer.parseInt(in.nextLine());
        System.out.println("People, who call in city over given time:");
        for (int i = 0; i < n; i++){
            if (phoneBook[i].getCityCallTimeInSeconds() > time){
                System.out.println(phoneBook[i].toString());
            }
        }

        System.out.println("People, who use intercity calls:");
        for (int i = 0; i < n; i++){
            if (phoneBook[i].getCityCallTimeInSeconds() != 0){
                System.out.println(phoneBook[i].toString());
            }
        }

        System.out.println("Sorted phonebook:");
        Phone.sort(phoneBook, 0, n-1);
        for (int i = 0; i < n; i++){
            System.out.println(phoneBook[i].toString());
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 3 задание 6

        Rose rose = new Rose();
        System.out.println("Rose bloomed");
        System.out.println(rose);
        System.out.print("Color of rose: ");
        System.out.println(rose.getColor());
        System.out.println("Rose withered");
        rose.wither();
        System.out.println(rose);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 3 задание 7

        Tree tree = new Tree();
        System.out.println("Tree bloomed");
        System.out.println(tree);
        System.out.println("Leaves of tree are getting yellow");
        tree.turnYellow();
        System.out.println(tree);
        System.out.println("Leaves of tree are covered with frost");
        tree.coverWithFrost();
        System.out.println(tree);
        System.out.println("Tree withered");
        tree.wither();
        System.out.println(tree);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 4 задание 6

        System.out.print("Welcome to design department. ");
        DesignDepartment designDepartment = new DesignDepartment();
        int choice;
        do {
            System.out.println("""
                What do you want to do?
                1 - See all projects
                2 - Add project
                3 - Invoice for project
                4 - Make constructor team
                5 - Exit""");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            switch (choice){
                case 1: System.out.println(designDepartment); break;
                case 2: designDepartment.addProject(); break;
                case 3: designDepartment.showInvoice(); break;
                case 4: designDepartment.setProjectTeam(); break;
                case 5: System.out.println("Thanks for using our program. See you later."); break;
                default: System.out.println("Wrong choice input. Try again.");
            }
        } while (choice != 5);

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 4 задание 7

        System.out.print("Welcome to telephone station. ");
        TelephoneStation telephoneStation = new TelephoneStation();
        do {
            System.out.println("""
                What do you want to do?
                1 - See all customers
                2 - Add customer
                3 - Change number of customer
                4 - Change services of customer
                5 - Repay the payment made by the client
                6 - Make payments for services to all clients
                7 - Check balance of client
                8 - Exit""");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            switch (choice){
                case 1: System.out.println(telephoneStation); break;
                case 2: telephoneStation.addCustomer(); break;
                case 3: telephoneStation.changeNumber(); break;
                case 4: telephoneStation.changeServices(); break;
                case 5: telephoneStation.repayPayment(); break;
                case 6: telephoneStation.payForServices(); break;
                case 7: telephoneStation.checkBalance(); break;
                case 8: System.out.println("Thanks for using our program. See you later."); break;
                default: System.out.println("Wrong choice input. Try again.");
            }
        } while (choice != 8);

    }
}
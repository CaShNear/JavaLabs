import Laba2_1.Letters;
import Laba2_2.Matrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Вариант 1 задание 6
        Letters words = new Letters();
        words.Initialize();
        words.LetterRise();

        // Вариант 1 задание 7
        words.Initialize();
        words.LetterOnce();

        // Вариант 2 задание 6
        Matrix matrix = new Matrix();
        matrix.Initialize();
        System.out.println("Original matrix:");
        matrix.Output();
        System.out.println("M-norm of matrix: " + matrix.M_Norm());
        System.out.println("L-norm of matrix: " + matrix.L_Norm());
        System.out.println("K-norm of matrix: " + matrix.K_Norm());

        // Вариант 2 задание 7
        System.out.print("Enter angle: ");
        Scanner in = new Scanner(System.in);
        int choice = Integer.parseInt(in.nextLine());
        if (choice % 90 != 0){
            System.out.println("Wrong angle");
        }
        else{
            matrix.Choice(choice / 90);
            System.out.println("Changed matrix:");
            matrix.Output();
        }

        // Вывод данных о разработчике
        Developer_Data.Info();
    }
}
package Lab1_2;

import java.util.Scanner;

public class Three_Digit_Num {

    private int dim;
    private long[] arr;

    public void Initialize(){
        System.out.print("Enter dimension of array: ");
        Scanner in = new Scanner(System.in);
        dim = Integer.parseInt(in.nextLine());
        arr = new long[dim];
        for (int i = 0; i < dim; i++){
            System.out.print("Enter " + (i+1) + " element of array: ");
            arr[i] = Long.parseLong(in.nextLine());
        }
    }

    public void Output(){
        boolean check = true;
        for (int i = 0; i < dim; i++){
            if ((arr[i] < 1000) && (arr[i] > 99)){
                if ((arr[i] / 100 != arr[i] / 10 % 10) && (arr[i] % 10 != arr[i] / 100) && (arr[i] % 10 != arr[i] / 10 % 10)){
                    check = false;
                    System.out.println(arr[i]);
                }
            }
        }
        if (check){
            System.out.println("There is no such numbers.");
        }
    }
}

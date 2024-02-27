package Lab1_2;

import java.util.Scanner;

public class LCM_GCD {

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
        long gcd_result = arr[0];
        long lcm_result = arr[0];
        for (int i = 1; i < dim; i++){
            gcd_result = gcd(gcd_result, arr[i]);
            lcm_result = lcm(lcm_result, arr[i]);
        }
        System.out.println("Greatest common divisor of numbers is " + gcd_result);
        System.out.println("Least common multiple of numbers is " + lcm_result);
    }

    private long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }

    private long lcm(long a,long b){
        return a / gcd(a,b) * b;
    }
}

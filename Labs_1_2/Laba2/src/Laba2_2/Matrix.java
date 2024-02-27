package Laba2_2;

import java.util.Scanner;

public class Matrix {

    private int dim;
    private int [][] arr;

    public void Initialize(){

        System.out.print("Enter dimension of array: ");
        Scanner in = new Scanner(System.in);
        dim = Integer.parseInt(in.nextLine());
        arr = new int[dim][dim];
        for (int i = 0; i < dim; i++){
            for (int j = 0; j < dim; j++) {
                arr[i][j] = (int) (Math.random() * dim * 2 - dim);
            }
        }

    }

    public void Output(){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void Choice(int angle){
        switch (angle % 4){
            case 3:
                Rotate();
            case 2:
                Rotate();
            case 1:
                Rotate();
        }
    }

    private void Rotate(){
        int temp;
        for (int i = 0; i < dim/2; i++){
            for (int j = i; j < dim - i - 1; j++){
                temp = arr[i][j];
                arr[i][j] = arr[j][dim-i-1];
                arr[j][dim-i-1] = arr[dim-i-1][dim-j-1];
                arr[dim-i-1][dim-j-1] = arr[dim-j-1][i];
                arr[dim-j-1][i] = temp;
            }
        }
    }

    public int M_Norm(){
        int max = 0;
        for (int i = 0; i < dim; i++) {
            int sum = 0;
            for (int j = 0; j < dim; j++) {
                sum += Math.abs(arr[i][j]);
            }
            if (max < sum){
                max = sum;
            }
        }
        return max;
    }

    public int L_Norm(){
        int max = 0;
        for (int j = 0; j < dim; j++) {
            int sum = 0;
            for (int i = 0; i < dim; i++) {
                sum += Math.abs(arr[i][j]);
            }
            if (max < sum){
                max = sum;
            }
        }
        return max;
    }

    public double K_Norm(){
        int sum = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                sum += arr[i][j]*arr[i][j];
            }
        }
        return Math.sqrt(sum);
    }

}

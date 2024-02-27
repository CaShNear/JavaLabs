package Laba2_1;

import java.util.Scanner;

public class Letters {

    private String[] arr;

    public void Initialize (){
        System.out.print("Enter words: ");
        Scanner in = new Scanner(System.in);
        arr = in.nextLine().split("[,\\s]+");
    }

    public void LetterRise(){
        boolean check = true;
        String result = null;
        for (int i = 0; (i < arr.length) && check; i++){
            result = arr[i];
            check = false;
            boolean check_rise = true;
            for (int j = 0; (j < arr[i].length()-1) && check_rise; j++){
                if (arr[i].charAt(j) >= arr[i].charAt(j+1)){
                    check_rise = false;
                    check = true;
                    result = "No such word";
                }
            }
        }
        System.out.println(result);
    }

    public void LetterOnce(){
        boolean check = true;
        String result = null;
        for (int i = 0; (i < arr.length) && check; i++){
            result = arr[i];
            check = false;
            boolean check_once = true;
            for (int j = 0; (j < arr[i].length()-1) && check_once; j++){
                if (arr[i].indexOf(arr[i].charAt(j)) != arr[i].lastIndexOf(arr[i].charAt(j))){
                    check_once = false;
                    check = true;
                    result = "No such word";
                }
            }
        }
        System.out.println(result);
    }
}

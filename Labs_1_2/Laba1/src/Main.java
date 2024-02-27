import Lab1_1.Developer_Data;
import Lab1_1.Hello;
import Lab1_2.Three_Digit_Num;
import Lab1_2.LCM_GCD;

public class Main {

    public static void main(String[] args) {

        // 1 вариант 6 задание
        Hello hello = new Hello();
        hello.Input();
        hello.Output();

        // 1 вариант 7 задание
        Developer_Data.Info();

        // 2 вариант 6 задание
        Three_Digit_Num task = new Three_Digit_Num();
        task.Initialize();
        task.Output();

        // 2 вариант 7 задание
        LCM_GCD result = new LCM_GCD();
        result.Initialize();
        result.Output();
    }
}
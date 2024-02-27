package Lab1_1;

import java.util.Scanner;

public class Hello {

    private String name;

    public void Input() {
        System.out.println("How can I call you?");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();
    }

    public void Output() {
        System.out.println("Hello, " + name + "!");
    }
}

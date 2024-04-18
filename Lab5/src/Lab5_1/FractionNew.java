package Lab5_1;

import Lab5_2.InvalidInputException;

public class FractionNew {

    private int numerator;
    private int divider;

    public FractionNew(){
        try {
            setNumerator(1);
            setDivider(1);
        }
        catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public FractionNew(int numerator, int divider){
        try {
            setNumerator(numerator);
            setDivider(divider);
        }
        catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDivider(int divider) throws InvalidInputException {
        if (divider == 0){
            throw new InvalidInputException("Divider cannot be zero");
        }
        this.divider = divider;
    }

    public int getDivider() {
        return divider;
    }

    public static FractionNew add(FractionNew fractionFirst, FractionNew fractionSecond){
        try {
            int numerator = fractionFirst.getNumerator() * fractionSecond.getDivider() + fractionSecond.getNumerator() * fractionFirst.getDivider();
            int divider = fractionFirst.getDivider() * fractionSecond.getDivider();
            return correction(numerator, divider);
        } catch (ArithmeticException e) {
            System.out.println("Error during addition: " + e.getMessage());
            return null;
        }
    }

    public static FractionNew subtract(FractionNew fractionFirst, FractionNew fractionSecond){
        try {
            int numerator = fractionFirst.getNumerator() * fractionSecond.getDivider() - fractionSecond.getNumerator() * fractionFirst.getDivider();
            int divider = fractionFirst.getDivider() * fractionSecond.getDivider();
            return correction(numerator, divider);
        } catch (ArithmeticException e) {
            System.out.println("Error during subtraction: " + e.getMessage());
            return null;
        }

    }

    public static FractionNew multiply(FractionNew fractionFirst, FractionNew fractionSecond){
        try {
            int numerator = fractionFirst.getNumerator() * fractionSecond.getNumerator();
            int divider = fractionFirst.getDivider() * fractionSecond.getDivider();
            return correction(numerator, divider);
        } catch (ArithmeticException e) {
            System.out.println("Error during multiplication: " + e.getMessage());
            return null;
        }
    }

    public static FractionNew divide(FractionNew fractionFirst, FractionNew fractionSecond){
        try {
            int numerator = fractionFirst.getNumerator() * fractionSecond.getDivider();
            int divider = fractionFirst.getDivider() * fractionSecond.getNumerator();
            if (divider == 0){
                throw new ArithmeticException("Divider cannot be zero");
            }
            return correction(numerator, divider);
        } catch (ArithmeticException e) {
            System.out.println("Error during division: " + e.getMessage());
            return null;
        }
    }

    public static FractionNew correction(int numerator, int divider){
        try {
            int greatCommonDivision = gcd(numerator, divider);
            numerator /= greatCommonDivision;
            divider /= greatCommonDivision;
            return divider < 0 ? new FractionNew(-numerator, -divider) : new FractionNew(numerator, divider);
        } catch (ArithmeticException e) {
            System.out.println("Error during sign correction: " + e.getMessage());
            return null;
        }
    }

    private static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }

}

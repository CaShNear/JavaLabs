package Lab3_1;

public class Fraction {

    private int numerator;
    private int divider;

    public Fraction(){
        setNumerator(1);
        setDivider(1);
    }

    public Fraction(int numerator, int divider){
        setNumerator(numerator);
        setDivider(divider);
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public int getDivider() {
        return divider;
    }

    public static Fraction add(Fraction fractionFirst, Fraction fractionSecond){
        int numerator = fractionFirst.getNumerator() * fractionSecond.getDivider() + fractionSecond.getNumerator() * fractionFirst.getDivider();
        int divider = fractionFirst.getDivider() * fractionSecond.getDivider();
        return correction(numerator, divider);
    }

    public static Fraction subtract(Fraction fractionFirst, Fraction fractionSecond){
        int numerator = fractionFirst.getNumerator() * fractionSecond.getDivider() - fractionSecond.getNumerator() * fractionFirst.getDivider();
        int divider = fractionFirst.getDivider() * fractionSecond.getDivider();
        return correction(numerator, divider);
    }

    public static Fraction multiply(Fraction fractionFirst, Fraction fractionSecond){
        int numerator = fractionFirst.getNumerator() * fractionSecond.getNumerator();
        int divider = fractionFirst.getDivider() * fractionSecond.getDivider();
        return correction(numerator, divider);
    }

    public static Fraction divide(Fraction fractionFirst, Fraction fractionSecond){
        int numerator = fractionFirst.getNumerator() * fractionSecond.getDivider();
        int divider = fractionFirst.getDivider() * fractionSecond.getNumerator();
        return correction(numerator, divider);
    }

    public static Fraction correction(int numerator, int divider){
        int greatCommonDivision = gcd(numerator, divider);
        numerator /= greatCommonDivision;
        divider /= greatCommonDivision;
        return divider < 0 ? new Fraction(-numerator, -divider) : new Fraction(numerator, divider);
    }

    private static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }

    public static void method(Fraction[] fractionArray){
        for (int i = 1; i < fractionArray.length; i++){
            fractionArray[i-1] = Fraction.add(fractionArray[i-1], fractionArray[i]);
        }
    }

}

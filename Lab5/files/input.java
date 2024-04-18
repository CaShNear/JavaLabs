package Lab5_1;

public class Fraction {

    private int numerator;
    private int divider;

    public Fraction() {
        setNumerator(1);
        setDivider(1);
    }

    public Fraction(int numerator, int divider) {
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

}
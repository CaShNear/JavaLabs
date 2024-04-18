package Lab5_1;

public class ContinuedFractionNew {

    private double result;

    public ContinuedFractionNew(){
        setResult(0);
    }

    public ContinuedFractionNew(double result){
        setResult(result);
    }

    public ContinuedFractionNew(int x, int n, int[] a){
        try {
            double result = 1;
            for (int i = n - 1; i >= 0; i--) {
                result = a[i] + x / result;
                if (result == 0){
                    throw new ArithmeticException("Cannot divide on zero");
                }
            }
            setResult(result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error during calculation of continued fraction: " + e.getMessage());
        }
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public static ContinuedFractionNew add(ContinuedFractionNew fractionFirst, ContinuedFractionNew fractionSecond){
        try {
            return new ContinuedFractionNew(fractionFirst.getResult() + fractionSecond.getResult());
        }
        catch (ArithmeticException e) {
            System.out.println("Error during addition: " + e.getMessage());
            return null;
        }
    }

    public static ContinuedFractionNew subtract(ContinuedFractionNew fractionFirst, ContinuedFractionNew fractionSecond){
        try {
            return new ContinuedFractionNew(fractionFirst.getResult() - fractionSecond.getResult());
        }
        catch (ArithmeticException e) {
            System.out.println("Error during subtraction: " + e.getMessage());
            return null;
        }
    }

    public static ContinuedFractionNew multiply(ContinuedFractionNew fractionFirst, ContinuedFractionNew fractionSecond){
        try {
            return new ContinuedFractionNew(fractionFirst.getResult() * fractionSecond.getResult());
        }
        catch (ArithmeticException e) {
            System.out.println("Error during multiplication: " + e.getMessage());
            return null;
        }
    }

    public static ContinuedFractionNew divide(ContinuedFractionNew fractionFirst, ContinuedFractionNew fractionSecond){
        try {
            if (fractionSecond.getResult() == 0) {
                throw new ArithmeticException("Divider cannot be zero");
            }
            return new ContinuedFractionNew(fractionFirst.getResult() / fractionSecond.getResult());
        }
        catch (ArithmeticException e) {
            System.out.println("Error during division: " + e.getMessage());
            return null;
        }
    }

}

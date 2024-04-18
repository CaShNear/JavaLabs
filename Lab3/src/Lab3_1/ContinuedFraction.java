package Lab3_1;

public class ContinuedFraction {

    private double result;

    public ContinuedFraction(){
        setResult(0);
    }

    public ContinuedFraction(double result){
        setResult(result);
    }

    public ContinuedFraction(int x, int n, int[] a){
        double result = 1;
        for (int i = n - 1; i >= 0; i--){
            result = a[i] + x / result;
        }
        setResult(result);
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public static ContinuedFraction add(ContinuedFraction fractionFirst, ContinuedFraction fractionSecond){
        return new ContinuedFraction(fractionFirst.getResult() + fractionSecond.getResult());
    }

    public static ContinuedFraction subtract(ContinuedFraction fractionFirst, ContinuedFraction fractionSecond){
        return new ContinuedFraction(fractionFirst.getResult() - fractionSecond.getResult());
    }

    public static ContinuedFraction multiply(ContinuedFraction fractionFirst, ContinuedFraction fractionSecond){
        return new ContinuedFraction(fractionFirst.getResult() * fractionSecond.getResult());
    }

    public static ContinuedFraction divide(ContinuedFraction fractionFirst, ContinuedFraction fractionSecond){
        return new ContinuedFraction(fractionFirst.getResult() / fractionSecond.getResult());
    }

}

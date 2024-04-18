package Lab6_2.Lab6_2_6;

public class Line {

    private double a, b, c;

    public Line(Dot dot1, Dot dot2){
        if (dot1.getX() - dot2.getX() == 0){
            this.a = 1;
            this.b = 0;
            this.c = -dot1.getX();
        }
        else{
            this.a = - (dot1.getY() - dot2.getY()) / (dot1.getX() - dot2.getX());
            this.b = 1;
            this.c = - this.a * dot2.getX() - this.b * dot2.getY();
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public int hashCode(){
        int result = 17;
        long temp;

        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Line helper = (Line) obj;
        return Double.compare(helper.a, a) == 0 &&
                Double.compare(helper.b, b) == 0 &&
                Double.compare(helper.c, c) == 0;
    }
}

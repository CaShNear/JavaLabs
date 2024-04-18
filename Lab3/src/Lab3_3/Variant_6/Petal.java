package Lab3_3.Variant_6;

import java.util.Objects;

public class Petal {

    private String color;

    public Petal(String color){
        setColor(color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Petal petal)) return false;
        return Objects.equals(petal.getColor(), getColor());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getColor());
    }

    @Override
    public String toString(){
        return String.format("Petal = { color: %s }", color);
    }

}

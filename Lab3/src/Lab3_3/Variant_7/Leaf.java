package Lab3_3.Variant_7;

import java.util.Objects;

public class Leaf {

    private String state;

    public Leaf(){
        setState("Green");
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Leaf leaf)) return false;
        return Objects.equals(leaf.getState(), getState());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getState());
    }

    @Override
    public String toString(){
        return String.format("Leaf = { state: %s }", state);
    }

}

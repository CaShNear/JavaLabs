package Lab3_4.Variant_6;

public class Work {

    private String name;
    private double cost;
    private boolean type;

    public Work(){ }

    public Work(String name, double cost, boolean type){
        setName(name);
        setCost(cost);
        setType(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean getType(){
        return type;
    }
}

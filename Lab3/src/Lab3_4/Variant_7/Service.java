package Lab3_4.Variant_7;

public class Service {

    private String name;
    private double cost;

    public Service(){ }

    public Service(String name, double cost){
        setName(name);
        setCost(cost);
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

    @Override
    public String toString(){
        return String.format("Service = { name: %s, cost: %f}", name, cost);
    }

}

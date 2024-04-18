package Lab3_3.Variant_6;

public abstract class Bud {

    protected int countPetals;
    protected Petal[] petals;

    public Bud(){
    }

    public int getCountPetals() {
        return countPetals;
    }

    public void setPetals(Petal[] petals) {
        this.petals = petals;
        this.countPetals = petals.length;
    }

    public Petal[] getPetals() {
        return petals;
    }

}

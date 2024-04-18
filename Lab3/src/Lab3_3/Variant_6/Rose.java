package Lab3_3.Variant_6;

import java.util.Objects;
import java.util.Random;

public class Rose extends Bud{

    public Rose(){
        bloom();
    }

    public void bloom(){
        Random random = new Random();
        this.countPetals = random.nextInt(10) + 2;
        this.petals = new Petal[this.countPetals];
        String color = switch (random.nextInt(9)) {
            case 0 -> "Red";
            case 1 -> "Black";
            case 2 -> "White";
            case 3 -> "Violet";
            case 4 -> "Pink";
            case 5 -> "Orange";
            case 6 -> "Cream";
            case 7 -> "Lavender";
            default -> "Blue";
        };
        for (int i = 0; i < this.countPetals; i++) {
            this.petals[i] = new Petal(color);
        }
    }

    public void wither(){
        setPetals(new Petal[0]);
    }

    public String getColor(){
        return petals[0].getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Rose rose)) return false;
        Petal[] firstPetals = getPetals();
        Petal[] secondPetals = rose.getPetals();
        if (firstPetals.length != secondPetals.length) { return false; }
        boolean check = true;
        for (int i = 0; check && i < countPetals; i++) {
            if (!firstPetals[i].equals(secondPetals[i])) { check = false; }
        }
        return check;
    }

    @Override
    public int hashCode(){
        return Objects.hash((Object) getPetals());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Rose = {\n");
        result.append(String.format("\tcountPetal: %d\n\tpetals = {\n", countPetals));
        for (Petal petals : getPetals()) {
            result.append("\t\t").append(petals.toString()).append("\n");
        }
        result.append("\t}\n}");
        return result.toString();
    }
}

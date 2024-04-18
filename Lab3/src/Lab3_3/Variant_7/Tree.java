package Lab3_3.Variant_7;

import java.util.Objects;
import java.util.Random;

public class Tree {

    protected int countLeaves;
    protected Leaf[] leaves;

    public Tree(){
        bloom();
    }

    public void bloom(){
        Random random = new Random();
        this.countLeaves = random.nextInt(20) + 10;
        this.leaves = new Leaf[this.countLeaves];
        for (int i = 0; i < this.countLeaves; i++) {
            this.leaves[i] = new Leaf();
        }
    }

    public void wither(){
        setLeaves(new Leaf[0]);
    }

    public void turnYellow(){
        Random random = new Random();
        for (int i = 0; i < this.countLeaves; i++){
            boolean choice = random.nextBoolean();
            if (choice) { leaves[i].setState("Yellow"); }
        }
    }

    public void coverWithFrost(){
        Random random = new Random();
        for (int i = 0; i < this.countLeaves; i++){
            boolean choice = random.nextBoolean();
            if (choice) { leaves[i].setState("Covered with frost"); }
        }
    }

    public int getCountLeaves() {
        return countLeaves;
    }

    public void setLeaves(Leaf[] leaves) {
        this.leaves = leaves;
        this.countLeaves = leaves.length;
    }

    public Leaf[] getLeaves() {
        return leaves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Tree tree)) return false;
        Leaf[] firstLeaves = getLeaves();
        Leaf[] secondLeaves = tree.getLeaves();
        if (firstLeaves.length != secondLeaves.length) { return false; }
        boolean check = true;
        for (int i = 0; check && i < countLeaves; i++) {
            if (!firstLeaves[i].equals(secondLeaves[i])) { check = false; }
        }
        return check;
    }

    @Override
    public int hashCode(){
        return Objects.hash((Object) getLeaves());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Tree = {\n");
        result.append(String.format("\tcountLeaves: %d\n\tleaves = {\n", countLeaves));
        for (Leaf leaves : getLeaves()) {
            result.append("\t\t").append(leaves.toString()).append("\n");
        }
        result.append("\t}\n}");
        return result.toString();
    }

}

package Lab3_4.Variant_6;

public class TechnicalTask {

    private String description;
    private int workCount;
    private Work[] workList;

    public TechnicalTask(){
        setWorkList(new Work[0]);
    }

    public TechnicalTask(String description){
        setDescription(description);
        setWorkList(new Work[0]);
    }

    public TechnicalTask(String description, Work[] workList){
        setDescription(description);
        setWorkList(workList);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setWorkList(Work[] workList) {
        this.workList = workList;
        this.workCount = workList.length;
    }

    public Work[] getWorkList() {
        return workList;
    }

    public int getWorkCount() {
        return workCount;
    }
}

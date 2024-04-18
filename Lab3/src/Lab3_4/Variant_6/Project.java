package Lab3_4.Variant_6;

import java.util.Scanner;

public class Project {

    private int id;
    private String name;
    private TechnicalTask technicalTask;
    private double projectCost;
    private double buildingCost;
    private int constructorCount;
    private Constructor[] constructorTeam;

    public Project(){
        setTechnicalTask(new TechnicalTask());
        setConstructorTeam(new Constructor[0]);
    }

    public Project(int id, String name, TechnicalTask technicalTask){
        setId(id);
        setName(name);
        setTechnicalTask(technicalTask);
        costCount(technicalTask);
        setConstructorTeam(new Constructor[0]);
    }

    public Project(int id, String name, TechnicalTask technicalTask, Constructor[] constructorTeam){
        setId(id);
        setName(name);
        setTechnicalTask(technicalTask);
        costCount(technicalTask);
        setConstructorTeam(constructorTeam);
    }

    public void costCount(TechnicalTask technicalTask){
        Work[] list = technicalTask.getWorkList();
        double projectCost = 0;
        double buildingCost = 0;
        for (Work work : list) {
            if (work.getType()) {
                buildingCost += work.getCost();
            } else {
                projectCost += work.getCost();
            }
        }
        setProjectCost(projectCost);
        setBuildingCost(buildingCost);
    }

    public void setProjectTeam(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount of workers for this project: ");
        int constructorCount = in.nextInt();
        Constructor[] constructors = new Constructor[constructorCount];
        for (int i = 0; i < constructorCount; i++){
            System.out.print(String.format("Enter %d worker's surname: ", i+1));
            String surname = in.nextLine();
            System.out.print(String.format("Enter %d worker's name: ", i+1));
            String name = in.nextLine();
            System.out.print(String.format("Enter %d worker's post: ", i+1));
            String post = in.nextLine();
            constructors[i] = new Constructor(i+1, surname, name, post);
        }
        setConstructorTeam(constructors);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTechnicalTask(TechnicalTask technicalTask) {
        this.technicalTask = technicalTask;
    }

    public TechnicalTask getTechnicalTask() {
        return technicalTask;
    }

    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public void setBuildingCost(double buildingCost) {
        this.buildingCost = buildingCost;
    }

    public double getBuildingCost() {
        return buildingCost;
    }

    public void setConstructorTeam(Constructor[] constructorTeam) {
        this.constructorTeam = constructorTeam;
        this.constructorCount = constructorTeam.length;
    }

    public Constructor[] getConstructorTeam() {
        return constructorTeam;
    }

    public int getConstructorCount() {
        return constructorCount;
    }
}

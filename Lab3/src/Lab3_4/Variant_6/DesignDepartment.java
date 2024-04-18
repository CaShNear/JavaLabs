package Lab3_4.Variant_6;

import java.util.Objects;
import java.util.Scanner;

public class DesignDepartment {

    private int countProjects;
    private Project[] projectList;

    public DesignDepartment(){
        setProjectList(new Project[0]);
    }

    public DesignDepartment(Project[] projectList){
        setProjectList(projectList);
    }

    public void addProject(){
        Project[] projects = new Project[countProjects + 1];
        if (countProjects >= 0) System.arraycopy(projectList, 0, projects, 0, countProjects);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter project name: ");
        String name = in.nextLine();
        System.out.print("Enter project description: ");
        String description = in.nextLine();
        System.out.print("Enter amount of work in project: ");
        int workCount = in.nextInt();
        Work[] workList = new Work[workCount];
        for (int i = 0; i < workCount; i++){
            System.out.print(String.format("Enter name of %d work: ", i+1));
            String workName = in.nextLine();
            System.out.print(String.format("Enter name of %d work: ", i+1));
            double cost = in.nextDouble();
            System.out.print(String.format("Is %d work building type work? (yes/no) ", i+1));
            String choice = in.nextLine();
            if (Objects.equals(choice, "yes")){
                workList[i] = new Work(workName, cost, true);
            } else{
                workList[i] = new Work(workName, cost, false);
            }
        }
        projects[countProjects] = new Project(countProjects+1, name, new TechnicalTask(description, workList));
        countProjects += 1;
        projectList = projects;
    }

    public void showInvoice(){
        int pos = searchCustomer();
        if (pos != -1){
            System.out.println(String.format("Totally cost of this project is %f",
                    projectList[pos].getProjectCost() + projectList[pos].getBuildingCost()));
        }
    }

    public void setProjectTeam(){
        int pos = searchCustomer();
        if (pos != -1){
            projectList[pos].setProjectTeam();
        }
    }

    public int searchCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter project's name for searching: ");
        String name = in.nextLine();
        for (int i = 0; i < countProjects; i++){
            if (name.equals(projectList[i].getName())){
                return i;
            }
        }
        System.out.println("No such project");
        return -1;
    }

    public void setProjectList(Project[] projectList) {
        this.projectList = projectList;
        this.countProjects = projectList.length;
    }

    public Project[] getProjectList() {
        return projectList;
    }

    public int getCountProjects() {
        return countProjects;
    }
}

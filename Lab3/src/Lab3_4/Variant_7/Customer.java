package Lab3_4.Variant_7;

import java.util.Scanner;

public class Customer {

    private int id;
    private String surname;
    private String name;
    private String phoneNumber;
    private double balance;
    private boolean state;
    private int servicesCount;
    private Service[] services;

    public Customer(){ }

    public Customer(int id, String surname, String name, String phoneNumber, double balance){
        setId(id);
        setSurname(surname);
        setName(name);
        setPhoneNumber(phoneNumber);
        setBalance(balance);
        setState(true);
        setServices(new Service[0]);
    }
    
    public void changeServices(){
        Scanner in = new Scanner(System.in);
        System.out.println("""
                What do you want to do?
                1 - See all services
                2 - Add service
                3 - Delete service
                4 - Exit""");
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                for (int i = 0; i < servicesCount; i++){
                    System.out.println(services[i]);
                } break;
            case 2: addService(); break;
            case 3: deleteService(); break;
            case 4: System.out.println("Exit from service's changing"); break;
            default: System.out.println("Wrong choice input. Try again.");
        }
    }
    
    public void addService(){
        Service[] temp = new Service[servicesCount + 1];
        if (servicesCount >= 0) System.arraycopy(services, 0, temp, 0, servicesCount);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter service's name: ");
        String name = in.nextLine();
        System.out.print("Enter service's cost: ");
        double cost = in.nextDouble();
        temp[servicesCount] = new Service(name, cost);
        servicesCount += 1;
        services = temp;
    }

    
    public void deleteService(){
        int pos = serviceSearch();
        Service[] temp = new Service[servicesCount - 1];
        if (pos != -1){
            if (servicesCount > 1) {
                if (pos == 0) {
                    System.arraycopy(services, 1, temp, 0, servicesCount - 1);
                } else if (pos == servicesCount) {
                    System.arraycopy(services, 0, temp, 0, servicesCount - 1);
                } else {
                    System.arraycopy(services, 0, temp, 0, pos);
                    System.arraycopy(services, pos + 1, temp, pos, servicesCount - pos - 1);
                }
            }
        }
        services = temp;
    }
    
    private int serviceSearch(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter service's name: ");
        String name = in.nextLine();
        for (int i = 0; i < servicesCount; i++){
            if (name.equals(services[i].getName())){
                return i;
            }
        }
        System.out.println("No such service");
        return -1;
    }
    
    public void payToBalance(double payment){
        balance += payment;
        connectDisconnect();
    }

    public void payForPayment(){
        for (int i = 0; i < servicesCount; i++){
            balance -= services[i].getCost();
        }
        connectDisconnect();
    }

    private void connectDisconnect(){
        if (balance < 0){
            setState(false);
        } else {
            setState(true);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState(){
        return state;
    }

    public void setServices(Service[] services) {
        this.services = services;
        this.servicesCount = services.length;
    }

    public Service[] getServices() {
        return services;
    }

    public int getServicesCount() {
        return servicesCount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Customer = {\n");
        result.append(String.format("\tid: %d\n\tsurname: %s\n\tname: %s\n\tbalance: %f\n\tstate: %b \n\t" +
                "servicesCount: %d\n\tservices = {\n", id, surname, name, balance, state, servicesCount));
        for (Service services : getServices()) {
            result.append("\t\t").append(services.toString()).append("\n");
        }
        result.append("\t}\n}");
        return result.toString();
    }

}

package Lab3_4.Variant_7;

import java.util.Scanner;

public class TelephoneStation {

    int customerCount;
    Customer[] customerList;

    public TelephoneStation(){
        setCustomerList(new Customer[0]);
    }

    public void addCustomer(){
        Customer[] temp = new Customer[customerCount + 1];
        if (customerCount >= 0) System.arraycopy(customerList, 0, temp, 0, customerCount);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter customer's surname: ");
        String surname = in.nextLine();
        System.out.print("Enter customer's name: ");
        String name = in.nextLine();
        System.out.print("Enter customer's phone number: ");
        String phoneNumber = in.nextLine();
        System.out.print("Enter customer's balance: ");
        double balance = in.nextDouble();
        temp[customerCount] = new Customer(customerCount + 1, surname, name, phoneNumber, balance);
        customerCount += 1;
        customerList = temp;
    }

    public void changeNumber(){
        int pos = searchCustomer();
        if (pos != -1){
            Scanner in = new Scanner(System.in);
            System.out.print("Enter new customer's phone: ");
            String phoneNumber = in.nextLine();
            customerList[pos].setPhoneNumber(phoneNumber);
        }
    }

    public void changeServices(){
        int pos = searchCustomer();
        if (pos != -1){
            customerList[pos].changeServices();
        }
    }

    public void repayPayment(){
        int pos = searchCustomer();
        if (pos != -1){
            System.out.print("Enter customer's payment: ");
            Scanner in = new Scanner(System.in);
            double payment = in.nextDouble();
            customerList[pos].payToBalance(payment);
        }
    }

    public void payForServices(){
        System.out.println("Payment for service starts");
        for (int i = 0; i < customerCount; i++){
            customerList[i].payForPayment();
        }
        System.out.println("Payment for service ended");
    }

    public void checkBalance(){
        int pos = searchCustomer();
        if (pos != -1){
            System.out.println(String.format("Customer's balance: %f", customerList[pos].getBalance()));
        }
    }

    public int searchCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter customer's surname for searching: ");
        String surname = in.nextLine();
        System.out.print("Enter customer's name for searching: ");
        String name = in.nextLine();
        for (int i = 0; i < customerCount; i++){
            if (surname.equals(customerList[i].getSurname()) && name.equals(customerList[i].getName())){
                return i;
            }
        }
        System.out.println("No such customer");
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("TelephoneStation = {\n");
        result.append(String.format("customerList: %d\ncustomerList = {\n", customerCount));
        for (Customer customerList : getCustomerList()) {
            result.append(customerList.toString()).append("\n");
        }
        result.append("}\n}");
        return result.toString();
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerList(Customer[] customerList) {
        this.customerList = customerList;
        this.customerCount = customerList.length;
    }

    public Customer[] getCustomerList() {
        return customerList;
    }
}

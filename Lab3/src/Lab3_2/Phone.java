package Lab3_2;

public class Phone {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private long cityCallTimeInSeconds;
    private long intercityCallTimeInSeconds;

    public Phone(){}

    public Phone(int id, String surname, String name, String patronymic,
                 long cityCallTimeInSeconds, long intercityCallTimeInSeconds){
        setId(id);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setCityCallTimeInSeconds(cityCallTimeInSeconds);
        setIntercityCallTimeInSeconds(intercityCallTimeInSeconds);
    }

    public Phone(int id, String surname, String name, String patronymic, String address, String creditCardNumber,
                 double debit, double credit, long cityCallTimeInSeconds, long intercityCallTimeInSeconds){
        setId(id);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAddress(address);
        setCreditCardNumber(creditCardNumber);
        setDebit(debit);
        setCredit(credit);
        setCityCallTimeInSeconds(cityCallTimeInSeconds);
        setIntercityCallTimeInSeconds(intercityCallTimeInSeconds);
    }

    public static void sort(Phone[] array, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Phone pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (compare(array[leftMarker], pivot)) {
                leftMarker++;
            }
            while (compare(pivot, array[rightMarker])) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    Phone temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            sort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sort(array, leftBorder, rightMarker);
        }
    }

    public static boolean compare(Phone firstPhone, Phone secondPhone){
        int surnameCompare = secondPhone.getSurname().compareTo(firstPhone.getSurname());
        int nameCompare = secondPhone.getName().compareTo(firstPhone.getName());
        int patronymicCompare = secondPhone.getPatronymic().compareTo(firstPhone.getPatronymic());
        if (surnameCompare > 0){
            return true;
        } else if ((surnameCompare == 0) && (nameCompare > 0)) {
            return true;
        } else if ((surnameCompare == 0) && (nameCompare == 0) && (patronymicCompare > 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return String.format("""
                Phone = { \n\tid: %d \n\tsurname: %s \n\tname: %s \n\tpatronymic: %s \n\taddress: %s
                \tcreditCardNumber: %s \n\tdebit: %f \n\tcredit: %f \n\tcityCallTimeInSeconds: %d
                \tintercityCallTimeInSeconds: %d \n}""", id, surname, name, patronymic, address, creditCardNumber,
                debit, credit, cityCallTimeInSeconds, intercityCallTimeInSeconds);
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

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getDebit() {
        return debit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCityCallTimeInSeconds(long cityCallTimeInSeconds) {
        this.cityCallTimeInSeconds = cityCallTimeInSeconds;
    }

    public long getCityCallTimeInSeconds() {
        return cityCallTimeInSeconds;
    }

    public void setIntercityCallTimeInSeconds(long intercityCallTimeInSeconds) {
        this.intercityCallTimeInSeconds = intercityCallTimeInSeconds;
    }

    public long getIntercityCallTimeInSeconds() {
        return intercityCallTimeInSeconds;
    }

}

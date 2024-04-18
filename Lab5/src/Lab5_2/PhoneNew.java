package Lab5_2;

public class PhoneNew {

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

    public PhoneNew(){}

    public PhoneNew(int id, String surname, String name, String patronymic,
                    long cityCallTimeInSeconds, long intercityCallTimeInSeconds){
        try {
            setId(id);
            setSurname(surname);
            setName(name);
            setPatronymic(patronymic);
            setCityCallTimeInSeconds(cityCallTimeInSeconds);
            setIntercityCallTimeInSeconds(intercityCallTimeInSeconds);
        }
        catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public PhoneNew(int id, String surname, String name, String patronymic, String address, String creditCardNumber,
                    double debit, double credit, long cityCallTimeInSeconds, long intercityCallTimeInSeconds){
        try {
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
        catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void sort(PhoneNew[] array, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        PhoneNew pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (compare(array[leftMarker], pivot)) {
                leftMarker++;
            }
            while (compare(pivot, array[rightMarker])) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    PhoneNew temp = array[leftMarker];
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

    public static boolean compare(PhoneNew firstPhone, PhoneNew secondPhone){
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

    public void setId(int id) throws InvalidInputException {
        if (id <= 0){
            throw new InvalidInputException("Parameter 'ID' must be positive and not zero.");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSurname(String surname) throws InvalidInputException {
        if (surname == null || surname.isEmpty()) {
            throw new InvalidInputException("Parameter 'Surname' cannot be null or empty.");
        }
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Parameter 'Name' cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPatronymic(String patronymic) throws InvalidInputException {
        if (patronymic == null || patronymic.isEmpty()) {
            throw new InvalidInputException("Parameter 'Patronymic' cannot be null or empty.");
        }
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setAddress(String address) throws InvalidInputException {
        if (address == null || address.isEmpty()) {
            throw new InvalidInputException("Parameter 'Address' cannot be null or empty.");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCreditCardNumber(String creditCardNumber) throws InvalidInputException {
        if (creditCardNumber == null || creditCardNumber.isEmpty()) {
            throw new InvalidInputException("Parameter 'Credit card number' cannot be null or empty.");
        }
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setDebit(double debit) throws InvalidInputException {
        if(Double.compare(debit, 0) <= 0){
            throw new InvalidInputException("Parameter 'Debit' must be positive and not zero.");
        }
        this.debit = debit;
    }

    public double getDebit() {
        return debit;
    }

    public void setCredit(double credit) throws InvalidInputException {
        if(Double.compare(credit, 0) <= 0){
            throw new InvalidInputException("Parameter 'Credit' must be positive and not zero.");
        }
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCityCallTimeInSeconds(long cityCallTimeInSeconds) throws InvalidInputException {
        if (cityCallTimeInSeconds < 0){
            throw new InvalidInputException("Parameter 'City call time in seconds' must be positive.");
        }
        this.cityCallTimeInSeconds = cityCallTimeInSeconds;
    }

    public long getCityCallTimeInSeconds() {
        return cityCallTimeInSeconds;
    }

    public void setIntercityCallTimeInSeconds(long intercityCallTimeInSeconds) throws InvalidInputException {
        if (intercityCallTimeInSeconds < 0){
            throw new InvalidInputException("Parameter 'Intercity call time in seconds' must be positive.");
        }
        this.intercityCallTimeInSeconds = intercityCallTimeInSeconds;
    }

    public long getIntercityCallTimeInSeconds() {
        return intercityCallTimeInSeconds;
    }

}

package Lab5_2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HouseNew {

    private int id;
    private int houseNumber;
    private double square;
    private int floor;
    private int roomsCount;
    private String address;
    private String type;
    private GregorianCalendar data;

    public HouseNew(){}

    public HouseNew(int id, int houseNumber, double square, int floor, int roomsCount){
        try {
            setId(id);
            setHouseNumber(houseNumber);
            setSquare(square);
            setFloor(floor);
            setRoomsCount(roomsCount);
        }
        catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public HouseNew(int id, int houseNumber, double square, int floor, int roomsCount, String address,
                    String type, GregorianCalendar data){
        try {
            setId(id);
            setHouseNumber(houseNumber);
            setSquare(square);
            setFloor(floor);
            setRoomsCount(roomsCount);
            setAddress(address);
            setType(type);
            setData(data);
        }
        catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String toString(){
        return String.format("""
                House = { \n\tid: %d \n\thouseNumber: %d \n\tsquare: %f \n\tfloor: %d \n\troomsCount: %d \n\taddress: %s
                type: %s \n\t lifetime: %d:%d:%d""", id, houseNumber, square, floor, roomsCount, address, type,
                data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH), data.get(Calendar.YEAR));
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

    public void setHouseNumber(int houseNumber) throws InvalidInputException{
        if (houseNumber <= 0){
            throw new InvalidInputException("Parameter 'House Number' must be positive and not zero.");
        }
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setSquare(double square) throws InvalidInputException {
        if(Double.compare(square, 0) <= 0){
            throw new InvalidInputException("Parameter 'Square' must be positive and not zero.");
        }
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setFloor(int floor) throws InvalidInputException {
        if (floor <= 0){
            throw new InvalidInputException("Parameter 'Floor' must be positive and not zero.");
        }
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setRoomsCount(int roomsCount) throws InvalidInputException {
        if (roomsCount <= 0){
            throw new InvalidInputException("Parameter 'Count of rooms' must be positive and not zero.");
        }
        this.roomsCount = roomsCount;
    }

    public int getRoomsCount() {
        return roomsCount;
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

    public void setType(String type) throws InvalidInputException {
        if (type == null || type.isEmpty()) {
            throw new InvalidInputException("Parameter 'Type' cannot be null or empty.");
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public GregorianCalendar getData() {
        return data;
    }
}
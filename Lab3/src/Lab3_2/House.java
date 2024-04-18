package Lab3_2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class House {

    private int id;
    private int houseNumber;
    private double square;
    private int floor;
    private int roomsCount;
    private String address;
    private String type;
    private GregorianCalendar data;

    public House(){}

    public House(int id, int houseNumber, double square, int floor, int roomsCount){
        setId(id);
        setHouseNumber(houseNumber);
        setSquare(square);
        setFloor(floor);
        setRoomsCount(roomsCount);
    }

    public House(int id, int houseNumber, double square, int floor, int roomsCount, String address,
                 String type, GregorianCalendar data){
        setId(id);
        setHouseNumber(houseNumber);
        setSquare(square);
        setFloor(floor);
        setRoomsCount(roomsCount);
        setAddress(address);
        setType(type);
        setData(data);
    }

    @Override
    public String toString(){
        return String.format("""
                House = { \n\tid: %d \n\thouseNumber: %d \n\tsquare: %f \n\tfloor: %d \n\troomsCount: %d \n\taddress: %s
                type: %s \n\t lifetime: %d:%d:%d""", id, houseNumber, square, floor, roomsCount, address, type,
                data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH), data.get(Calendar.YEAR));
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setType(String type) {
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

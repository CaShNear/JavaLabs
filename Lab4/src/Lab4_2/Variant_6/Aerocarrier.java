package Lab4_2.Variant_6;

import java.util.Scanner;

public class Aerocarrier extends Warship{

    private String shipName;

    public Aerocarrier(String shipName){
        this.Type = "Aero Carrier";
        this.shipName = shipName;
    }

    @Override
    public String getType(){
        return Type;
    }

    @Override
    public void setShipName(){
        System.out.print("Input name of the ship: ");
        Scanner in = new Scanner(System.in);
        shipName = in.nextLine();
    }

    @Override
    public String getShipName(){
        return shipName;
    }

}

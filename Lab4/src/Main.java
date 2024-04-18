import Lab4_1.PubTransportInfService;
import Lab4_1.Shop;
import Lab4_2.Variant_6.Aerocarrier;
import Lab4_2.Variant_7.Neurosurgeon;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        // Вариант 1 задание 6

        Shop shopDirectory = new Shop();

        shopDirectory.addInfo("Pharmacy", "Drugs", "Buying");
        shopDirectory.addInfo("Confectionery", "Sweets", "Buying");
        shopDirectory.addInfo("Jeweller’s", "Jewelry", "Selling");

        for (Shop.ShopInfo info : shopDirectory.getInfoService()) {
            System.out.println("Department: " + info.getDepartment());
            System.out.println("Product: " + info.getProduct());
            System.out.println("Service: " + info.getService());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 1 задание 7

        PubTransportInfService transportDirectory = new PubTransportInfService();

        Calendar time = new GregorianCalendar();
        time.set(Calendar.HOUR_OF_DAY, 12);
        time.set(Calendar.MINUTE, 30);
        transportDirectory.addInfo(time, "Route 1", 2.50);

        time.set(Calendar.HOUR_OF_DAY, 15);
        time.set(Calendar.MINUTE, 45);
        transportDirectory.addInfo(time, "Route 2", 3.00);

        for (PubTransportInfService.RouteInfo info : transportDirectory.getInfoService()) {
            System.out.println("Time: " + info.getTime().get(Calendar.HOUR_OF_DAY) + ":" + info.getTime().get(Calendar.MINUTE));
            System.out.println("Route: " + info.getRoute());
            System.out.println("Cost: " + info.getCost());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 6

        Aerocarrier ship = new Aerocarrier("Nevada");
        System.out.println("Name of ship: " + ship.getShipName());
        System.out.println("Type of ship: " + ship.getType());

        System.out.println("----------------------------------------------------------------------------------------------------------------");

        // Вариант 2 задание 7

        Neurosurgeon doctor = new Neurosurgeon();
        doctor.treatPatient();

    }

}
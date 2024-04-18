package Lab8_3;

import java.util.Random;

public class Main {

    private int amountOfProduct;
    private static boolean finished = false;

    public Main(int initialAmmount){
        this.amountOfProduct = initialAmmount;
    }

    public synchronized void addProduct (int amount){
        amountOfProduct += amount;
        System.out.println("Adding " + amount + " of product to the shop. Current amount of product in the shop: " + amountOfProduct);
    }

    public synchronized void buyProduct (int amount){
        if (amountOfProduct >= amount){
            amountOfProduct -= amount;
            System.out.println("Buying " + amount + " products from the shop. Current amount of product in the shop: " + amountOfProduct);
        }
        else{
            System.out.println("Can't buy " + amount + " products");
        }
    }

    public static void main(String[] args) {

        Main shop = new Main(10);

        Thread AddingToTheShop = new Thread(() -> {
            Random rand = new Random();
            synchronized (shop){
                for (int i = 0; i < 10; i++){
                    int amount = rand.nextInt(5)+1;
                    shop.addProduct(amount);
                    shop.notify();
                    try {
                        shop.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                finished = true;
                shop.notify();
            }
        });

        Thread BuyingFromTheShop = new Thread(() -> {
            Random rand = new Random();
            synchronized (shop) {
                while (!finished) {

                    int amount = rand.nextInt(7)+1; // случайная сумма от 0 до 500
                    shop.buyProduct(amount);
                    shop.notify();
                    try {
                        shop.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                shop.notify();
            }
        });

        AddingToTheShop.start();
        BuyingFromTheShop.start();

        try {
            AddingToTheShop.join();
            BuyingFromTheShop.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Shop is closed.");

    }

}
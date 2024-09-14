package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final int WATER = 200;
        final int MILK = 50;
        final int COFFEE_BEANS = 15;
        Scanner userInput = new Scanner(System.in);

        System.out.println(
                """
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some MILK into the cup
                Coffee is ready!""");

        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = userInput.nextInt();
        System.out.printf(
                "For %d cups of coffee you will need:%n" +
                "%d ml of water%n" +
                "%d ml of MILK %n" +
                "%d g of coffee beans",
                cupsOfCoffee,
                WATER * cupsOfCoffee,
                MILK * cupsOfCoffee,
                COFFEE_BEANS * cupsOfCoffee);

        
    }
}

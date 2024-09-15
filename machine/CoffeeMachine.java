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
                "%d ml of MILK%n" +
                "%d g of coffee beans%n",
                cupsOfCoffee,
                WATER * cupsOfCoffee,
                MILK * cupsOfCoffee,
                COFFEE_BEANS * cupsOfCoffee);

        // User Input
        System.out.println("Write how many ml of water the coffee machine has:");
        int containsWater = userInput.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int containsMilk = userInput.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int containsCoffeeBeans = userInput.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeAmount = userInput.nextInt();

        // Maximum cups of coffee that can be made
        int maxCupsByWater = containsWater / WATER;
        int maxCupsByMilk = containsMilk / MILK;
        int maxCupsByCoffeeBeans = containsCoffeeBeans / COFFEE_BEANS;
        int maxCupsPossible = Math.min(maxCupsByWater, Math.min(maxCupsByMilk, maxCupsByCoffeeBeans));

        // Checks how many cups of coffee can be mades
        if (containsWater >= coffeeAmount * WATER && containsMilk >= coffeeAmount * MILK && containsCoffeeBeans >= coffeeAmount * COFFEE_BEANS) {
            if (maxCupsPossible > coffeeAmount) {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", maxCupsPossible - coffeeAmount);
            } else {
              System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.printf("No, I can only make %d cup(s) of coffee%n", maxCupsPossible);
        }
    }
}

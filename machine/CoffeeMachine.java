package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final int WATER = 200;
        final int MILK = 50;
        final int COFFEE_BEANS = 15;
        int storedMoney = 0;
        int storedCups = 9;

        Scanner userInput = new Scanner(System.in);

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
        int storedWater = containsWater / WATER;
        int storedMilk = containsMilk / MILK;
        int storedCoffeeBeans = containsCoffeeBeans / COFFEE_BEANS;
        int maxCupsPossible = Math.min(storedWater, Math.min(storedMilk, storedCoffeeBeans));

        // Checks how many cups of coffee can be made
        if (containsWater >= coffeeAmount * WATER && containsMilk >= coffeeAmount * MILK && containsCoffeeBeans >= coffeeAmount * COFFEE_BEANS) {
            if (maxCupsPossible > coffeeAmount) {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", maxCupsPossible - coffeeAmount);
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.printf("No, I can only make %d cup(s) of coffee%n", maxCupsPossible);
        }

        // Confirms what drinkType the user wants
        boolean drinkFlag = true;
        do {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            int drinkType = userInput.nextInt();
            if (drinkType == 1 || drinkType == 2 || drinkType == 3) {
                buy(drinkType, storedWater, storedMilk, storedCoffeeBeans, storedMoney, storedCups);
                drinkFlag = false;
            } else {
                System.out.println("Invalid Input, try again.");
            }
        } while (drinkFlag);
    }

    // Calculate remaining ingredients and how much money is left


    // buy function with three options espresso, latte, or cappuccino
    public static void buy(int drinkType, int storedWater, int storedMilk, int storedCoffeeBeans, int storedMoney, int storedCups) {
        if (drinkType == 1) {
            storedWater -= 250;
            storedCoffeeBeans -= 16;
            storedMoney += 4;
        } else if (drinkType == 2) {
            storedWater -= 350;
            storedMilk -= 75;
            storedCoffeeBeans -= 20;
            storedMoney += 7;
        } else if (drinkType == 3) {
            storedWater -= 200;
            storedMilk -= 100;
            storedCoffeeBeans -= 12;
            storedMoney += 6;
        } else {
            System.out.println("Not enough ingredients");
        }

        storedCups -= 1;
        System.out.printf(
                "The coffee machine has:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n" +
                "%d disposable cups%n" +
                "%d of money%n",
                storedWater, storedMilk, storedCoffeeBeans, storedCups, storedMoney
        );

    }

    // fill, ask how much water, milk, coffee and how many cups they want to add into the coffee machine
    public static void fill() {

    }

    // take, should give all the money that it earned from selling coffee
    public static void take() {

    }

}

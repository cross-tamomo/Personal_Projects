package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int storedWater = 400;
    static int storedMilk = 540;
    static int storedCoffeeBeans = 120;
    static int storedCups = 9;
    static int storedMoney = 550;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Write action:");
        action(userInput.nextLine());

    }

    // actions user's can perform
    public static void action(String userInput) {
        System.out.println("Write action:");

        if (userInput.equalsIgnoreCase("BUY")) {
            displayStored();
            buy();
            displayStored();
        } else if (userInput.equalsIgnoreCase("FILL")) {
            displayStored();
            fill();
            displayStored();
        } else if (userInput.equalsIgnoreCase("TAKE")) {
            displayStored();
            take();
            displayStored();
        } else {
            System.out.println("Invalid Action");
        }
    }

    // buy, function with three options espresso, latte, or cappuccino
    public static void buy() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int drinkType = userInput.nextInt();

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
    }

    // fill, ask how much water, milk, coffee and how many cups they want to add into the coffee machine
    public static void fill() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        int fillWater = userInput.nextInt();
        storedWater += fillWater;
        System.out.println("Write how many ml of milk you want to add:");
        int fillMilk = userInput.nextInt();
        storedMilk += fillMilk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int fillCoffeeBeans = userInput.nextInt();
        storedCoffeeBeans += fillCoffeeBeans;
        System.out.println("Write how many disposable cups you want to add:");
        int fillCups = userInput.nextInt();
        storedCups += fillCups;

    }

    // take, should give all the money that it earned from selling coffee
    public static void take() {
        System.out.println("I gave you $" + storedMoney);
        storedMoney = 0;
    }

    // display stored supplies
    public static void displayStored() {
        System.out.printf(
            "The coffee machine has:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n" +
                "%d disposable cups%n" +
                "$%d of money%n",
            storedWater, storedMilk, storedCoffeeBeans, storedCups, storedMoney
        );
    }
}

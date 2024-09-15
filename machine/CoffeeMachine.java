package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int storedWater = 400;
    static int storedMilk = 540;
    static int storedCoffeeBeans = 120;
    static int storedCups = 9;
    static int storedMoney = 550;
    static boolean exitFlag = true;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("Write action:");
            action(userInput.nextLine());
        } while (exitFlag);
    }

    // actions user's can perform
    public static void action(String userInput) {
        if (userInput.equalsIgnoreCase("BUY")) {
            buy();
        } else if (userInput.equalsIgnoreCase("FILL")) {
            fill();
        } else if (userInput.equalsIgnoreCase("TAKE")) {
            take();
        } else if (userInput.equalsIgnoreCase("REMAINING")) {
            remaining();
        } else if (userInput.equalsIgnoreCase("EXIT")) {
            exit();
        } else {
            System.out.println("Invalid Action");
        }
    }

    // buy, function with three options espresso, latte, or cappuccino
    public static void buy() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String drinkType = userInput.nextLine();

        if (drinkType.equalsIgnoreCase("BACK")) {
            System.out.println("Returning to main menu");
            return;
        }

        switch (drinkType) {
            case "1":
                makeCoffee(250, 0, 16, 4, "espresso");
                break;
            case "2":
                makeCoffee(350, 75, 20, 7, "latte");
                break;
            case "3":
                makeCoffee(200, 100, 12, 6, "cappuccino");
                break;
            default:
                System.out.println("Invalid input");
        }

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
    public static void remaining() {
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

    // calculates remaining resources in coffee machine
    public static void makeCoffee(int waterRequired, int milkRequired, int beansRequired, int price, String coffeeType) {
        if (!hasEnoughIngredients(waterRequired, milkRequired, beansRequired)) {
            return;
        }

        storedWater -= waterRequired;
        storedMilk -= milkRequired;
        storedCoffeeBeans -= beansRequired;
        storedCups -= 1;
        storedMoney += price;

        System.out.println("I have enough ingredients, making you a " + coffeeType + "!");
    }

    // checks requirements to make a coffee
    public static boolean hasEnoughIngredients(int waterRequired, int milkRequired, int beansRequired) {
        if (storedWater < waterRequired) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (storedMilk < milkRequired) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (storedCoffeeBeans < beansRequired) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (storedCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    // sets flag to exit the program
    public static void exit() {
        exitFlag = false;
    }
}

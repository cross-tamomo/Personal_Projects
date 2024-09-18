package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {

  private int waterStored = 400;
  private int milkStored = 540;
  private int coffeeBeansStored = 120;
  private int disposableCupsStored = 9;
  private int moneyStored = 550;
  private static boolean exitFlag = true;
  private final Scanner USER_INPUT = new Scanner(System.in);

  public CoffeeMachine() {
  }

  public CoffeeMachine(int waterStored, int milkStored, int coffeeBeansStored, int disposableCupsStored, int moneyStored) {
    this.waterStored = waterStored;
    this.milkStored = milkStored;
    this.coffeeBeansStored = coffeeBeansStored;
    this.disposableCupsStored = disposableCupsStored;
    this.moneyStored = moneyStored;
  }

  public void action() {
    while (exitFlag) {
      System.out.println("Write action (buy, fill, take, remaining, exit)");
      String userAction = USER_INPUT.nextLine().toUpperCase();

      switch (userAction) {
        case "BUY" -> buy();
        case "FILL" -> fill();
        case "TAKE" -> take();
        case "REMAINING" -> remaining();
        case "EXIT" -> exitFlag = false;
        default -> System.out.println("Invalid action. Please try again.");
      }
    }
  }

  public void buy() {
    System.out.println("""
                What do you want to buy?
                1 - espresso
                2 - latte
                3 - cappuccino
                back - to main menu""");

    String drinkMenu = USER_INPUT.nextLine();

    if (drinkMenu.equalsIgnoreCase("back")) {
      return;
    }

    CoffeeDrink coffeeDrink = switch (drinkMenu) {
      case "1" -> new CoffeeDrink("espresso", 250, 0, 16, 1, 14);
      case "2" -> new CoffeeDrink("latte", 350, 75, 20, 1, 7);
      case "3" -> new CoffeeDrink("cappuccino", 200, 100, 12, 1, 6);
      default -> {
        System.out.println("Invalid input. Please choose a valid option.");
        yield null;
      }
    };

    if (coffeeDrink != null && canMakeCoffee(coffeeDrink)) {
      makeCoffee(coffeeDrink);
    }
  }

  private boolean canMakeCoffee(CoffeeDrink coffeeDrink) {
    if (waterStored < coffeeDrink.getRequiredWater()) {
      System.out.println("Sorry, not enough water!");
      return false;
    }
    if (milkStored < coffeeDrink.getRequiredMilk()) {
      System.out.println("Sorry, not enough milk!");
      return false;
    }
    if (coffeeBeansStored < coffeeDrink.getRequiredCoffeeBeans()) {
      System.out.println("Sorry, not enough coffee beans!");
      return false;
    }
    if (disposableCupsStored < coffeeDrink.getRequiredDisposableCups()) {
      System.out.println("Sorry, not enough disposable cups!");
      return false;
    }
    return true;
  }

  private void makeCoffee(CoffeeDrink coffeeDrink) {
    waterStored -= coffeeDrink.getRequiredWater();
    milkStored -= coffeeDrink.getRequiredMilk();
    coffeeBeansStored -= coffeeDrink.getRequiredCoffeeBeans();
    disposableCupsStored -= coffeeDrink.getRequiredDisposableCups();
    moneyStored += coffeeDrink.getCoffeePrice();

    System.out.printf("I have enough ingredients to make you a %s!%n", coffeeDrink.getCoffeeType());
  }

  public void fill() {
    try {
      System.out.println("Write how many ml of water you want to add:");
      int fillWater = USER_INPUT.nextInt();
      waterStored += fillWater;

      System.out.println("Write how many ml of milk you want to add:");
      int fillMilk = USER_INPUT.nextInt();
      milkStored += fillMilk;

      System.out.println("Write how many grams of coffee beans you want to add:");
      int fillCoffeeBeans = USER_INPUT.nextInt();
      coffeeBeansStored += fillCoffeeBeans;

      System.out.println("Write how many disposable cups you want to add:");
      int fillCups = USER_INPUT.nextInt();
      disposableCupsStored += fillCups;

      USER_INPUT.nextLine(); // Consume newline
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please enter numeric values.");
      USER_INPUT.nextLine(); // Consume invalid input
    }
  }

  public void take() {
    System.out.println("I gave you $" + moneyStored);
    moneyStored = 0;
  }

  public void remaining() {
    System.out.printf("The coffee machine has:%n" +
            "%d ml of water%n" +
            "%d ml of milk%n" +
            "%d g of coffee beans%n" +
            "%d disposable cups%n" +
            "$%d of money%n",
        waterStored, milkStored, coffeeBeansStored, disposableCupsStored, moneyStored);
  }

  public int getWaterStored() {
    return waterStored;
  }

  public void setWaterStored(int waterStored) {
    this.waterStored = waterStored;
  }

  public int getMilkStored() {
    return milkStored;
  }

  public void setMilkStored(int milkStored) {
    this.milkStored = milkStored;
  }

  public int getCoffeeBeansStored() {
    return coffeeBeansStored;
  }

  public void setCoffeeBeansStored(int coffeeBeansStored) {
    this.coffeeBeansStored = coffeeBeansStored;
  }

  public int getDisposableCupsStored() {
    return disposableCupsStored;
  }

  public void setDisposableCupsStored(int disposableCupsStored) {
    this.disposableCupsStored = disposableCupsStored;
  }

  public int getMoneyStored() {
    return moneyStored;
  }

  public void setMoneyStored(int moneyStored) {
    this.moneyStored = moneyStored;
  }
}

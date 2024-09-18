package machine;

public class CoffeeDrink {

  private String coffeeType;
  private int requiredWater, requiredMilk, requiredCoffeeBeans, requiredDisposableCups, coffeePrice;


  public CoffeeDrink(String coffeeType, int requiredWater, int requiredMilk, int requiredCoffeeBeans, int requiredDisposableCups, int coffeePrice) {
    this.coffeeType = coffeeType;
    this.requiredWater = requiredWater;
    this.requiredMilk = requiredMilk;
    this.requiredCoffeeBeans = requiredCoffeeBeans;
    this.requiredDisposableCups = requiredDisposableCups;
    this.coffeePrice = coffeePrice;
  }

  public String getCoffeeType() {
    return coffeeType;
  }

  public void setCoffeeType(String coffeeType) {
    this.coffeeType = coffeeType;
  }

  public int getRequiredWater() {
    return requiredWater;
  }

  public void setRequiredWater(int requiredWater) {
    this.requiredWater = requiredWater;
  }

  public int getRequiredMilk() {
    return requiredMilk;
  }

  public void setRequiredMilk(int requiredMilk) {
    this.requiredMilk = requiredMilk;
  }

  public int getRequiredCoffeeBeans() {
    return requiredCoffeeBeans;
  }

  public void setRequiredCoffeeBeans(int requiredCoffeeBeans) {
    this.requiredCoffeeBeans = requiredCoffeeBeans;
  }

  public int getRequiredDisposableCups() {
    return requiredDisposableCups;
  }

  public void setRequiredDisposableCups(int requiredDisposableCups) {
    this.requiredDisposableCups = requiredDisposableCups;
  }

  public int getCoffeePrice() {
    return coffeePrice;
  }

  public void setCoffeePrice(int coffeePrice) {
    this.coffeePrice = coffeePrice;
  }

  @Override
  public String toString() {
    return String.format("CoffeeDrink{coffeeType='%s', requiredWater=%d, requiredMilk=%d, requiredCoffeeBeans=%d, requiredDisposableCups=%d, coffeePrice=%d}",
        coffeeType, requiredWater, requiredMilk, requiredCoffeeBeans, requiredDisposableCups, coffeePrice);
  }
}

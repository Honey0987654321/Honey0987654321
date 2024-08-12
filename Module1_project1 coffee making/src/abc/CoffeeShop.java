package abc;

//Coffee.java
interface Coffee {
 String getDescription();
 double cost();
}

//SimpleCoffee.java
class SimpleCoffee implements Coffee {

 @Override
 public String getDescription() {
     return "Simple Coffee";
 }

 @Override
 public double cost() {
     return 2.0; 
 }
}

//CoffeeDecorator.java
abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee;

 public CoffeeDecorator(Coffee coffee) {
     this.decoratedCoffee = coffee;
 }

 @Override
 public String getDescription() {
     return decoratedCoffee.getDescription();
 }

 @Override
 public double cost() {
     return decoratedCoffee.cost();
 }
}

//Milk.java
class Milk extends CoffeeDecorator {

 public Milk(Coffee coffee) {
     super(coffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", Milk";
 }

 @Override
 public double cost() {
     return super.cost() + 0.5; // cost of milk
 }
}

//Sugar.java
class Sugar extends CoffeeDecorator {

 public Sugar(Coffee coffee) {
     super(coffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", Sugar";
 }

 @Override
 public double cost() {
     return super.cost() + 0.2; // cost of sugar
 }
}

//Whip.java
class Whip extends CoffeeDecorator {

 public Whip(Coffee coffee) {
     super(coffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", Whip";
 }

 @Override
 public double cost() {
     return super.cost() + 0.7; // cost of whip
 }
}

//CoffeeShop.java
public class CoffeeShop {

 public static void main(String[] args) {
     Coffee coffee = new SimpleCoffee();
     System.out.println(coffee.getDescription() + " $" + coffee.cost());

     coffee = new Milk(coffee);
     System.out.println(coffee.getDescription() + " $" + coffee.cost());

     coffee = new Sugar(coffee);
     System.out.println(coffee.getDescription() + " $" + coffee.cost());

     coffee = new Whip(coffee);
     System.out.println(coffee.getDescription() + " $" + coffee.cost());
 }
} 

public class App {
    public static void main(String[] args) {
        CoffeeVendingMachine coffeeMachine = CoffeeVendingMachine.getInstance();

        // Display coffee menu
        coffeeMachine.displayMenu();

        // Simulate user requests
        Coffee espresso = coffeeMachine.selectCoffee(CoffeeType.ESPRESSO);
        coffeeMachine.dispenseCoffee(espresso, new Payment(3.0));

        Coffee cappuccino = coffeeMachine.selectCoffee(CoffeeType.CAPPUCCINO);
        coffeeMachine.dispenseCoffee(cappuccino, new Payment(3.5));


        Coffee latte = coffeeMachine.selectCoffee(CoffeeType.LATTE);
        coffeeMachine.dispenseCoffee(latte, new Payment(4.0));
    }
}

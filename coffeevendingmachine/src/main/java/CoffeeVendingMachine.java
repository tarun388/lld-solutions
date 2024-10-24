import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeVendingMachine {
    private static CoffeeVendingMachine instance;
    private final List<Coffee> menu;
    private final Map<String, Ingredient> ingredients;

    private CoffeeVendingMachine() {
        menu = new ArrayList<>();
        ingredients = new HashMap<>();
        initializeIngredient();
        initializeCoffee();
    }

    public static CoffeeVendingMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeVendingMachine();
        }
        return instance;
    }

    public void displayMenu() {
        for (Coffee coffee: menu) {
            System.out.println(coffee);
        }
    }

    public Coffee selectCoffee(CoffeeType type) {
        for (Coffee coffee: menu) {
            if (coffee.getCoffeeType().equals(type)) {
                return coffee;
            }
        }
        return null;
    }

    public void dispenseCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (hasEnoughIngredients(coffee)) {

            }
        }
        else {
            System.out.println("Insufficient balance");
        }
    }

    private void initializeCoffee() {
        // Add coffee types to the menu
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("Coffee"), 1);
        espressoRecipe.put(ingredients.get("Water"), 1);
        menu.add(new Coffee(CoffeeType.ESPRESSO, 2.5, espressoRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(ingredients.get("Coffee"), 1);
        cappuccinoRecipe.put(ingredients.get("Water"), 1);
        cappuccinoRecipe.put(ingredients.get("Milk"), 1);
        menu.add(new Coffee(CoffeeType.CAPPUCCINO, 3.5, cappuccinoRecipe));

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(ingredients.get("Coffee"), 1);
        latteRecipe.put(ingredients.get("Water"), 1);
        latteRecipe.put(ingredients.get("Milk"), 2);
        menu.add(new Coffee(CoffeeType.LATTE, 4.0, latteRecipe));
    }

    private void initializeIngredient() {
        ingredients.put("Coffee", new Ingredient("Coffee", 10));
        ingredients.put("Water", new Ingredient("Water", 10));
        ingredients.put("Milk", new Ingredient("Milk", 10));
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        return coffee.getRecipe().entrySet()
                .stream().anyMatch(entry -> entry.getKey().getQuantity() < entry.getValue());
    }

    private void updateIngredients(Coffee coffee) {
        coffee.getRecipe()
                .forEach((ingredient, quantity) -> {
                    ingredient.updateQuantity(-1 * quantity);
                });
    }

}

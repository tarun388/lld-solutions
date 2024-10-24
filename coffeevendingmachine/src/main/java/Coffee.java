import java.util.Map;

public class Coffee {
    private final CoffeeType coffeeType;
    private double price;
    private Map<Ingredient, Integer> recipe;

    public Coffee(CoffeeType coffeeType, double price, Map<Ingredient, Integer> recipe) {
        this.coffeeType = coffeeType;
        this.price = price;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Coffee: " + coffeeType + " Price: " + price;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public double getPrice() {
        return price;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}

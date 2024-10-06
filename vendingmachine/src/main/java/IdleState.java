public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.inventory.isAvailable(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product selected");
        }
        else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }
}

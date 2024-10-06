public class ReturnChange implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReturnChange(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: " + change);
            vendingMachine.resetPayment();
        }
        else {
            System.out.println("No change to return");
        }
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}

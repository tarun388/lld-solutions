public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please pay");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        checkPayment();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        checkPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please pay");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }

    private void checkPayment() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            System.out.println("Payment successful");
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
        else {
            System.out.println("Payment pending");
        }
    }
}

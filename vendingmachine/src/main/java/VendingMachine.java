import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private double totalPayment;
    private Product selectedProduct;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChange(this);
        currentState = idleState;
        totalPayment = 0.0;
        selectedProduct = null;
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    VendingMachineState getIdleState() {
        return idleState;
    }

    VendingMachineState getReadyState() {
        return readyState;
    }

    VendingMachineState getDispenseState() {
        return dispenseState;
    }

    VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void addNote(Note note) {
        totalPayment += note.getValue();
    }

    double getTotalPayment() {
        return totalPayment;
    }

    Product getSelectedProduct() {
        return selectedProduct;
    }

    void resetPayment() {
        totalPayment = 0.0;
    }

    void resetSelectedProduct() {
        selectedProduct = null;
    }

    void setSelectedProduct(Product product) {
        selectedProduct = product;
    }
}

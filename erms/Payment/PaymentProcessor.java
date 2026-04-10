package Payment;

public interface PaymentProcessor {
    public void calcBalance();
    public void generateReceipt(int _transID, String _details);
}

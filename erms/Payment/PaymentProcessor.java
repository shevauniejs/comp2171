package Payment;
import BasicData.Customer;
import BasicData.Job;

public interface PaymentProcessor {
    public void createPayment(Job job, Customer cus, double amountPaid);
    public void calcBalance(Job job, float amountPaid);
    public void generateReceipt(int _transID, String _details);
}

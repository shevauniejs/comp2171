package Payment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import BasicData.CreateTransaction;
import BasicData.Transaction;
import Data.DataMv;
import Data.TransactionRepo;

public class PaymentService implements PaymentProcessor, DataMv, CreateTransaction {
    private Transaction transaction;
    private TransactionRepo transRepo;
    private int jobId;
    private float cost, amountPaid;

    public PaymentService(int jobId, float cost, float amountPaid){
        this.jobId = jobId;
        transRepo = new TransactionRepo();
        createTransaction();
        calcBalance();
        writer();


        generateReceipt(transaction.getId(), "\t\t===========================BWOYZE+++ELECTRONICS=======================\n"+
                     "\n\t\t===========================96c MOLYNES ROAD (876-366-9211)=========================\n"+
                     transRepo.getTransaction(jobId)+
                     "\n\n\tTRANSACTION: "+transaction.getId()+
                     "\n\n\tDevices are held for a maximum of 30 days after technician notifies/calls you.\n"+
                     "\tFailure to retrieve after 30 days will incur a storage fee or device being sold."+
                     "\n\n\t\t\tThanks for doing business!");
    }

    public void calcBalance() {
        float balance = cost-amountPaid;
        transaction.setBalance(balance);
    }

    public void generateReceipt(int _transID, String _details){
        System.out.println("Generating receipt...");
        String userhome = System.getProperty("user.home");
        Path documentsPath = Paths.get(userhome, "Documents");
        Path filePath = documentsPath.resolve("receipt"+_transID+".txt");

        try {
            // 4. Write the content to the file.
            // This method creates the file if it doesn't exist and overwrites it if it does.
            Files.writeString(filePath, _details);
            
            System.out.println("File exported successfully!");
        } catch (IOException e) {
            System.err.println("Failed to write the file:");
            e.printStackTrace();
        }
    }

    @Override   
    public void writer() {
        transRepo.addTransaction(transaction);
        transRepo.addTransactionToJob(jobId, transaction.getId());
        System.out.println("Transaction Complete, ");
    }

    @Override
    public void createTransaction() {
        transaction = new Transaction(cost, amountPaid);
    }
}

package Payment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

import BasicData.Customer;
import BasicData.Job;
import BasicData.Transaction;

public class PaymentService implements PaymentProcessor {
    private Transaction transaction;
    static int idCounter = 400000000;

    public PaymentService(Job job, Customer cus, double amountPaid){
        createPayment(job, cus, amountPaid);        
    }

    public void calcBalance(Job job, float amountPaid) {
        transaction.setBalance(job.getCost()-amountPaid);
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


    private int calcId(){
        ThreadLocalRandom random =ThreadLocalRandom.current();
        int rand = random.nextInt(0+1,10000);
        return idCounter+rand;
    }

    public void createPayment(Job job, Customer cus, double amountPaid) {
        transaction = new Transaction(job);
        transaction.setTransId(calcId());
        generateReceipt(transaction.getTransId(), "\t\t===========================BWOYZE+++ELECTRONICS=======================\n"+
                     "\n\t\t===========================96c MOLYNES ROAD (876-366-9211)=========================\n"+
                     "\n\n\tCUSTOMER NAME: "+cus.getName()+"\tNUMBER: "+cus.getNumber()+"\tEMAIL: "+cus.getEmail()+
                     "\n\n\tDEVICE:"+
                     "\n\tBRAND/MODEL: "+job.getDevice().getBrand()+"\tDATE: "+ transaction.getDate().toString()+
                     "\n\n\tDEVICE ISSUE: "+job.getDiagnosis()+
                     "\n\n\tDEVICE LOCATION IN STORE: "+ job.getLocation()+
                     "\n\n\tCost: $"+job.getCost()+"\n\tAMOUNT PAID: $"+amountPaid+"\n\tBALANCE: $"+transaction.getBalance()+
                     "\n\n\tTRANSACTION: "+transaction.getTransId()+
                     "\n\n\tDevices are held for a maximum of 30 days after technician notifies/calls you.\n"+
                     "\tFailure to retrieve after 30 days will incur a storage fee or device being sold."+
                     "\n\n\t\t\tThanks for doing business!");
    }    
}

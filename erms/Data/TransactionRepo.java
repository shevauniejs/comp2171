package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import BasicData.Transaction;

public class TransactionRepo {
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static Transaction t;
    private String transaction;
    
    public void addTransaction(Transaction transaction){
        String sql = "INSERT INTO Transactions (id, date, cost, paid, balance) VALUES (?,?,?,?,?,)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, transaction.getId());
                stmt.setDate(2, Date.valueOf(transaction.getDate()));
                stmt.setFloat(3, transaction.getCost());
                stmt.setFloat(4, transaction.getPaid());
                stmt.setFloat(5, transaction.getBalance()); 
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }
 
    private void getTransactionFromDb(int transactionId){
        String sql = "SELECT t.date, t.cost, t.paid, t.balance, j.brand, j.description, j.diagnosis, c.name, c.email, c.number FROM Transactions t"+
        "LEFT JOIN Job j ON j.id = t.job_id"+
        "LEFT JOIN Customer c ON c.job_id = j.id"+
        "WHERE t.id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    transaction = rs.getString("date")+""+rs.getString("name")+" "+rs.getString("email")+rs.getString("number")+"\n"+
                    rs.getString("brand")+"\n"+rs.getString("description")+"\n"+rs.getString("diagnosis")+"\n"+
                    "Cost: "+rs.getFloat("Cost")+" Paid: "+rs.getFloat("paid")+" Balance: "+rs.getString("balance");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }    

    public void addTransactionToJob(int jobId, int transactionId){
        String sql = "UPDATE Job SET transaction_id = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, transactionId);
                stmt.setInt(2, jobId);
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }
    private void loadtransactions() throws SQLException{
        System.out.println("Load transactions");
        String sql = "SELECT id, date, cost, paid, balance FROM transaction";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    t = new Transaction(rs.getInt("id"),rs.getDate("date").toLocalDate(),
                    rs.getFloat("cost"),rs.getFloat("paid"),rs.getFloat("balance"));
                    transactions.add(t);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transaction> gettransactions(){
        System.out.println("Get transaction");
        try {
            loadtransactions();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return transactions;
    }

    public String getTransaction(int transId){
        getTransactionFromDb(transId);
        return transaction;
    }
    
}

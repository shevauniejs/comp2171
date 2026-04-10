package Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BasicData.Customer;

public  class CustomerRepo {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static Customer customer;

    public CustomerRepo(){};
    
    public static void addCustomer(Customer cs){
        String sql = "INSERT INTO Customer (id, name, email, number) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, cs.getId());
                stmt.setString(2, cs.getName());
                stmt.setString(3,cs.getEmail());
                stmt.setString(4, cs.getNumber()); 
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }

    private static void getCustomerFromDb(int customerId){
        String sql = "SELECT id = ? name, email, number FROM Customer";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    customer = new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("number"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    private void loadAllCustomers() throws SQLException{
        System.out.println("Load customers");
        String sql = "SELECT id, name, email, number FROM Customer";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    Customer c = new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("number"));
                    customers.add(c);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getAllCustomers(){
        System.out.println("Get customer");
        try {
            loadAllCustomers();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return customers;
    }

    public static Customer getCustomer(int customerId){
        getCustomerFromDb(customerId);
        return customer;
    }
}

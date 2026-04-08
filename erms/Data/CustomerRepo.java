package Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BasicData.Customer;

public class CustomerRepo {
    public void addCustomer(Customer cs){
        String sql = "INSERT INTO Customer (id, name, email, number) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(0, cs.getId());
                stmt.setString(1, cs.getName());
                stmt.setString(2,cs.getEmail());
                stmt.setString(3, cs.getNumber()); 
            } catch(SQLException e){
                e.printStackTrace();
            }
    }    
}

package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BasicData.Device;

public class DeviceRepo {
    public void addDevice(Device dev){
        String sql = "INSERT INTO Device (id,brand, model, description) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, dev.getId());
                stmt.setString(2, dev.getBrand());
                stmt.setString(3, dev.getModel());
                stmt.setString(4, dev.getDescription()); 
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }
}

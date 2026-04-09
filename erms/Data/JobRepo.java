package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BasicData.Job;

public class JobRepo {
    public void addJob(Job job){
        String sql = "INSERT INTO Job (id, device_id, diagnosis, notes, status, location) VALUES (?,?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, job.getId());
                stmt.setInt(2, job.getDevice().getId());
                stmt.setString(3, job.getDiagnosis());
                stmt.setString(4, job.getNotes()); 
                stmt.setString(5, job.getStatus());
                stmt.setString(6, job.getLocation());
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }
    
}

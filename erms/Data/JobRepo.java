package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BasicData.Job;

public class JobRepo {
    private static ArrayList<Job> jobs = new ArrayList<Job>();
    
    public void addJob(Job job){
        String sql = "INSERT INTO Job (id, brand, description, diagnosis, notes, status, location) VALUES (?,?,?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, job.getId());
                stmt.setString(2, job.getBrand());
                stmt.setString(3, job.getDescription());
                stmt.setString(4, job.getDiagnosis());
                stmt.setString(5, job.getNotes()); 
                stmt.setString(6, job.getStatus());
                stmt.setString(7, job.getLocation());
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }

    public void addJobToCustomer(int customerId, int jobId){
        String sql = "UPDATE Customer SET job_id = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setInt(1, jobId);
                stmt.setInt(2, customerId);
                stmt.executeUpdate();
            } catch(SQLException e){
                e.printStackTrace();
            }
    }
    private void loadJobs() throws SQLException{
        System.out.println("Load Jobs");
        String sql = "SELECT id, brand, description, diagnosis, notes, status, location FROM Job";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    Job j = new Job(rs.getInt("id"),rs.getString("brand"),rs.getString("description"),rs.getString("diagnosis"),rs.getString("notes"), rs.getString("status"), rs.getString("location"));
                    jobs.add(j);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Job> getJobs(){
        System.out.println("Get job");
        try {
            loadJobs();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jobs;
    }
    
}

package Job;
import BasicData.Job;
import java.util.ArrayList;

public interface JobProcessor{
    public void updateLocation(Job job, String location);
    public void updateStatus(Job job, String Status);
    public void filter(ArrayList<Job> Jobs, String param);
}

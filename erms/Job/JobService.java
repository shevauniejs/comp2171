package Job;
import java.util.ArrayList;
import BasicData.Job;

public class JobService implements JobProcessor{
    public void updateLocation(Job job, String location) {
        job.setLocation(location);
    }

    public void updateStatus(Job job, String status) {
        job.setStatus(status);
    }

    public void filter(ArrayList<Job> Jobs, String param) {
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }
}

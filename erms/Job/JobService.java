package Job;
import java.util.ArrayList;

import BasicData.Customer;
import BasicData.Device;
import BasicData.Job;

public class JobService implements JobProcessor{
    public Job createJob(Customer cs, Device dev){
        Job job = new Job(dev);
        return job;
    }

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

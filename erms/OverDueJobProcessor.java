import java.util.ArrayList;
import BasicData.Job;

public interface OverDueJobProcessor{
    public void alertTech();
    public void getOverDueDevices(ArrayList<Job> Jobs);
}

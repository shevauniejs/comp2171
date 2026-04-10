package BasicData;

import java.util.concurrent.ThreadLocalRandom;

public abstract class BasicData {
    protected int idC;
    protected int id;

    public BasicData(){};

    public BasicData(int idStarter){
        idC=idStarter;
        id = calcId();
    };
    

    protected int calcId(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int rand = random.nextInt(0+1, 10000);
        return idC+ rand;
    }

    public int getId(){
        return id;
    }
}

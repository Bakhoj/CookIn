package data;

/**
 * Created by anders on 03-03-2016.
 */
public class Data {
    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
    }
}

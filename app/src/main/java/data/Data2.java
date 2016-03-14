package data;

/**
 * Created by anders on 03-03-2016.
 */
public class Data2 {
    private static Data2 ourInstance = new Data2();

    public static Data2 getInstance() {
        return ourInstance;
    }

    private Data2() {
    }
}

package data;

/**
 * Created by anders on 03-03-2016.
 */
public class data {
    private static data ourInstance = new data();

    public static data getInstance() {
        return ourInstance;
    }

    private data() {
    }
}

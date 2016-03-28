package dinners;

/**
 * Created by anders on 20-Mar-16.
 */
public class DinnerChild {

    private String mDescription, mTime;

    public DinnerChild(String description, String time) {
        mDescription = description;
        mTime = time;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getTime(){
        return mTime;
    }
}

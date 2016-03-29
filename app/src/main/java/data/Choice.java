package data;

import java.util.Date;

/**
 * Created by anders on 20-Mar-16.
 */
public class Choice {

    public int recyclerExpandedPosition;
    public Date startDate, endDate, deadlineDate;       //The last chosen dates for create host

    public Choice() {
        recyclerExpandedPosition  = -1;
    }
}

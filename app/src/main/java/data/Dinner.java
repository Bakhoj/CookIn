package data;

import java.util.Date;

/**
 * Created by anders on 13-03-2016.
 */
public class Dinner {
    public String title, description;
    public Profil host;
    public Profil[] guests, guestRequests;
    public Date deadline, startTime;
    public int numGuest, price, specialFood;

    public Dinner() {
    }
}

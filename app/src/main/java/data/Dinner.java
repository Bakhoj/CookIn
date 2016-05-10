package data;

import java.util.Date;
import java.util.List;

/**
 * Created by anders on 13-03-2016.
 */
public class Dinner {
    public Profil hostProfil;       //Profil of this.host

    public String title;            //Title of the dinner
    public String description;      //Description of the dinner

    public double pricetag;         //Price for participating the dinner             64-bit
    public int numGuest;            //Max number of guest the dinner can host           32-bit
    //public short specialFood;       //Special foods, 0 = omni, 1 = vegetar, 2 = veganer 32-bit

    public Date startDate;          //Start time for Dinner
    public Date endDate;            //End time for Dinner
    public Date deadlineDate;       //Deadline for guest payment and request

    public List<Profil> guests;     //List og guest's profils



    public Dinner(Profil hostProfil, String title, String description, double pricetag, int numGuest, short specialFood, Date startDate, Date endDate, Date deadlineDate, List<Profil> guests) {
        this.hostProfil = hostProfil;
        this.title = title;
        this.description = description;
        this.pricetag = pricetag;
        this.numGuest = numGuest;
       // this.specialFood = specialFood;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadlineDate = deadlineDate;
        this.guests = guests;
    }
}

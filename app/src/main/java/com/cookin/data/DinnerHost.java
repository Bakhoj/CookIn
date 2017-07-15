package com.cookin.data;

import java.util.Date;
import java.util.List;


/**
 * Created by anders on 21-Mar-16.
 */
public class DinnerHost extends Dinner{



    public List<Profil> guestRequests;      //List og guests that whishes to join the dinner

    public DinnerHost(Profil host, String title, String description, double pricetag, int numGuest, short specialFood, Date startDate, Date endDate, Date deadlineDate, List<Profil> guests) {
        super(host, title, description, pricetag, numGuest, specialFood, startDate, endDate, deadlineDate, guests);
    }
}

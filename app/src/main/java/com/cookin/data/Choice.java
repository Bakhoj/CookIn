package com.cookin.data;

import android.app.Activity;

import java.util.Date;

/**
 * Created by anders on 20-Mar-16.
 */
public class Choice {

    public int recyclerExpandedPosition;
    public int hostPosition;
    private String title;
    private String description;
    private int guest;
    private int price;
    private Date startDate;
    private Date deadlineDate;
    private Activity mainAct;

    public Choice() {
        recyclerExpandedPosition  = -1;
        hostPosition = 1;
        title = "";
        description = "";
        guest = 1;
        price = 1;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getGuest() {
        return guest;
    }

    public int getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public Activity getMainAct() { return mainAct; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setMainAct(Activity activity) { this.mainAct = activity; }
}

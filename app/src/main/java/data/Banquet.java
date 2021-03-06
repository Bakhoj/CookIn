package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anders on 10-May-16.
 */
public class Banquet {

    private String dinnerId, hostId, title, description;
    private double pricetag;
    private int maxGuest;
    private List<String> guests;
    private Date startDate, deadlineDate;
    private String address;

    public Banquet() {
        this.guests = new ArrayList<>();
    }

    public String getDinnerId() {
        return dinnerId;
    }

    public void setDinnerId(String dinnerId) {
        if(this.dinnerId == null) {
            this.dinnerId = dinnerId;
        } else if (dinnerId == null){
            this.dinnerId = null;
        }

        this.dinnerId = dinnerId;   //remove later
    }

    public String getAddress() {
        if(address == null) {
            //TODO remove this test data state
            return "666";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricetag() {
        return pricetag;
    }

    public void setPricetag(double pricetag) {
        this.pricetag = pricetag;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }

    public void addGuest(String guest) {
         if(guests.size() < maxGuest){
            this.guests.add(guest);
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }


    @Override
    public String toString() {
        return "Banquet{" +
                "dinnerId='" + dinnerId + '\'' +
                ", hostId='" + hostId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pricetag=" + pricetag +
                ", maxGuest=" + maxGuest +
                ", guests=" + guests +
                ", startDate=" + startDate +
                ", deadlineDate=" + deadlineDate +
                '}';
    }
}

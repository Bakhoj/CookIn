package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anders on 21-Mar-16.
 */
public class Host {
    public String title, address, description;
    public int pricetag, photoId;

    public Host(String title, String address, int pricetag) {
        this.title = title;
        this.address = address;
        this.pricetag = pricetag;
    }

    public List<Host> hosts;

    public void initializeData() {
        hosts = new ArrayList<>();
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title3", "4600 Køge", 75));
    }
}

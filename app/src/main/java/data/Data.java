package data;

import java.util.ArrayList;
import java.util.List;

import dinners.*;
import dinners.Dinner;

/**
 * Created by anders on 03-03-2016.
 */
public class Data {
    public static Data ourInstance = new Data();

    public Choice choice;
    public String[] mTitle, mDescription, mTime;
    public int[] mPricetag;
    public List<Host> hosts;


    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        choice = new Choice();

        mTitle = new String[]{"Title1", "Title2", "Title3", "Title4", "Title5", "Title6", "Title7", "Title8", "Title9", "Title10", "Title11", "Title12"};
        mDescription = new String[]{"Description1", "Description2", "Description3", "Description4", "Description5", "Description6", "Description7", "Description8", "Description9", "Description10", "Description11", "Description12"};
        mTime = new String[]{"Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30"};
        mPricetag = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

        hosts = new ArrayList<>();
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title3", "4600 Køge", 75));
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title3", "4600 Køge", 75));
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title3", "4600 Køge", 75));
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title3", "4600 Køge", 75));
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title3", "4600 Køge", 75));
        hosts.add(new Host("Title2", "4660 Store H.", 20));
        hosts.add(new Host("Title1", "2800 Lyngby", 50));
        hosts.add(new Host("Title3", "4600 Køge", 75));
    }
}

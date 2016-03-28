package dinners;


import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anders on 20-Mar-16.
 * TODO: igang med at læse http://bignerdranch.github.io/expandable-recycler-view/
 *  måske skift over til denne recycler view: https://github.com/h6ah4i/android-advancedrecyclerview
 *  Måske lege med noget Cardview og RecyclerView: http://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465
 */
public class Dinner implements ParentListItem{

    private List<Object> mChildrenList;
    private String mTitle, mAddress;
    private int mPricetag;

    private List mDinners;

    static String[]mDataset = {"Dinner Dinner Chicken Winner", "Bob's mad forretning", "Title3", "Title4", "Title5", "Title6", "Title7", "Title8", "Title9", "Title10", "Title11", "Title12"};
    static int[]mPricetagData = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

    /*public static List<Dinner> getDinners() {

        List<Dinner> dinners = new ArrayList<>();
        for (int i = 0; i < mDataset.length; i++) {
            dinners.add(new Dinner(mDataset[i], "2800 Lyngby", 50));
        }
        return dinners;
    } */
/*
    @Override
    public List<Object> getChildObjectList() {
        return mChildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mChildrenList = list;
    }
*/
    public Dinner(String title, String address, int pricetag, List<DinnerChild> dinners) {
        mTitle = title;
        mAddress = address;
        mPricetag = pricetag;
        mDinners = dinners;
    }

    public Dinner(List dinners) {

    }

    public String getTitle() {
        return mTitle;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getPricetag() {
        return mPricetag;
    }

    @Override
    public List getChildItemList() {
        return mDinners;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}

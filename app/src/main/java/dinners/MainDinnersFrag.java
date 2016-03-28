package dinners;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anders.cookin.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainDinnersFrag extends Fragment {

    RecyclerView mRecyclerView;
    DinnerViewAdapter mDinnerViewAdapter;
    public RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dinners_main_frag, container, false);

        DinnerChild dinnerChild1 = new DinnerChild("Description", "Monday 19:30-20:00");
        DinnerChild dinnerChild2 = new DinnerChild("Description", "Monday 19:30-20:00");
        DinnerChild dinnerChild3 = new DinnerChild("Description", "Monday 19:30-20:00");
        DinnerChild dinnerChild4 = new DinnerChild("Description", "Monday 19:30-20:00");

        Dinner dinner1 = new Dinner("Title", "2800 Lyngby", 50, Arrays.asList(dinnerChild1));
        Dinner dinner2 = new Dinner("Title", "2800 Lyngby", 50, Arrays.asList(dinnerChild1, dinnerChild2));
        Dinner dinner3 = new Dinner("Title", "2800 Lyngby", 50, Arrays.asList(dinnerChild1, dinnerChild2));
        Dinner dinner4 = new Dinner("Title", "2800 Lyngby", 50, Arrays.asList(dinnerChild1, dinnerChild2));

        //List<Dinner> dinners = Arrays.asList(dinner1, dinner2, dinner3, dinner4);

        List<Dinner> dinners = new ArrayList<>();
        dinners.add(dinner1);
        dinners.add(dinner2);
        dinners.add(dinner3);
        dinners.add(dinner4);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dinners_list);

        mLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDinnerViewAdapter = new DinnerViewAdapter(getActivity(), dinners);

        mRecyclerView.setAdapter(mDinnerViewAdapter);

        return rootView;
    }
/*
    private ArrayList<ParentObject> generateDinners() {
        List<Dinner> dinners = Data.ourInstance.getDinners();
        ArrayList<ParentObject> parentObjects  = new ArrayList<>();
        for (Dinner dinner : dinners) {
            ArrayList<Object> childList = new ArrayList<>();
            childList.add(new DinnerChild(dinner.getDescription(), dinner.getTime()));
            dinner.setChildObjectList(childList);
            parentObjects.add(dinner);
        }
        return parentObjects;
    } */

    /*
    private ArrayList<ParentListItem> generateDinners() {

        List<Dinner> dinners = Dinner.getDinners();
        ArrayList<ParentListItem> parentObjects = new ArrayList<>();

        for(Dinner dinner: dinners) {
            ArrayList<Object> childList = new ArrayList<>();
            childList.add(new DinnerChild("Description", "Time"));
            parentObjects.add(dinner);
        }

        return parentObjects;
    }
    */
}
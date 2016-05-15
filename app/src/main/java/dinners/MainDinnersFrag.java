package dinners;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookin.app.R;
import com.facebook.Profile;

import data.Data;
import data.FireBHandler;


public class MainDinnersFrag extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    GridLayoutManager mGridLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dinners_main_frag, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dinners_list);

        //mLinearLayoutManager = new LinearLayoutManager(getContext());
        mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        
        DinnerViewAdapter adapter = new DinnerViewAdapter(Data.getInstance().banquets);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

}
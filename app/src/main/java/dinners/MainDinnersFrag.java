package dinners;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anders.cookin.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.Data;


public class MainDinnersFrag extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dinners_main_frag, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dinners_list);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        
        DinnerViewAdapter adapter = new DinnerViewAdapter(Data.ourInstance.dinners);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

}
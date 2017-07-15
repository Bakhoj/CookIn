package com.cookin.requests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookin.app.R;

import com.cookin.data.Data;

public class MainPendingRequestFrag extends Fragment {

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pending_request_main_frag, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.pending_request_list);

        mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        PendingRequestViewAdapter adapter = new PendingRequestViewAdapter(Data.getInstance().banquets);
        mRecyclerView.setAdapter(adapter);

        getFragmentManager().beginTransaction();
        return rootView;
    }
}

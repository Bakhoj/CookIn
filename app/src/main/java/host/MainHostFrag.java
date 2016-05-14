package host;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookin.app.R;

import data.Data;
import host.create.HostCreateDinner;

public class MainHostFrag extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    GridLayoutManager mGridLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.host_main_frag, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.getContext(), HostCreateDinner.class);
                startActivity(i);

            }
        });



        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.hosts_list);

        //mLinearLayoutManager = new LinearLayoutManager(getContext());
        //mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        HostViewAdapter adapter = new HostViewAdapter(Data.ourInstance.dinnerHosts);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
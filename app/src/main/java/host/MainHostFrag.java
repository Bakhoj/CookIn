package host;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anders.cookin.R;

import data.Data;

public class MainHostFrag extends Fragment {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "You pressed the Create host button", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.host_main_frag, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.hosts_list);

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        HostViewAdapter adapter = new HostViewAdapter(Data.ourInstance.dinnerHosts);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
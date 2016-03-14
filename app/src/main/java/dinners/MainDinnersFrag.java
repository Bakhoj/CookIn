package dinners;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anders.cookin.R;

public class MainDinnersFrag extends Fragment {

    TextView mTextView;
    RecyclerView mRecyclerView;
    DinnerViewAdapter mDinnerViewAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dinners_main_frag, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dinners_list);
        //set True for improved performance
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDinnerViewAdapter = new DinnerViewAdapter();
        mRecyclerView.setAdapter(mDinnerViewAdapter);

        return rootView;
    }

}

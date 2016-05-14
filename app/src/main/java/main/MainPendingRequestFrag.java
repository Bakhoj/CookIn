package main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookin.app.R;

public class MainPendingRequestFrag extends Fragment {

    TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pending_request_main_frag, container, false);

        mTextView = (TextView) rootView.findViewById(R.id.pending_request_frag_text);
        mTextView.setText("Hello Pending Request fragment, this is dog");

        return rootView;
    }
}

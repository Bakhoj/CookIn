package dinners;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anders.cookin.R;

public class MainDinnersFrag extends Fragment {

    TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dinners_main_frag, container, false);

        mTextView = (TextView) rootView.findViewById(R.id.dinners_frag_text);
        mTextView.setText("Hello Dinners fragment, this is dog");

        return rootView;
    }

}

package host.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.ScrollView;

import com.example.anders.cookin.R;

public class CreateFirstFrag extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_first_frag, container, false);

        rootView.findViewById(R.id.titleCreate).requestFocus();

        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.numberPickerGuests);
        np.setMaxValue(50);
        np.setMinValue(1);
        np.setValue(1);
        np.setWrapSelectorWheel(true);


        return rootView;
    }

}

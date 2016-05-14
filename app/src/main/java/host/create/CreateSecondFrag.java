package host.create;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.cookin.app.R;

public class CreateSecondFrag extends Fragment {

    long a = 31470526000l; // 364 days
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_second_frag, container, false);

        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.numberPickerPrice);
        np.setMinValue(1);
        np.setMaxValue(1000000);
        np.setWrapSelectorWheel(false);

        DatePicker dp = (DatePicker) rootView.findViewById(R.id.datePickerStart);
        dp.setMinDate(System.currentTimeMillis() - 1000);
        dp.setMaxDate(System.currentTimeMillis() + a);
        dp.setCalendarViewShown(false);
        dp.findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);

        dp = (DatePicker) rootView.findViewById(R.id.datePickerDeadline);
        dp.setMinDate(System.currentTimeMillis() - 1000);
        dp.setCalendarViewShown(false);
        dp.findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);

        TimePicker tp = (TimePicker) rootView.findViewById(R.id.timePickerStart);
        tp.setIs24HourView(true);

        tp = (TimePicker) rootView.findViewById(R.id.timePickerDeadline);
        tp.setIs24HourView(true);

        return rootView;
    }

}
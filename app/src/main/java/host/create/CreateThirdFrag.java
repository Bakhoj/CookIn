package host.create;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.cookin.app.R;

import java.util.Calendar;
import java.util.Date;

import data.Data;


public class CreateThirdFrag extends Fragment {

    long a = 31470526000l; // 364 days

    DatePicker dpStart;
    DatePicker dpDeadline;
    TimePicker tpStart;
    TimePicker tpDeadline;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_third_frag, container, false);

        dpStart = (DatePicker) rootView.findViewById(R.id.datePickerStart);
        dpStart.setMinDate(System.currentTimeMillis() - 1000);
        dpStart.setMaxDate(System.currentTimeMillis() + a);
        dpStart.setCalendarViewShown(false);
        dpStart.findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);

        tpStart = (TimePicker) rootView.findViewById(R.id.timePickerStart);
        tpStart.setIs24HourView(true);

        dpDeadline = (DatePicker) rootView.findViewById(R.id.datePickerDeadline);
        dpDeadline.setMinDate(System.currentTimeMillis() - 1000);
        dpDeadline.setCalendarViewShown(false);
        dpDeadline.findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);

        tpDeadline = (TimePicker) rootView.findViewById(R.id.timePickerDeadline);
        tpDeadline.setIs24HourView(true);


        return rootView;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void updateChoice() {
        Calendar calendar = Calendar.getInstance();
        long timeStart;
        long timeDeadline;

        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
            calendar.set(dpStart.getYear(), dpStart.getMonth(), dpStart.getDayOfMonth(),
                    tpStart.getHour(), tpStart.getMinute(), 0);
            timeStart = calendar.getTimeInMillis();
            calendar.set(dpDeadline.getYear(), dpDeadline.getMonth(), dpDeadline.getDayOfMonth(),
                    tpDeadline.getHour(), tpDeadline.getMinute(), 0);
            timeDeadline = calendar.getTimeInMillis();
        } else {
            calendar.set(dpStart.getYear(), dpStart.getMonth(), dpStart.getDayOfMonth(),
                    tpStart.getCurrentHour(), tpStart.getCurrentMinute(), 0);
            timeStart = calendar.getTimeInMillis();
            calendar.set(dpDeadline.getYear(), dpDeadline.getMonth(), dpDeadline.getDayOfMonth(),
                    tpDeadline.getCurrentHour(), tpDeadline.getCurrentMinute(), 0);
            timeDeadline = calendar.getTimeInMillis();
        }
        Data.getInstance().choice.setStartDate(new Date(timeStart));
        Data.getInstance().choice.setDeadlineDate(new Date(timeDeadline));
    }

}

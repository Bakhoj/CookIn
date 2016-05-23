package host.create;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.cookin.app.R;

import java.util.Calendar;
import java.util.Date;

import data.Data;

public class CreateSecondFrag extends Fragment {

    NumberPicker npPrice;
    NumberPicker npGuest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_second_frag, container, false);

        npPrice = (NumberPicker) rootView.findViewById(R.id.numberPickerPrice);
        npPrice.setMinValue(1);
        npPrice.setMaxValue(1000000);
        npPrice.setWrapSelectorWheel(false);

        npGuest = (NumberPicker) rootView.findViewById(R.id.numberPickerGuests);
        npGuest.setMaxValue(50);
        npGuest.setMinValue(1);
        npGuest.setValue(Data.getInstance().choice.getGuest());
        npGuest.setWrapSelectorWheel(true);


        return rootView;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void updateChoice() {
        Data.getInstance().choice.setPrice(npPrice.getValue());
        Data.getInstance().choice.setGuest(npGuest.getValue());
        }

}
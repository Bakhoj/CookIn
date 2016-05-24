package host.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ScrollView;

import com.cookin.app.R;

import data.Data;

public class CreateFirstFrag extends Fragment {

    EditText etTitle;
    EditText etDescription;

    public CreateFirstFrag(){
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_first_frag, container, false);

        rootView.findViewById(R.id.titleCreate).requestFocus();

        etTitle = (EditText) rootView.findViewById(R.id.titleCreate);
        etTitle.setText(Data.getInstance().choice.getTitle());

        etDescription = (EditText) rootView.findViewById(R.id.descriptionCreate);
        etDescription.setText(Data.getInstance().choice.getDescription());

        return rootView;
    }

    public void updateChoice(){
        Data.getInstance().choice.setTitle(etTitle.getText().toString().trim());
        Data.getInstance().choice.setDescription(etDescription.getText().toString().trim());
    }

}

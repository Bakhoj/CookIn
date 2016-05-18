package host.create;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import data.Banquet;
import data.Data;
import data.FireBHandler;
import data.Profil;

public class CreateOverviewFrag extends Fragment{

    TextView tvTitle, tvDescripiton, tvGuests, tvPrice;
    ProfilePictureView profilePic;
    Button btnCreate;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.create_overview_frag, container, false);

        tvTitle = (TextView) rootview.findViewById(R.id.titleOverview);
        tvDescripiton = (TextView) rootview.findViewById(R.id.descriptionOverview);
        tvGuests = (TextView) rootview.findViewById(R.id.guestsOverview);
        tvPrice = (TextView) rootview.findViewById(R.id.priceOverview);
        profilePic = (ProfilePictureView) rootview.findViewById(R.id.host_profil_pic);

        tvTitle.setText(Data.getInstance().choice.getTitle());
        tvDescripiton.setText(Data.getInstance().choice.getDescription());
        tvGuests.setText(String.valueOf(Data.getInstance().choice.getGuest()));
        tvPrice.setText(String.valueOf(Data.getInstance().choice.getPrice()));

        btnCreate = (Button) rootview.findViewById(R.id.buttonOverview);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Banquet banquet = new Banquet();
                banquet.setTitle(Data.getInstance().choice.getTitle());
                banquet.setDescription(Data.getInstance().choice.getDescription());
                banquet.setMaxGuest(Data.getInstance().choice.getGuest());
                banquet.setPricetag(Data.getInstance().choice.getPrice());
                banquet.setStartDate(Data.getInstance().choice.getStartDate());
                banquet.setDeadlineDate(Data.getInstance().choice.getDeadlineDate());
                FireBHandler.getInstance().uploadDinner(banquet);
                getActivity().finish();
            }
        });



        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public void updateChoice(){
        System.out.println(Data.getInstance().choice.getTitle());
        tvTitle.setText(Data.getInstance().choice.getTitle());
        tvDescripiton.setText(Data.getInstance().choice.getDescription());
        tvGuests.setText(String.valueOf(Data.getInstance().choice.getGuest()));
        tvPrice.setText(String.valueOf(Data.getInstance().choice.getPrice()));
    }


}

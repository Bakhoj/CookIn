package dinners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import data.Choice;
import data.Data;

public class DinnerViewDetailed extends AppCompatActivity {

    TextView mDescription, mTitle, mPricetag, mAddress;
    ProfilePictureView mProfilepic;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinners_viewholder_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        position = Data.getInstance().choice.hostPosition;

        mDescription = (TextView) findViewById(R.id.dinner_viewholder_description);
        mTitle = (TextView) findViewById(R.id.dinner_viewholder_title);
        mProfilepic = (ProfilePictureView) findViewById(R.id.dinner_profil_pic);
        mPricetag = (TextView) findViewById(R.id.dinner_viewholder_pricetag);
        mAddress = (TextView) findViewById(R.id.dinner_viewholder_address);

        //mDescription.setText("Hej Description");
        /* mDescription.setText(Data.getInstance().dinnerHosts.get(Data.getInstance().choice.hostPosition).description);
        mTitle.setText(Data.ourInstance.dinnerHosts.get(Data.ourInstance.choice.hostPosition).title);
        mProfilepic.setProfileId(Profile.getCurrentProfile().getId()); */

        mDescription.setText(Data.getInstance().banquets.get(position).getDescription());
        mTitle.setText(Data.getInstance().banquets.get(position).getTitle());
        mProfilepic.setProfileId(Data.getInstance().banquets.get(position).getHostId());
        mPricetag.setText(Data.getInstance().banquets.get(position).getPricetag() + ",- kr");
        mAddress.setText("Postnr.:" + Data.getInstance().banquets.get(position).getAddress());
    }

}
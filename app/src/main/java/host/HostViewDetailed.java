package host;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import data.Data;

public class HostViewDetailed extends AppCompatActivity {

    TextView mDescription, mTitle, mPricetag, mAddress;
    ProfilePictureView mProfilepic;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_viewholder_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        position = Data.getInstance().choice.hostPosition;

        mDescription = (TextView) findViewById(R.id.host_viewholder_description);
        mTitle = (TextView) findViewById(R.id.host_viewholder_title);
        mProfilepic = (ProfilePictureView) findViewById(R.id.host_profil_pic);
        mPricetag = (TextView) findViewById(R.id.host_viewholder_pricetag);
        mAddress = (TextView) findViewById(R.id.host_viewholder_address);

        mDescription.setText(Data.getInstance().hostBanquets.get(position).getDescription());
        mTitle.setText(Data.getInstance().hostBanquets.get(position).getTitle());
        mProfilepic.setProfileId(Profile.getCurrentProfile().getId());
        mPricetag.setText((Data.getInstance().hostBanquets.get(position).getPricetag()) + ",- kr");
        mAddress.setText("Postnr.: " + Data.getInstance().hostBanquets.get(position).getAddress());
    }

}
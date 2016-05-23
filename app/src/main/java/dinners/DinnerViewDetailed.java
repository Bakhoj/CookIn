package dinners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import data.Choice;
import data.Data;
import main.MainAct;

public class DinnerViewDetailed extends Fragment {

    TextView mDescription, mTitle, mPricetag, mAddress;
    ProfilePictureView mProfilepic;
    ActionBar mActionBar;
    int position;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinners_viewholder_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.dinners_toolbar);
        //setSupportActionBar(toolbar);
        //mActionBar = getSupportActionBar();

        //mActionBar.setDisplayHomeAsUpEnabled(true);

        position = Data.getInstance().choice.hostPosition;

        mDescription = (TextView) findViewById(R.id.dinner_viewholder_description);
        mTitle = (TextView) findViewById(R.id.dinner_viewholder_title);
        mProfilepic = (ProfilePictureView) findViewById(R.id.dinner_profil_pic);
        mPricetag = (TextView) findViewById(R.id.dinner_viewholder_pricetag);
        mAddress = (TextView) findViewById(R.id.dinner_viewholder_address);

        mDescription.setText(Data.getInstance().banquets.get(position).getDescription());
        mTitle.setText(Data.getInstance().banquets.get(position).getTitle());
        mProfilepic.setProfileId(Data.getInstance().banquets.get(position).getHostId());
        mPricetag.setText(Data.getInstance().banquets.get(position).getPricetag() + ",- kr");
        mAddress.setText("Postnr.:" + Data.getInstance().banquets.get(position).getAddress());
    }
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dinners_viewholder_detailed, container, false);

        setHasOptionsMenu(true);

        position = Data.getInstance().choice.hostPosition;

        mDescription = (TextView) root.findViewById(R.id.dinner_viewholder_description);
        mTitle = (TextView) root.findViewById(R.id.dinner_viewholder_title);
        mProfilepic = (ProfilePictureView) root.findViewById(R.id.dinner_profil_pic);
        mPricetag = (TextView) root.findViewById(R.id.dinner_viewholder_pricetag);
        mAddress = (TextView) root.findViewById(R.id.dinner_viewholder_address);


        mDescription.setText(Data.getInstance().banquets.get(position).getDescription());
        mTitle.setText(Data.getInstance().banquets.get(position).getTitle());
        mProfilepic.setProfileId(Data.getInstance().banquets.get(position).getHostId());
        mPricetag.setText(Data.getInstance().banquets.get(position).getPricetag() + ",- kr");
        mAddress.setText("Postnr.:" + Data.getInstance().banquets.get(position).getAddress());

        return root;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Get item selected and deal with it
        switch (item.getItemId()) {
            case android.R.id.home:
                //called when the up affordance/carat in actionbar is pressed
                getActivity().onBackPressed();
                return true;
            default:
                return false;
        }
    }
}
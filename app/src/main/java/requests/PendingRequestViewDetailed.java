package requests;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.login.widget.ProfilePictureView;

import data.Data;
import main.MainAct;

/**
 * Created by Lars on 25-05-2016.
 */
public class PendingRequestViewDetailed extends Fragment {

    TextView mDescription, mTitle, mPricetag, mAddress;
    ProfilePictureView mProfilepic;
    int position;
    MainAct mainAct = (MainAct) Data.getInstance().choice.getMainAct();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.pending_request_viewholder_detailed, container, false);

        position = Data.getInstance().choice.hostPosition;

        mDescription = (TextView) root.findViewById(R.id.pending_request_viewholder_description);
        mTitle = (TextView) root.findViewById(R.id.pending_request_viewholder_title);
        mProfilepic = (ProfilePictureView) root.findViewById(R.id.pending_request_profil_pic);
        mPricetag = (TextView) root.findViewById(R.id.pending_request_viewholder_pricetag);
        mAddress = (TextView) root.findViewById(R.id.pending_request_viewholder_address);


        mDescription.setText(Data.getInstance().banquets.get(position).getDescription());
        mTitle.setText(Data.getInstance().banquets.get(position).getTitle());
        mProfilepic.setProfileId(Data.getInstance().banquets.get(position).getHostId());
        mPricetag.setText(Data.getInstance().banquets.get(position).getPricetag() + ",- kr");
        mAddress.setText("Postnr.:" + Data.getInstance().banquets.get(position).getAddress());

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mainAct.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
        mainAct.getSupportActionBar().setHomeButtonEnabled(true);
        mainAct.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mainAct.getActionBarDrawerToggle().setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mainAct.getSupportActionBar().setHomeButtonEnabled(false);
        mainAct.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mainAct.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }
}

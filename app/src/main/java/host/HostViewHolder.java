package host;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;

import data.Data;
import host.create.HostCreateDinner;


/**
 * Created by anders on 21-Mar-16.
 */
public class HostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    CardView mCardView;
    TextView mTitle, mAddress, mPricetag;
//    ImageView mProfilpic;
    ProfilePictureView mProfilpic;
    HostViewHolderClicks mListener;
    private final Context context;

    public HostViewHolder(View itemView, HostViewHolderClicks listener) {
        super(itemView);
        mListener = listener;
        mCardView = (CardView) itemView.findViewById(R.id.host_viewholder_cardview);
        mTitle = (TextView) itemView.findViewById(R.id.host_viewholder_title);
        mAddress = (TextView) itemView.findViewById(R.id.host_viewholder_address);
        mPricetag = (TextView) itemView.findViewById(R.id.host_viewholder_pricetag);
//        mProfilpic = (ImageView) itemView.findViewById(R.id.host_profil_pic);
        mProfilpic = (ProfilePictureView) itemView.findViewById(R.id.host_profil_pic);
        mProfilpic.setProfileId(Profile.getCurrentProfile().getId());
        context = itemView.getContext();
        mCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //mListener.onClicked(v);
        final Intent intent = new Intent(context, HostViewDetailed.class);
        Data.getInstance().choice.hostPosition = getPosition();
        String transitionName = "dinner_host_transition_cardview";
        context.startActivity(intent);
//        Data.ourInstance.choice.hostPosition = v.getVerticalScrollbarPosition();
    }

    public interface HostViewHolderClicks {
        void onClicked(View caller);
    }
}


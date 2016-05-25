package requests;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by Lars on 25-05-2016.
 */
public class PendingRequestViewHolder extends RecyclerView.ViewHolder {
    CardView mCardView;
    TextView mTitle, mAddress, mPricetag;
    ProfilePictureView mProfilpic;

    public PendingRequestViewHolder(View itemLayoutView) {
        super(itemLayoutView);

        mCardView = (CardView) itemView.findViewById(R.id.pending_request_viewholder_cardview);
        mTitle = (TextView) itemView.findViewById(R.id.pending_request_viewholder_title);
        mAddress = (TextView) itemView.findViewById(R.id.pending_request_viewholder_address);
        mPricetag = (TextView) itemView.findViewById(R.id.pending_request_viewholder_pricetag);
        mProfilpic = (ProfilePictureView) itemView.findViewById(R.id.pending_request_profil_pic);
    }
}

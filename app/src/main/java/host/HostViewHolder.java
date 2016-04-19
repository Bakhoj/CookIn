package host;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anders.cookin.R;


/**
 * Created by anders on 21-Mar-16.
 */
public class HostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    CardView mCardView;
    TextView mTitle, mAddress, mPricetag;
    ImageView mProfilpic;
    HostViewHolderClicks mListener;

    public HostViewHolder(View itemView, HostViewHolderClicks listener) {
        super(itemView);
        mListener = listener;
        mCardView = (CardView) itemView.findViewById(R.id.host_viewholder_cardview);
        mTitle = (TextView) itemView.findViewById(R.id.host_viewholder_title);
        mAddress = (TextView) itemView.findViewById(R.id.host_viewholder_address);
        mPricetag = (TextView) itemView.findViewById(R.id.host_viewholder_pricetag);
        mProfilpic = (ImageView) itemView.findViewById(R.id.host_profil_pic);

        mCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mListener.onClicked(v);
    }

    public static interface HostViewHolderClicks {
        public void onClicked(View caller);
    }
}


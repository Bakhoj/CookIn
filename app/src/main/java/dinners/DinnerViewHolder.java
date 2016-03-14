package dinners;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anders.cookin.R;

/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title, description, address, pricetag;
    public ImageView profilPic;
    public DinnerViewHolderClicks mListener;
    public RelativeLayout mRelativeLayout;
    public LinearLayout mExtendedLayout;

    public DinnerViewHolder(View itemLayoutView, DinnerViewHolderClicks listener) {
        super(itemLayoutView);
        mListener = listener;
        title = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_title);
        description = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_description);
        address = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_address);
        pricetag = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_pricetag);
        profilPic = (ImageView) itemLayoutView.findViewById(R.id.dinner_profil_pic);
        mRelativeLayout = (RelativeLayout) itemLayoutView.findViewById(R.id.dinner_viewholder_layout);
        mExtendedLayout = (LinearLayout) itemLayoutView.findViewById(R.id.dinner_viewholder_extended);

        title.setOnClickListener(this);
        description.setOnClickListener(this);
        address.setOnClickListener(this);
        pricetag.setOnClickListener(this);
        profilPic.setOnClickListener(this);
        mRelativeLayout.setOnClickListener(this);
        mExtendedLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Clicked",Toast.LENGTH_SHORT).show();
        if (v == profilPic){
            mListener.onProfilPic(v);
        } else if (v == title){
            mListener.onTitle(v);
        }
        if(mExtendedLayout.getVisibility() == View.GONE) {
            mExtendedLayout.setVisibility(View.VISIBLE);
        } else {
            mExtendedLayout.setVisibility(View.GONE);
        }

    }

    public static interface DinnerViewHolderClicks {
        void onProfilPic(View caller);
        void onTitle(View caller);
    }
}
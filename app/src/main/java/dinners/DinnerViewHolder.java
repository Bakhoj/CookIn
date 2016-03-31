package dinners;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.anders.cookin.R;

/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewHolder extends RecyclerView.ViewHolder {
    CardView mCardView;
    TextView mTitle, mAddress, mPricetag;
    ImageView mProfilpic;

    public DinnerViewHolder(View itemLayoutView) {
        super(itemLayoutView);

        mCardView = (CardView) itemView.findViewById(R.id.dinner_viewholder_cardview);
        mTitle = (TextView) itemView.findViewById(R.id.dinner_viewholder_title);
        mAddress = (TextView) itemView.findViewById(R.id.dinner_viewholder_address);
        mPricetag = (TextView) itemView.findViewById(R.id.dinner_viewholder_pricetag);
        mProfilpic = (ImageView) itemView.findViewById(R.id.dinner_profil_pic);
    }
}
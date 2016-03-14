package dinners;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anders.cookin.R;

/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title, description;
    public ImageView profilPic;
    public DinnerViewHolderClicks mListener;

    public DinnerViewHolder(View itemLayoutView, DinnerViewHolderClicks listener) {
        super(itemLayoutView);
        mListener = listener;
        title = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_title);
        description = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_description);
        profilPic = (ImageView) itemLayoutView.findViewById(R.id.dinner_profil_pic);
        title.setOnClickListener(this);
        description.setOnClickListener(this);
        profilPic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public static interface DinnerViewHolderClicks {

    }
}
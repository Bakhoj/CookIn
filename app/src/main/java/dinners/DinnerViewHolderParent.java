package dinners;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.anders.cookin.R;

/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewHolderParent extends ParentViewHolder {

    public TextView title, address, pricetag;
    public ImageView profilPic;

    public DinnerViewHolderParent(View itemLayoutView) {
        super(itemLayoutView);

        title = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_title);
        address = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_address);
        pricetag = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_pricetag);
        profilPic = (ImageView) itemLayoutView.findViewById(R.id.dinner_profil_pic);

    }

    public void bind(Dinner dinner) {
        title.setText(dinner.getTitle());
        address.setText(dinner.getAddress());
        pricetag.setText(dinner.getPricetag() + ",- kr");
    }
}
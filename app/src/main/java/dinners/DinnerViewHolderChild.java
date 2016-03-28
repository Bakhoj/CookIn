package dinners;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.anders.cookin.R;

/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewHolderChild extends ChildViewHolder {

    public TextView description, time;
    public RelativeLayout mRelativeLayout;


    public DinnerViewHolderChild(View itemLayoutView) {
        super(itemLayoutView);

        time = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_time);
        description = (TextView) itemLayoutView.findViewById(R.id.dinner_viewholder_description);
        mRelativeLayout = (RelativeLayout) itemLayoutView.findViewById(R.id.dinner_viewholder_layout);

    }

    public void bind(DinnerChild dinnerChild) {
        time.setText(dinnerChild.getTime());
        description.setText(dinnerChild.getDescription());
    }
}
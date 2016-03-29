package dinners;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.example.anders.cookin.R;

import java.util.List;


/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewAdapter extends ExpandableRecyclerAdapter<DinnerViewHolderParent, DinnerViewHolderChild> {

    private LayoutInflater mInflater;
    String[]mDataset = {"Dinner Dinner Chicken Winner", "Bob's mad forretning", "Title3", "Title4", "Title5", "Title6", "Title7"};
    String[]mDescription = {"noget lækket mad med noget kylling til de sultene", "Tømmermand Bob laver lige nogle lækre frikadeller rigtig håndvæker style", "Description3", "Description4", "Description5", "Description6", "Description7"};
    String[]mTime = {"Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30", "Monday 19:30-21:30"};
    int[]mPricetag = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

    public DinnerViewAdapter(Context context, @NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public DinnerViewHolderParent onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View parentView  = mInflater.inflate(R.layout.dinners_viewholder_parent, parentViewGroup, false);
        return new DinnerViewHolderParent(parentView);
    }

    @Override
    public DinnerViewHolderChild onCreateChildViewHolder(ViewGroup childViewGroup) {
        View childView = mInflater.inflate(R.layout.dinners_viewholder_child, childViewGroup, false);
        return new DinnerViewHolderChild(childView);
    }

    @Override
    public void onBindParentViewHolder(DinnerViewHolderParent dinnerViewHolderParent, int position, ParentListItem parentListItem) {
        Dinner dinner = (Dinner) parentListItem;
        dinnerViewHolderParent.bind(dinner);
        /*dinnerViewHolderParent.title.setText(dinner.getTitle());
        dinnerViewHolderParent.address.setText(dinner.getAddress());
        dinnerViewHolderParent.pricetag.setText(dinner.getPricetag() + "kr,-");*/
    }


    @Override
    public void onBindChildViewHolder(DinnerViewHolderChild dinnerViewHolderChild, int position, Object childObject) {
        DinnerChild dinnerChild = (DinnerChild) childObject;
        dinnerViewHolderChild.bind(dinnerChild);
        /*dinnerViewHolderChild.time.setText("Monday 19:30-21:00");
        dinnerViewHolderChild.description.setText("Some description");*/
    }

    @Override
    public int getItemCount() {
        //return mDataset.length;
        //return Dinner.mDataset.length;
        return 4;
    }
}

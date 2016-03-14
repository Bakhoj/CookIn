package dinners;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anders.cookin.R;

/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewAdapter extends RecyclerView.Adapter<DinnerViewHolder> {

    String[]mDataset = {"Dinner Dinner Chicken Winner", "Bob's mad forretning", "Title3", "Title4", "Title5", "Title6", "Title7"};
    String[]mDescription = {"noget lækket mad med noget kylling til de sultene", "Tømmermand Bob laver lige nogle lækre frikadeller rigtig håndvæker style", "Description3", "Description4", "Description5", "Description6", "Description7"};

    @Override
    public DinnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinners_viewholder, parent, false);

        DinnerViewHolder vh = new DinnerViewHolder(v, new DinnerViewHolder.DinnerViewHolderClicks() {

        });

        return vh;
    }

    @Override
    public void onBindViewHolder(DinnerViewHolder holder, int position) {
        holder.title.setText(mDataset[position]);
        holder.description.setText(mDescription[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

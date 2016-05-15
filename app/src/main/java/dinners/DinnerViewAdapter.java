package dinners;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.cookin.app.R;

import java.util.List;

import data.Banquet;
import data.Data;
import data.Dinner;
import host.HostViewDetailed;


/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewAdapter extends RecyclerView.Adapter<DinnerViewHolder> {

    //List<Dinner> dinners;
    List<Banquet> banquets;

    public DinnerViewAdapter(List<Banquet> banquets) { this.banquets = banquets; }

    @Override
    public DinnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinners_viewholder, parent, false);
        DinnerViewHolder mDinnerViewHolder = new DinnerViewHolder(v);
        return mDinnerViewHolder;
    }

    @Override
    public void onBindViewHolder(final DinnerViewHolder holder, final int position) {
        holder.mTitle.setText(banquets.get(position).getTitle());
        holder.mAddress.setText("Postnummer: " + banquets.get(position).getAddress());
        holder.mPricetag.setText(((double) banquets.get(position).getPricetag()) + ",- kr");
        holder.mProfilpic.setProfileId(banquets.get(position).getHostId());

        holder.mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(v.getContext(), HostViewDetailed.class);
                Data.getInstance().choice.hostPosition = position;
                String transitionName = "dinner_host_transition_cardview";
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return banquets.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

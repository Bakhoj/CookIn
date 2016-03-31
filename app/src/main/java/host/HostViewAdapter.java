package host;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import com.example.anders.cookin.R;

import java.util.List;

import data.DinnerHost;
import login.LoginAct;

/**
 * Created by anders on 21-Mar-16.
 */
public class HostViewAdapter extends RecyclerView.Adapter<HostViewHolder> {

    List<DinnerHost> dinnerHosts;

    public HostViewAdapter(List<DinnerHost> dinnerHosts) {
        this.dinnerHosts = dinnerHosts;
    }

    @Override
    public HostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.host_viewholder, parent, false);
        HostViewHolder mHostViewHolder = new HostViewHolder(v);
        return mHostViewHolder;
    }

    @Override
    public void onBindViewHolder(final HostViewHolder holder, final int position) {
        holder.mTitle.setText(dinnerHosts.get(position).title);
        holder.mAddress.setText(dinnerHosts.get(position).hostProfil.address);
        holder.mPricetag.setText(((int) dinnerHosts.get(position).pricetag) + ",- kr");

        holder.mCardView.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    holder.mCardView.setCardElevation(0);
                }

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    holder.mCardView.setCardElevation(8);
                    holder.mPricetag.setText("Pressed");

                }

                if(event.getAction() == MotionEvent.ACTION_CANCEL) {
                    holder.mCardView.setCardElevation(8);
                    holder.mPricetag.setText("CANCELLED");
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dinnerHosts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

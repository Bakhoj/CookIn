package host;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;


import com.example.anders.cookin.R;

import java.util.List;

import data.Host;

/**
 * Created by anders on 21-Mar-16.
 */
public class HostViewAdapter extends RecyclerView.Adapter<HostViewHolder> {

    List<Host> hosts;

    public HostViewAdapter(List<Host> hosts) {
        this.hosts = hosts;
    }

    @Override
    public HostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.host_viewholder_parent, parent, false);
        HostViewHolder mHostViewHolder = new HostViewHolder(v);
        return mHostViewHolder;
    }

    @Override
    public void onBindViewHolder(final HostViewHolder holder, final int position) {
        holder.mTitle.setText(hosts.get(position).title);
        holder.mAddress.setText(hosts.get(position).address);
        holder.mPricetag.setText(hosts.get(position).pricetag + ",- kr");

        holder.mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Vibrator vibe = (Vibrator) v.getContext().getSystemService(v.getContext().VIBRATOR_SERVICE);
                vibe.vibrate(50);
            }
        });

        holder.mCardView.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    holder.mCardView.setCardElevation(0);
                }

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    holder.mCardView.setCardElevation(8);
                    holder.mPricetag.setText("DYRT!");
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
        return hosts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

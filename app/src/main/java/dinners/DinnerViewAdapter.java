package dinners;

import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.cookin.app.R;

import java.util.List;

import data.Dinner;


/**
 * Created by anders on 14-03-2016.
 */
public class DinnerViewAdapter extends RecyclerView.Adapter<DinnerViewHolder> {

    List<Dinner> dinners;

    public DinnerViewAdapter(List<Dinner> dinners) { this.dinners = dinners; }

    @Override
    public DinnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinners_viewholder, parent, false);
        DinnerViewHolder mDinnerViewHolder = new DinnerViewHolder(v);
        return mDinnerViewHolder;
    }

    @Override
    public void onBindViewHolder(final DinnerViewHolder holder, final int position) {
        holder.mTitle.setText(dinners.get(position).title);
        holder.mAddress.setText("Postnummer: " + dinners.get(position).hostProfil.arealCode + "");
        holder.mPricetag.setText(((int) dinners.get(position).pricetag) + ",- kr");

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
        return dinners.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

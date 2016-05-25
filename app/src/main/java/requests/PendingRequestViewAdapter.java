package requests;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookin.app.R;

import java.util.List;

import data.Banquet;
import data.Data;
import dinners.DinnerViewDetailed;

/**
 * Created by Lars on 25-05-2016.
 */
public class PendingRequestViewAdapter extends RecyclerView.Adapter<PendingRequestViewHolder>  {

    List<Banquet> banquetPendingRequests;

    public PendingRequestViewAdapter(List<Banquet> banquetPendingRequests){
        this.banquetPendingRequests = banquetPendingRequests;
    }

    @Override
    public PendingRequestViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_request_viewholder, parent, false);
        PendingRequestViewHolder mPendingRequestViewHolder = new PendingRequestViewHolder(v);
        return mPendingRequestViewHolder;
    }

    @Override
    public void onBindViewHolder(final PendingRequestViewHolder holder, final int position) {
        holder.mTitle.setText(banquetPendingRequests.get(position).getTitle());
        holder.mAddress.setText("Postnr.: " + banquetPendingRequests.get(position).getAddress());
        holder.mPricetag.setText(((int) banquetPendingRequests.get(position).getPricetag()) + ",- kr");
        holder.mProfilpic.setProfileId(banquetPendingRequests.get(position).getHostId());

        holder.mCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Data.getInstance().choice.hostPosition = position;
                String transitionName = "pending_request_transition_cardview";
                final FragmentTransaction ft = Data.getInstance().mFragmentManager.beginTransaction();
                ft.replace(R.id.main_content, new PendingRequestViewDetailed());
                ft.addToBackStack(null);
                ft.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return banquetPendingRequests.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

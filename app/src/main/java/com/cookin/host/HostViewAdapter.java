package com.cookin.host;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cookin.app.R;

import java.util.List;

import com.cookin.data.Banquet;

/**
 * Created by anders on 21-Mar-16.
 */
public class HostViewAdapter extends RecyclerView.Adapter<HostViewHolder> {

    List<Banquet> banquetHosts;

    public HostViewAdapter(List<Banquet> banquetHosts) {
        this.banquetHosts = banquetHosts;
    }

    @Override
    public HostViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.host_viewholder, parent, false);
        HostViewHolder mHostViewHolder = new HostViewHolder(v, new HostViewHolder.HostViewHolderClicks() {
            @Override
            public void onClicked(View caller) {

            }
        });
        return mHostViewHolder;
    }

    @Override
    public void onBindViewHolder(final HostViewHolder holder, final int position) {
        holder.mTitle.setText(banquetHosts.get(position).getTitle());
        holder.mAddress.setText("Postnr.: " + banquetHosts.get(position).getAddress());
        holder.mPricetag.setText(((int) banquetHosts.get(position).getPricetag()) + ",- kr");
    }

    @Override
    public int getItemCount() {
        return banquetHosts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

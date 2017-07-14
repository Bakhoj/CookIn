package dinners;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.login.widget.ProfilePictureView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import data.Banquet;
import data.Data;
import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class MainDinnersFrag extends Fragment {

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dinners_main_frag, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.dinners_list);

        mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        
        DinnerViewAdapter adapter = new DinnerViewAdapter(Data.getInstance().banquets);
        mRecyclerView.setAdapter(adapter);

        getFragmentManager().beginTransaction();
        return rootView;
    }

    class DinnerViewAdapter extends RecyclerView.Adapter<DinnerViewAdapter.DinnerViewHolder> {

        private List<Banquet> banquets;

        public DinnerViewAdapter(List<Banquet> banquets) { this.banquets = banquets; }


        @Override
        public DinnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinners_viewholder, parent, false);
            return new DinnerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final DinnerViewHolder holder, final int position) {
            holder.mTitle.setText(banquets.get(position).getTitle());
            holder.mProfilpic.setProfileId(banquets.get(position).getHostId());

            String preStr = "Postnr.: ";
            String addressStr = banquets.get(position).getAddress();
            SpannableString str = new SpannableString(preStr + addressStr);
            CalligraphyTypefaceSpan typefaceSpan = new CalligraphyTypefaceSpan(TypefaceUtils.load(getContext().getAssets(), "fonts/Academy-Sans-Bold.ttf"));
            str.setSpan(typefaceSpan, preStr.length(), addressStr.length() + preStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mAddress.setText(str, TextView.BufferType.SPANNABLE);

            preStr = ",- kr";
            String priceStr = String.valueOf(((int) banquets.get(position).getPricetag()));
            str = new SpannableString(priceStr + preStr);
            str.setSpan(typefaceSpan, 0, priceStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mPricetag.setText(str, TextView.BufferType.SPANNABLE);

            holder.mCardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //final Intent intent = new Intent(v.getContext(), DinnerViewDetailed.class);
                    Data.getInstance().choice.hostPosition = position;
                    String transitionName = "dinner_host_transition_cardview";
                    //v.getContext().startActivity(intent);
                    final FragmentTransaction ft = Data.getInstance().mFragmentManager.beginTransaction();
                    ft.replace(R.id.main_content, new DinnerViewDetailed());
                    ft.addToBackStack(null);
                    ft.commit();

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

        class DinnerViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.dinner_viewholder_cardview) CardView mCardView;
            @BindView(R.id.dinner_viewholder_title) TextView mTitle;
            @BindView(R.id.dinner_viewholder_address) TextView mAddress;
            @BindView(R.id.dinner_viewholder_pricetag) TextView mPricetag;
            @BindView(R.id.dinner_profil_pic) ProfilePictureView mProfilpic;

            DinnerViewHolder(View itemLayoutView) {
                super(itemLayoutView);
                ButterKnife.bind(this, itemLayoutView);

            }
        }
    }

}
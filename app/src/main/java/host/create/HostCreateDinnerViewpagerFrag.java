package host.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anders.cookin.R;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import dinners.MainDinnersFrag;
import host.MainHostFrag;
import main.MainPendingRequestFrag;
import main.ViewpagerFrag;

public class HostCreateDinnerViewpagerFrag extends Fragment {
    private CreateSectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.host_create_dinner_viewpager_frag, container, false);

        mSectionsPagerAdapter = new CreateSectionsPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) root.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        InkPageIndicator inkPageIndicator = (InkPageIndicator) root.findViewById(R.id.indicator);
        inkPageIndicator.setViewPager(mViewPager);

        return root;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class CreateSectionsPagerAdapter extends FragmentPagerAdapter {

        public CreateSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return new CreateFirstFrag();
                case 1:
                    return new CreateSecondFrag();
//                case 2:
//                    return new CreateThirdFrag();
                default:
                    return new CreateFirstFrag();
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "something";
                case 1:
                    return "something else";
                case 2:
                    return "OMG you are ALMOST there!";
            }
            return null;
        }
    }
}

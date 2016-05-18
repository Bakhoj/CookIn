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

import com.cookin.app.R;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import data.Data;
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

    private CreateFirstFrag cff = new CreateFirstFrag();
    private CreateSecondFrag csf = new CreateSecondFrag();
    private CreateThirdFrag ctf = new CreateThirdFrag();
    private CreateOverviewFrag cof = new CreateOverviewFrag();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.host_create_dinner_viewpager_frag, container, false);

        mSectionsPagerAdapter = new CreateSectionsPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) root.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        csf.updateChoice();
                        break;
                    case 1:
                        cff.updateChoice();
                        ctf.updateChoice();
                        break;
                    case 2:
                        csf.updateChoice();
                        break;
                    case 3:
                        ctf.updateChoice();
                        cof.updateChoice();
                        break;
                    default:
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
                    return cff;
                case 1:
                    return csf;
                case 2:
                    return ctf;
                case 3:
                    return cof;
                default:
                    return new CreateFirstFrag();
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }


    }
}

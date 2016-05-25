package host.create;

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

public class HostCreateDinnerViewpagerFrag extends Fragment {
    private CreateSectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private CreateFirstFrag createFirstFrag = new CreateFirstFrag();
    private CreateSecondFrag createSecondFrag = new CreateSecondFrag();
    private CreateThirdFrag createThirdFrag = new CreateThirdFrag();
    private CreateOverviewFrag createOverviewFrag = new CreateOverviewFrag();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.create_dinner_viewpager_frag, container, false);

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
                        createSecondFrag.updateChoice();
                        break;
                    case 1:
                        createFirstFrag.updateChoice();
                        break;
                    case 2:
                        createSecondFrag.updateChoice();
                        break;
                    case 3:
                        createThirdFrag.updateChoice();
                        createOverviewFrag.updateChoice();
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
                    return createFirstFrag;
                case 1:
                    return createSecondFrag;
                case 2:
                    return createThirdFrag;
                case 3:
                    return createOverviewFrag;
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

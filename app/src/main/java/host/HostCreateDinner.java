package host;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.anders.cookin.R;
import com.pixelcan.inkpageindicator.InkPageIndicator;

public class HostCreateDinner extends Fragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_create_dinner_act);
        InkPageIndicator inkPageIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        inkPageIndicator.setViewPager(viewPager);
    }

}

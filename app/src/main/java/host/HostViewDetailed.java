package host;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.anders.cookin.R;

import org.w3c.dom.Text;

import data.Data;

public class HostViewDetailed extends AppCompatActivity {

    TextView mDescription, mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_viewholder_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDescription = (TextView) findViewById(R.id.host_viewholder_description);
        mTitle = (TextView) findViewById(R.id.host_viewholder_title);

        mDescription.setText("Hej Description");
        mTitle.setText(Data.ourInstance.dinnerHosts.get(Data.ourInstance.choice.hostPosition).title);
    }

}
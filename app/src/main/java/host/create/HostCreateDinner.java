package host.create;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cookin.app.R;

import data.Banquet;
import data.Data;
import data.FireBHandler;

public class HostCreateDinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_dinner_act);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_content, new HostCreateDinnerViewpagerFrag())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_dinner_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.create_action:

                if(Data.getInstance().choice.getTitle().equals("")){
                    System.out.println("shit son");
                } else {

                    Banquet banquet = new Banquet();
                    banquet.setTitle(Data.getInstance().choice.getTitle());
                    banquet.setDescription(Data.getInstance().choice.getDescription());
                    banquet.setMaxGuest(Data.getInstance().choice.getGuest());
                    banquet.setPricetag(Data.getInstance().choice.getPrice());
                    banquet.setStartDate(Data.getInstance().choice.getStartDate());
                    banquet.setDeadlineDate(Data.getInstance().choice.getDeadlineDate());
                    FireBHandler.getInstance().uploadDinner(banquet);
                    finish();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

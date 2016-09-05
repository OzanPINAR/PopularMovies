package ege.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    static int Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(null);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (Id == 0){
            Id = R.id.action_sort_popularity;
        } else {
            menu.findItem(Id).setChecked(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        MainActivityFragment fragment = MainActivityFragment.instance;

        if (id == R.id.action_sort_rating) {
            MainActivityFragment.sortOrder = "/movie/top_rated";
            MainActivityFragment.moreParams = "";
        } else if (id == R.id.action_sort_popularity) {
            MainActivityFragment.sortOrder = "/movie/popular";
            MainActivityFragment.moreParams = "";
        }
        item.setChecked(true);
        if (id == R.id.action_sort_popularity || id == R.id.action_sort_rating){
            fragment.updateUI(false);
            Id = id;
        } else if (id == R.id.action_favorites){
            fragment.updateUI(true);
            Id = id;
        }
        return super.onOptionsItemSelected(item);
    }
}

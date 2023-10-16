package com.example.tp_2mobile;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.tp_2mobile.adapter.StarAdapter;
import com.example.tp_2mobile.beans.Star;
import com.example.tp_2mobile.service.StarService;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Star> stars;


    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    private StarService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);


        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void init() {
        service.create(new Star("kate bosworth",
                "data:image/jpeg;base64,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", 3.5f));
        service.create(new Star("george clooney",
                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-969403912.jpg", 3));
        service.create(new Star("michelle rodriguez",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVQRd1joI0TdYqKntPp-iztmRDxZiHFmQwbw&usqp=CAU", 5));
        service.create(new Star("george clooney",
                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-969403912.jpg", 1));
        service.create(new Star("louise bouroin",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ87ciqJRP01Z5PcQy7396knKVWtTAzrkplf-GGL4gzyOXqOMQIifsLcolousJwrsKzxwA&usqp=CAU", 5));
        service.create(new Star("louise bouroin",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ87ciqJRP01Z5PcQy7396knKVWtTAzrkplf-GGL4gzyOXqOMQIifsLcolousJwrsKzxwA&usqp=CAU", 1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new
                                                  SearchView.OnQueryTextListener() {
                                                      @Override
                                                      public boolean onQueryTextSubmit(String query) {
                                                          return true;
                                                      }
                                                      @Override
                                                      public boolean onQueryTextChange(String newText) {
                                                          Log.d(TAG, newText);
                                                          if (starAdapter != null){
                                                              starAdapter.getFilter().filter(newText);
                                                          }
                                                          return true;
                                                      }
                                                  });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            String txt = "Stars";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Stars")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }

}
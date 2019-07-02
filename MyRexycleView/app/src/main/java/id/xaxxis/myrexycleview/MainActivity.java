package id.xaxxis.myrexycleview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import id.xaxxis.myrexycleview.Model.Hero;
import id.xaxxis.myrexycleview.Model.HeroesData;
import id.xaxxis.myrexycleview.adapter.CardViewHeroAdapter;
import id.xaxxis.myrexycleview.adapter.GridHeroAdapter;
import id.xaxxis.myrexycleview.adapter.ListHeroAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Hero> listHero = new ArrayList<>();
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        listHero.addAll(HeroesData.getListData());
        showRecycleList();

        if (savedInstanceState == null){
            setActionBarTitle(title);
            listHero.addAll(HeroesData.getListData());
            showRecycleList();
            mode = R.id.action_list;
        } else {
            title = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Hero> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(title);
            listHero.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedHero(Hero hero){
        Toast.makeText(this, "Kamu memilih "+hero.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, listHero);
        outState.putInt(STATE_MODE, mode);
    }

    private void showRecycleList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(this);
        listHeroAdapter.setHeroArrayList(listHero);
        rvCategory.setAdapter(listHeroAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHero(listHero.get(position));
            }
        });
    }

    private void showGridView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(this);
        gridHeroAdapter.setHeroArrayList(listHero);
        rvCategory.setAdapter(gridHeroAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHero(listHero.get(position));
            }
        });
    }

    private void showCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(this);
        cardViewHeroAdapter.setHeroArrayList(listHero);
        rvCategory.setAdapter(cardViewHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.action_list:
                showRecycleList();
                setActionBarTitle("Mode List");
                break;

            case R.id.action_grid:
                showGridView();
                setActionBarTitle("Mode Grid");
                break;

            case R.id.action_cardview:
                showCardView();
                setActionBarTitle("Mode CardView");
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    public void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}

package id.xaxxis.moivecatalogue;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

import id.xaxxis.moivecatalogue.adapter.ListMovieAdapter;
import id.xaxxis.moivecatalogue.adapter.SectionPagerAdapter;
import id.xaxxis.moivecatalogue.model.Movie;

public class MainActivity extends AppCompatActivity {

    private TypedArray dataImgCover;
    private TypedArray dataImageBanner;
    private String[] dataMovieTitle;
    private String[] dataMovieYear;
    private String[] dataMovieRate;
    private String[] dataMovieSynopsis;
    private String[] dataMovieGenre;
    private String[] dataMovieDuration;
    private String[] dataMovieCategory;

    private ArrayList<Movie> movies = new ArrayList<>();
    ListMovieAdapter lmAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareActionBar();

        SectionPagerAdapter sectionsPagerAdapter = new SectionPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pagger);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        recyclerView = findViewById(R.id.rv_movie);
        lmAdapter = new ListMovieAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(lmAdapter);
        moviePrepare();
        addMovieItem();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app_bar, menu);
        return true;
    }

    private void prepareActionBar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_movie_logo_24dp);
        }
    }


    private void moviePrepare(){
        dataImgCover = getResources().obtainTypedArray(R.array.data_movie_image);
        dataImageBanner = getResources().obtainTypedArray(R.array.data_movie_banner);
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieYear = getResources().getStringArray(R.array.data_movie_year);
        dataMovieRate = getResources().getStringArray(R.array.data_movie_rate);
        dataMovieDuration = getResources().getStringArray(R.array.data_movie_duration);
        dataMovieSynopsis = getResources().getStringArray(R.array.data_movie_synopsis);
        dataMovieGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataMovieCategory = getResources().getStringArray(R.array.data_movie_category);
    }

    private void addMovieItem(){
        movies = new ArrayList<>();
        for(int i=0; i<dataMovieTitle.length; i++){
            Movie movie = new Movie();
            movie.setPhotoCover(dataImgCover.getResourceId(i, -1));
            movie.setPhotoBanner(dataImageBanner.getResourceId(i, -1));
            movie.setTitle(dataMovieTitle[i]);
            movie.setDuration(dataMovieDuration[i]);
            movie.setDateRelease(dataMovieYear[i]);
            movie.setSynopsis(dataMovieSynopsis[i]);
            movie.setGenre(dataMovieGenre[i]);
            movie.setRating(dataMovieRate[i]);
            movies.add(movie);
        }
        lmAdapter.setMovies(movies);
    }
}

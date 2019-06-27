package id.xaxxis.moviecatalogapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import id.xaxxis.moviecatalogapp.adapter.ListMovieAdapter;
import id.xaxxis.moviecatalogapp.model.Movie;

public class MainActivity extends AppCompatActivity {
    private TypedArray dataImageMovie;
    private String[] dataMovieTitle;
    private String[] dataMovieYear;
    private String[] dataMovieRate;
    private String[] dataMovieSynopsis;
    private ArrayList<Movie> movies;
    private ListMovieAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListMovieAdapter(this);
        ListView lvMovie = findViewById(R.id.lv_movie);
        lvMovie.setAdapter(adapter);

        prepare();
        addItem();

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveToDetail = new Intent(MainActivity.this, MovieDetailActivity.class);
                moveToDetail.putExtra(MovieDetailActivity.EXTRA_MOVIE, movies.get(i));
                startActivity(moveToDetail);
            }
        });

    }

    private void prepare(){
        dataImageMovie = getResources().obtainTypedArray(R.array.data_movie_image);
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieYear = getResources().getStringArray(R.array.data_movie_year);
        dataMovieRate = getResources().getStringArray(R.array.data_movie_rate);
        dataMovieSynopsis = getResources().getStringArray(R.array.data_movie_synopsis);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for(int i=0; i<dataMovieTitle.length; i++){
            Movie movie = new Movie();
            movie.setPhotoCover(dataImageMovie.getResourceId(i,-1));
            movie.setMovieTitle(dataMovieTitle[i]);
            movie.setMovieYear(dataMovieYear[i]);
            movie.setMovieRating(dataMovieRate[i]);
            movie.setMovieYear(dataMovieYear[i]);
            movie.setMovieSynopsis(dataMovieSynopsis[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);

    }
}

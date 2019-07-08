package id.xaxxis.moviecatalogue.dummy;

import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.xaxxis.moviecatalogue.MainActivity;
import id.xaxxis.moviecatalogue.R;
import id.xaxxis.moviecatalogue.adapter.SectionPagerAdapter;
import id.xaxxis.moviecatalogue.model.Movie;

public class MovieDataDummy {

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
    SectionPagerAdapter spAdapter;
    private RecyclerView recyclerView;

    private void moviePrepare(){
        MainActivity mainActivity = new MainActivity();
        dataImgCover = mainActivity.getResources().obtainTypedArray(R.array.data_movie_image);
        dataImageBanner = mainActivity.getResources().obtainTypedArray(R.array.data_movie_banner);
        dataMovieTitle = mainActivity.getResources().getStringArray(R.array.data_movie_title);
        dataMovieYear = mainActivity.getResources().getStringArray(R.array.data_movie_year);
        dataMovieRate = mainActivity.getResources().getStringArray(R.array.data_movie_rate);
        dataMovieDuration = mainActivity.getResources().getStringArray(R.array.data_movie_duration);
        dataMovieSynopsis = mainActivity.getResources().getStringArray(R.array.data_movie_synopsis);
        dataMovieGenre = mainActivity.getResources().getStringArray(R.array.data_movie_genre);
        dataMovieCategory = mainActivity.getResources().getStringArray(R.array.data_movie_category);
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
    }
}

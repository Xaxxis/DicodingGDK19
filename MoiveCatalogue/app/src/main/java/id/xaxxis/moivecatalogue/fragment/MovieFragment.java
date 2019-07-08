package id.xaxxis.moivecatalogue.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.xaxxis.moivecatalogue.R;
import id.xaxxis.moivecatalogue.adapter.ListMovieAdapter;
import id.xaxxis.moivecatalogue.model.Movie;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

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


    public MovieFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

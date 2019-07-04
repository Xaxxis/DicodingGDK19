package id.xaxxis.moivecatalogue.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
    private String[] dataMovieTitle;
    private String[] dataMovieYear;
    private String[] dataMovieRate;
    private String[] dataMovieSynopsis;
    private String[] dataMovieGenre;
    private String[] dataMovieDuration;
    private ArrayList<Movie> movies;
    private ListMovieAdapter lmAdapter;
    private RecyclerView recyclerView;


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = view.findViewById(R.id.rv_movie);
        recyclerView.setAdapter(lmAdapter);

        //moviePrepare();
        //addMovieItem();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void moviePrepare(){
        dataImgCover = getResources().obtainTypedArray(R.array.data_movie_image);
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieYear = getResources().getStringArray(R.array.data_movie_year);
        dataMovieRate = getResources().getStringArray(R.array.data_movie_rate);
        dataMovieDuration = getResources().getStringArray(R.array.data_movie_duration);
        dataMovieSynopsis = getResources().getStringArray(R.array.data_movie_synopsis);
        dataMovieGenre = getResources().getStringArray(R.array.data_movie_genre);
    }

    private void addMovieItem(){
        movies = new ArrayList<>();
        for(int i=0; i<dataImgCover.length(); i++){
            Movie movie = new Movie();
            movie.setPhotoCover(dataImgCover.getResourceId(i, -1));
            movie.setTitle(dataMovieTitle[i]);
            movie.setDuration(dataMovieDuration[i]);
            movie.setDateRelease(dataMovieYear[i]);
            movie.setSynopsis(dataMovieSynopsis[i]);
            movie.setGenre(dataMovieGenre[i]);
            movie.setRating(dataMovieRate[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}

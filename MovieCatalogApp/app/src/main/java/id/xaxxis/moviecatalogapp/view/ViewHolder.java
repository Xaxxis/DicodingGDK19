package id.xaxxis.moviecatalogapp.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.xaxxis.moviecatalogapp.R;
import id.xaxxis.moviecatalogapp.model.Movie;

public class ViewHolder {
    private ImageView imgMovie;
    private TextView tvMovieTitle, tvMovieYear, tvMovieRate, tvMovieSynopsis;

    public ViewHolder(View view){
        imgMovie = view.findViewById(R.id.img_movie);
        tvMovieTitle = view.findViewById(R.id.tv_movie_title);
        tvMovieYear = view.findViewById(R.id.tv_movie_year);
        tvMovieRate = view.findViewById(R.id.tv_movie_rate);
        tvMovieSynopsis = view.findViewById(R.id.tv_movie_synopsis);
    }

    public void bind(Movie movie){
        imgMovie.setImageResource(movie.getPhotoCover());
        tvMovieTitle.setText(movie.getMovieTitle());
        tvMovieYear.setText(movie.getMovieYear());
        tvMovieRate.setText(movie.getMovieRating());
        tvMovieSynopsis.setText(movie.getMovieSynopsis());
    }

}

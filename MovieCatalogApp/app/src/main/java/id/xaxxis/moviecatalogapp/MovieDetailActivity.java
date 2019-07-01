package id.xaxxis.moviecatalogapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import id.xaxxis.moviecatalogapp.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = getIntent().getParcelableExtra("movie");
        ImageView imgDetailMovie = findViewById(R.id.img_detail_movie);
        Glide.with(this)
                .load(movie.getPhotoCover())
                .apply(new RequestOptions())
                .into(imgDetailMovie);
        TextView tvDetailTitle = findViewById(R.id.tv_detail_title);
        tvDetailTitle.setText(movie.getMovieTitle());

        TextView tvDetailYear = findViewById(R.id.tv_detail_year);
        tvDetailYear.setText(movie.getMovieYear());

        TextView tvDetailRate = findViewById(R.id.tv_detail_rate);
        tvDetailRate.setText(movie.getMovieRating());

        TextView tvDetailGenre = findViewById(R.id.tv_detail_genre);
        tvDetailGenre.setText(movie.getMovieGenre());

        TextView tvDetailDuration = findViewById(R.id.tv_detail_duration);
        tvDetailDuration.setText(movie.getMovieDuration());

        TextView tvDetailSynopsis = findViewById(R.id.tv_detail_synopsis);
        tvDetailSynopsis.setText(movie.getMovieSynopsis());

        getSupportActionBar().setTitle(movie.getMovieTitle());
    }

}

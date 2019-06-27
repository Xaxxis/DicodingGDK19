package id.xaxxis.moviecatalogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import id.xaxxis.moviecatalogapp.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvDetailTitle, tvDetailYear, tvDetailRate;
    ImageView imgDetailMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        imgDetailMovie = findViewById(R.id.img_detail_movie);
        Glide.with(this)
                .load(movie.getPhotoCover())
                .apply(new RequestOptions().override(130,180))
                .into(imgDetailMovie);
        tvDetailTitle = findViewById(R.id.tv_detail_title);
        tvDetailTitle.setText(movie.getMovieTitle());

        tvDetailYear = findViewById(R.id.tv_detail_year);
        tvDetailYear.setText(movie.getMovieYear());


    }
}

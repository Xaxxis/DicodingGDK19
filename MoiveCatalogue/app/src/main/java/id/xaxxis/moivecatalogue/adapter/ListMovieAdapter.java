package id.xaxxis.moivecatalogue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.xaxxis.moivecatalogue.R;
import id.xaxxis.moivecatalogue.listener.CustomOnItemClickListener;
import id.xaxxis.moivecatalogue.model.Movie;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.MovieViewHolder> {
    private final Context mContext;
    private ArrayList<Movie> movies;

    public ListMovieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.MovieViewHolder movieViewHolder, int i) {
        final Movie movie = getMovies().get(i);

        Glide.with(mContext).load(movie.getPhotoCover())
                .into(movieViewHolder.imgCover);

        movieViewHolder.tvTitle.setText(movie.getTitle());
        movieViewHolder.tvReleaseDate.setText(movie.getDateRelease());
        movieViewHolder.tvGenre.setText(movie.getGenre());
        movieViewHolder.tvDuration.setText(movie.getDuration());

        if(movie.isFavorite()){
            movieViewHolder.tglFavorite.setBackground(ContextCompat.getDrawable(mContext, R.drawable.ic_favorite_on_24dp));
        } else{
            movieViewHolder.tglFavorite.setBackground(ContextCompat.getDrawable(mContext, R.drawable.ic_favorite_off_24dp));
        }

        movieViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(mContext, "Share " +getMovies().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCover;
        TextView tvTitle, tvReleaseDate, tvGenre, tvDuration;
        ToggleButton tglFavorite;
        ImageButton btnShare;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.img_cover);
            tvTitle = itemView.findViewById(R.id.tv_movie_title);
            tvReleaseDate = itemView.findViewById(R.id.tv_release_date);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvDuration = itemView.findViewById(R.id.tv_duration);
            tglFavorite = itemView.findViewById(R.id.tgl_favorite);
            btnShare = itemView.findViewById(R.id.btn_share);

        }
    }
}

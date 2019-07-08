package id.xaxxis.moviecatalogue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.xaxxis.moviecatalogue.R;
import id.xaxxis.moviecatalogue.model.Movie;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.MovieViewHolder> {
    private final Context mContext;
    private ArrayList<Movie> movieArrayList;

    public ListMovieAdapter(Context mContext, ArrayList<Movie> movieArrayList) {
        this.mContext = mContext;
        this.movieArrayList = movieArrayList;
    }

    public ArrayList<Movie> getMovieArrayList() {
        return movieArrayList;
    }

    @NonNull
    @Override
    public ListMovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.MovieViewHolder movieViewHolder, int i) {
        Movie movies = getMovieArrayList().get(i);
        Glide.with(mContext)
                .load(movies.getPhotoCover())
                .apply(new RequestOptions())
                .into(movieViewHolder.imgCover);

        movieViewHolder.tvTitle.setText(movies.getTitle());
        movieViewHolder.tvGenre.setText(movies.getGenre());
        movieViewHolder.tvRate.setText(movies.getRating());
        movieViewHolder.tvSimpleDesc.setText(movies.getSynopsis());
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvGenre, tvRate, tvSimpleDesc;
        ImageView imgCover;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.img_movie_cover);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvRate = itemView.findViewById(R.id.tv_rating);
            tvSimpleDesc = itemView.findViewById(R.id.tv_simple_desc);
        }
    }
}

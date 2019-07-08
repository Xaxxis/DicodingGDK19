package id.xaxxis.moviecatalogapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import id.xaxxis.moviecatalogapp.R;
import id.xaxxis.moviecatalogapp.model.Movie;
import id.xaxxis.moviecatalogapp.view.ViewHolder;

public class ListMovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;



    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ListMovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }
}

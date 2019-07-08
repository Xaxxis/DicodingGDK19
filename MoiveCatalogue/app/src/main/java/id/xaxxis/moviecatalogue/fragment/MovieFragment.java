package id.xaxxis.moviecatalogue.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.xaxxis.moviecatalogue.R;
import id.xaxxis.moviecatalogue.adapter.ListMovieAdapter;
import id.xaxxis.moviecatalogue.model.Movie;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private View view;
    private String title;
    private ArrayList<Movie> movieArrayList;

    private ListMovieAdapter listMovieAdapter;

    public MovieFragment newInstance(ArrayList<Movie> movieArrayList) {

        MovieFragment movieFragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("movieArrayList", movieArrayList);
        movieFragment.setArguments(bundle);

        return movieFragment;
    }

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_movie, container, false);
            RecyclerView myRecyclerView = view.findViewById(R.id.rv_item);
            listMovieAdapter = new ListMovieAdapter(getContext(), movieArrayList);
            myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            myRecyclerView.setAdapter(listMovieAdapter);

        }
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString("Title");
            movieArrayList = getArguments().getParcelableArrayList("movieArrayList");
        }

    }


}

package id.xaxxis.moviecatalogue.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import id.xaxxis.moviecatalogue.R;
import id.xaxxis.moviecatalogue.fragment.MovieFragment;
import id.xaxxis.moviecatalogue.model.Movie;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[] {R.string.tab_movie, R.string.tab_tv_show};
    private final Context mContext;
    private ArrayList<Movie> movies;


    public SectionPagerAdapter(Context mContext, FragmentManager fm, ArrayList<Movie> movieArrayList) {
        super(fm);
        this.mContext = mContext;
        this.movies = movieArrayList;
    }

    @Override
    public Fragment getItem(int i) {
        MovieFragment movieFragment = new MovieFragment();
        switch (i){
            case 0:
                return movieFragment.newInstance(movies);
            case 1:
                return movieFragment.newInstance(movies);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}

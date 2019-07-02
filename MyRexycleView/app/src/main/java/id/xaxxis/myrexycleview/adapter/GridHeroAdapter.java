package id.xaxxis.myrexycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.xaxxis.myrexycleview.Model.Hero;
import id.xaxxis.myrexycleview.R;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private final Context context;
    private ArrayList<Hero> heroArrayList;

    public GridHeroAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Hero> getHeroArrayList() {
        return heroArrayList;
    }

    public void setHeroArrayList(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public GridHeroAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hero, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHeroAdapter.GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(heroArrayList.get(i).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(gridViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}

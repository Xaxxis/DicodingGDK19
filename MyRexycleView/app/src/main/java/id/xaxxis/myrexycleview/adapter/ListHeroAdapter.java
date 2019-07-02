package id.xaxxis.myrexycleview.adapter;

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

import id.xaxxis.myrexycleview.Model.Hero;
import id.xaxxis.myrexycleview.R;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.CategoryViewHolder> {
    private final Context context;
    private ArrayList<Hero> heroArrayList;

    public ListHeroAdapter(Context context) {
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
    public ListHeroAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroAdapter.CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getHeroArrayList().get(i).getName());
        categoryViewHolder.tvFrom.setText(getHeroArrayList().get(i).getFrom());
        Glide.with(context).load(getHeroArrayList().get(i).getPhoto())
                .apply(new RequestOptions().override(55,55)).into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getHeroArrayList().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvFrom;
        TextView tvName;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            tvName = itemView.findViewById(R.id.tv_item_name);
        }
    }
}

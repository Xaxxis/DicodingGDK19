package id.xaxxis.myrexycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.xaxxis.myrexycleview.CustomOnItemClickListener;
import id.xaxxis.myrexycleview.Model.Hero;
import id.xaxxis.myrexycleview.R;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder> {
    private final Context context;

    public CardViewHeroAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Hero> heroArrayList;

    public ArrayList<Hero> getHeroArrayList() {
        return heroArrayList;
    }

    public void setHeroArrayList(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public CardViewHeroAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_hero, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHeroAdapter.CardViewHolder cardViewHolder, final int i) {
        Hero hero = getHeroArrayList().get(i);
        Glide.with(context)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvHeroName.setText(hero.getName());
        cardViewHolder.tvHeroFrom.setText(hero.getFrom());

        cardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Ini item favorite ku " +getHeroArrayList().get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        cardViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getHeroArrayList().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getHeroArrayList().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvHeroName, tvHeroFrom;
        Button btnShare, btnFavorite;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvHeroName = itemView.findViewById(R.id.tv_item_name);
            tvHeroFrom = itemView.findViewById(R.id.tv_item_from);
            btnShare = itemView.findViewById(R.id.btn_set_share);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
        }
    }
}

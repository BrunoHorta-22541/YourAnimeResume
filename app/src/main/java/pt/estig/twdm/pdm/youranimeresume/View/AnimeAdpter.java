package pt.estig.twdm.pdm.youranimeresume.View;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.R;

public class AnimeAdpter extends RecyclerView.Adapter<AnimeAdpter.AnimeViewHolder> {
    private List<Anime> animeList;
    private final AnimeAdpterEventListener eventListener;

    public Context context;
    private Drawable imageAnime;
    public AnimeAdpter(AnimeAdpterEventListener eventListener) {
        this.eventListener = eventListener;
        this.animeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public AnimeAdpter.AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.animelist_row, parent, false);
        return new AnimeViewHolder(layout, parent.getContext());
    }



    @Override
    public void onBindViewHolder(@NonNull AnimeAdpter.AnimeViewHolder holder, int position) {
        Anime anime = this.animeList.get(position);
        Glide.with(context)
                .load(anime.getAnimeImage())
                .into(holder.animeImage);
        holder.setAnimeName(anime.getName());
        holder.setSynapse(anime.getSynopis());
        holder.rootView.setOnClickListener(view -> eventListener.onAnimeClicked(anime.getId()));
        holder.rootView.setOnLongClickListener(view -> {
            eventListener.onAnimeLongClicked(anime.getId());
            return true;
        });
    }

    public int getItemCount() {
        return this.animeList.size();
    }

    public void updateAnimeList(List<Anime> allAnime) {
        this.animeList = allAnime;
        notifyDataSetChanged();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private View rootView;
        private TextView animeName;
        private ImageView animeImage;
        private TextView synapse;

        public AnimeViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.context = context;
            this.rootView = rootView;
            this.animeName = itemView.findViewById(R.id.animeName);
            this.animeImage = itemView.findViewById(R.id.animeImage);
            this.synapse = itemView.findViewById(R.id.synapse);
        }
        public void setAnimeName(String animeName) {
            this.animeName.setText(animeName);
        }
        public void setSynapse(String synapse){
            this.synapse.setText(synapse);
        }

    }

    public interface  AnimeAdpterEventListener{
        void onAnimeClicked(long categoryId);

        void onAnimeLongClicked(long categoryId);
    }
}

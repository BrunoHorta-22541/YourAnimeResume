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
    public AnimeAdpter( AnimeAdpterEventListener eventListener,Context context) {
        this.eventListener = eventListener;
        this.animeList = new ArrayList<>();
        this.context= context;
    }

    @NonNull
    @Override
    public AnimeAdpter.AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.animelist_row, parent, false);
        return new AnimeViewHolder(layout, context);
    }



    @Override
    public void onBindViewHolder(@NonNull AnimeAdpter.AnimeViewHolder holder, int position) {
        Anime anime = this.animeList.get(position);
        Glide.with(this.context)
                .load(anime.getImage())
                .into(holder.animeImage);
        holder.setAnimeName(anime.getName());
        holder.rootView.setOnClickListener(view -> eventListener.onAnimeClicked(anime.getId()));
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

        public AnimeViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.context = context;
            this.rootView = rootView;
            this.animeName = itemView.findViewById(R.id.mangaName);
            this.animeImage = itemView.findViewById(R.id.mangaImage);
        }
        public void setAnimeName(String animeName) {
            this.animeName.setText(animeName);
        }

    }

    public interface  AnimeAdpterEventListener{
        void onAnimeClicked(long animeId);

    }
}

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

import pt.estig.twdm.pdm.youranimeresume.Data.Manga;
import pt.estig.twdm.pdm.youranimeresume.R;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder>{
    private List<Manga> mangaList;
    public Context context;
    private Drawable imageManga;
    private final MangaAdapter.MangaAdapterEventListener eventListener;
    public MangaAdapter(MangaAdapterEventListener eventListener,Context context) {
        this.eventListener = eventListener;
        this.mangaList = new ArrayList<>();
        this.context = context;
    }
    @NonNull
    @Override
    public MangaAdapter.MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.manga_list_row, parent, false);
        return new MangaAdapter.MangaViewHolder(layout, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MangaAdapter.MangaViewHolder holder, int position) {
        Manga manga = this.mangaList.get(position);
        Glide.with(this.context)
                .load(manga.getImage())
                .into(holder.mangaImage);
        holder.setMangaName(manga.getName());
        holder.rootView.setOnClickListener(view -> eventListener.onAnimeClicked(manga.getId()));

    }

    @Override
    public int getItemCount() {
        return this.mangaList.size();
    }
    public void updateMangaList(List<Manga> allManga) {
        this.mangaList = allManga;
        notifyDataSetChanged();
    }

    public static class MangaViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private View rootView;
        private TextView mangaName;
        private ImageView mangaImage;

        public MangaViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.context = context;
            this.rootView = rootView;
            this.mangaName = itemView.findViewById(R.id.mangaName);
            this.mangaImage = itemView.findViewById(R.id.mangaImage);
        }
        public void setMangaName(String animeName) {
            this.mangaName.setText(animeName);
        }

    }

    public interface  MangaAdapterEventListener{
        void onAnimeClicked(long mangaId);


    }
}

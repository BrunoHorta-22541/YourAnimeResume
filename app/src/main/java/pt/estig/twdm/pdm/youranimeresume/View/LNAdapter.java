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

import pt.estig.twdm.pdm.youranimeresume.Data.LightNovel;
import pt.estig.twdm.pdm.youranimeresume.R;

public class LNAdapter extends RecyclerView.Adapter<LNAdapter.LNViewHolder>{
    private List<LightNovel> lightNovelList;
    public Context context;
    private Drawable imageManga;
    private final LNAdapter.LNAdapterEventListener eventListener;
    public LNAdapter(LNAdapterEventListener eventListener,Context context) {
        this.eventListener = eventListener;
        this.lightNovelList = new ArrayList<>();
        this.context = context;
    }
    @NonNull
    @Override
    public LNAdapter.LNViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.manga_list_row, parent, false);
        return new LNAdapter.LNViewHolder(layout, context);
    }

    @Override
    public void onBindViewHolder(@NonNull LNAdapter.LNViewHolder holder, int position) {
        LightNovel lightNovel = this.lightNovelList.get(position);
        Glide.with(this.context)
                .load(lightNovel.getImage())
                .into(holder.lNImage);
        holder.setLNName(lightNovel.getName());
        holder.rootView.setOnClickListener(view -> eventListener.onLNClicked(lightNovel.getId()));

    }

    @Override
    public int getItemCount() {
        return this.lightNovelList.size();
    }
    public void updateLNList(List<LightNovel> allLN) {
        this.lightNovelList = allLN;
        notifyDataSetChanged();
    }

    public static class LNViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private View rootView;
        private TextView lNName;
        private ImageView lNImage;

        public LNViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.context = context;
            this.rootView = rootView;
            this.lNName = itemView.findViewById(R.id.mangaName);
            this.lNImage = itemView.findViewById(R.id.mangaImage);
        }
        public void setLNName(String animeName) {
            this.lNName.setText(animeName);
        }

    }

    public interface  LNAdapterEventListener{
        void onLNClicked(long lnId);


    }
}

package pt.estig.twdm.pdm.youranimeresume.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.R;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.AnimeViewModel;


public class AnimeDetailsFragment extends Fragment {

    private TextView animeName,animeAuthor, animeStudio,animeRate, animeSynopsis;
    private ImageView animeImage;
    private AnimeViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_anime_details, container, false);
        this.viewModel = new ViewModelProvider(this).get(AnimeViewModel.class);
        AnimeDetailsFragmentArgs args = AnimeDetailsFragmentArgs.fromBundle(getArguments());
        long animeid = args.getId();
         this.viewModel.getAnimeWTID(animeid);


        animeName = root.findViewById(R.id.animeDetailsName);
        animeAuthor = root.findViewById(R.id.authordetails);
        animeStudio = root.findViewById(R.id.studiodetails);
        animeSynopsis = root.findViewById(R.id.synopsisDetails);
        animeRate = root.findViewById(R.id.rateDetails);
        animeImage = root.findViewById(R.id.animeImageDetails);


        this.viewModel.getAnimeWTID(animeid).observe(requireActivity(), new Observer<Anime>() {
            @Override
            public void onChanged(Anime anime) {
                animeName.setText(anime.getName());
                animeAuthor.setText(anime.getAuthor());
                animeStudio.setText(anime.getStudio());
                animeSynopsis.setText(anime.getSynopis());
                animeRate.setText(String.valueOf(anime.getRate()));
                Glide.with(getContext())
                        .load(anime.getImage())
                        .into(animeImage);
            }
        });






        return root;
    }
}
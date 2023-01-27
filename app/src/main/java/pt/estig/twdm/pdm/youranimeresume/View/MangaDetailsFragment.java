package pt.estig.twdm.pdm.youranimeresume.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;
import pt.estig.twdm.pdm.youranimeresume.R;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.AnimeViewModel;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.MangaViewModel;

public class MangaDetailsFragment extends Fragment {
    private TextView mangaName,mangaAuthor, mangapublisher,mangaRate, mangaSynopsis;
    private ImageView mangaImage;
    private MangaViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_manga_details, container, false);
        this.viewModel = new ViewModelProvider(this).get(MangaViewModel.class);
        AnimeDetailsFragmentArgs args = AnimeDetailsFragmentArgs.fromBundle(getArguments());
        long mangaid = args.getId();
        this.viewModel.getMangaWTID(mangaid);


        mangaName = root.findViewById(R.id.animeDetailsName);
        mangaAuthor = root.findViewById(R.id.authordetails);
        mangapublisher = root.findViewById(R.id.studiodetails);
        mangaSynopsis = root.findViewById(R.id.synopsisDetails);
        mangaRate = root.findViewById(R.id.rateDetails);
        mangaImage = root.findViewById(R.id.animeImageDetails);


        this.viewModel.getMangaWTID(mangaid).observe(requireActivity(), new Observer<Manga>() {
            @Override
            public void onChanged(Manga manga) {
                mangaName.setText(manga.getName());
                mangaAuthor.setText(manga.getAuthor());
                mangapublisher.setText(manga.getPublisher());
                mangaSynopsis.setText(manga.getSynopis());
                mangaRate.setText(String.valueOf(manga.getRate()));
                Glide.with(getContext())
                        .load(manga.getImage())
                        .into(mangaImage);
            }
        });
        return root;
    }
}
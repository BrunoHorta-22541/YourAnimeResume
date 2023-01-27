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

import pt.estig.twdm.pdm.youranimeresume.Data.LightNovel;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;
import pt.estig.twdm.pdm.youranimeresume.R;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.LightNovelViewModel;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.MangaViewModel;


public class LightNovelDetailsFragment extends Fragment {


    private TextView lnName,lnAuthor, lnpublisher,lnRate, lnSynopsis;
    private ImageView lnImage;
    private LightNovelViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_manga_details, container, false);
        this.viewModel = new ViewModelProvider(this).get(LightNovelViewModel.class);
        AnimeDetailsFragmentArgs args = AnimeDetailsFragmentArgs.fromBundle(getArguments());
        long lnid = args.getId();
        this.viewModel.getLNWTID(lnid);


        lnName = root.findViewById(R.id.animeDetailsName);
        lnAuthor = root.findViewById(R.id.authordetails);
        lnpublisher = root.findViewById(R.id.studiodetails);
        lnSynopsis = root.findViewById(R.id.synopsisDetails);
        lnRate = root.findViewById(R.id.rateDetails);
        lnImage = root.findViewById(R.id.animeImageDetails);


        this.viewModel.getLNWTID(lnid).observe(requireActivity(), new Observer<LightNovel>() {
            @Override
            public void onChanged(LightNovel lightNovel) {
                lnName.setText(lightNovel.getName());
                lnAuthor.setText(lightNovel.getAuthor());
                lnpublisher.setText(lightNovel.getPublisher());
                lnSynopsis.setText(lightNovel.getSynopis());
                lnRate.setText(String.valueOf(lightNovel.getRate()));
                Glide.with(getContext())
                        .load(lightNovel.getImage())
                        .into(lnImage);
            }
        });
        return root;
    }
}
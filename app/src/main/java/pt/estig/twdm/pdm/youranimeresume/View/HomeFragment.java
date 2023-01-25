package pt.estig.twdm.pdm.youranimeresume.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.DataSource;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPI;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPIResponse;
import pt.estig.twdm.pdm.youranimeresume.R;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.AnimeViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements AnimeAdpter.AnimeAdpterEventListener {
    private AnimeAdpter adapter;
    private AnimeViewModel viewModel;
    private NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(AnimeViewModel.class);
        navController = NavHostFragment.findNavController(HomeFragment.this);
        RecyclerView recyclerView = root.findViewById(R.id.animeRecyclerView);
        this.adapter = new AnimeAdpter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        //this.updateCategoryList();

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.viewModel.getItems().observe(getViewLifecycleOwner(), animeList -> {
            Log.d("animeList", animeList.toString());
            this.adapter.updateAnimeList(animeList);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.refreshData();
    }

    @Override
    public void onAnimeClicked(long categoryId) {

    }

    @Override
    public void onAnimeLongClicked(long categoryId) {

    }


}
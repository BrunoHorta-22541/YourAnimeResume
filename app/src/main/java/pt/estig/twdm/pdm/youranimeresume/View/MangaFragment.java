package pt.estig.twdm.pdm.youranimeresume.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.estig.twdm.pdm.youranimeresume.R;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.MangaViewModel;


public class MangaFragment extends Fragment{

    private  MangaAdapter adapter;
    private MangaViewModel viewModel;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_manga, container, false);
        this.viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(MangaViewModel.class);
        navController = NavHostFragment.findNavController(MangaFragment.this);
        RecyclerView recyclerView = root.findViewById(R.id.lightRecy);
        this.adapter = new MangaAdapter(new MangaAdapter.MangaAdapterEventListener() {
            @Override
            public void onAnimeClicked(long mangaId) {
                NavDirections action = MangaFragmentDirections.actionMangaFragmentToMangaDetailsFragment(mangaId);
                navController.navigate(action);
            }
        },getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.viewModel.getMangaBYAZ().observe(getViewLifecycleOwner(), mangaList -> {
            this.adapter.updateMangaList(mangaList);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.refreshData();
    }



}
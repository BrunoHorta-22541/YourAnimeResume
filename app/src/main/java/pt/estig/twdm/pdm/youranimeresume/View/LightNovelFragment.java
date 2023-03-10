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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.estig.twdm.pdm.youranimeresume.R;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.AnimeViewModel;
import pt.estig.twdm.pdm.youranimeresume.ViewModels.LightNovelViewModel;


public class LightNovelFragment extends Fragment {

    private LNAdapter adapter;
    private LightNovelViewModel viewModel;
    private NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_light_novel, container, false);
        this.viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(LightNovelViewModel.class);
        navController = NavHostFragment.findNavController(LightNovelFragment.this);
        RecyclerView recyclerView = root.findViewById(R.id.lightRecy);
        this.adapter = new LNAdapter(new LNAdapter.LNAdapterEventListener() {
            @Override
            public void onLNClicked(long lnId) {
                NavDirections action = LightNovelFragmentDirections.actionLightNovelFragmentToLightNovelDetailsFragment(lnId);
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


        this.viewModel.getLNBYAZ().observe(getViewLifecycleOwner(), lnList -> {
            this.adapter.updateLNList(lnList);
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        viewModel.refreshData();
    }

}
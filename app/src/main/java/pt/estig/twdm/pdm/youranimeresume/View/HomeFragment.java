package pt.estig.twdm.pdm.youranimeresume.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.DataSource;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPI;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPIResponse;
import pt.estig.twdm.pdm.youranimeresume.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);


      return root;
    }
    public void refreshList(View view) {
        // Sincrona
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//                    Response<SWAPIApiResponse> response = call.execute();
//                    SWAPIApiResponse swapiResponse = response.body();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            adapter.updateList(swapiResponse.getResults());
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        // Assincrona
        DataSource.getService().getAnime().enqueue(new Callback<JAPI<Anime>>() {
            @Override
            public void onResponse(Call<JAPI<Anime>> call, Response<JAPI<Anime>> response) {
                // Executado na UI Thread
                if (response.isSuccessful()) {
                    JAPIResponse japiResponse = response.body();
                    adapter.updateList(japiResponse.getResults());
                } else {
                    // TODO Mostrar um erro qualquer
                }
            }

            @Override
            public void onFailure(Call<JAPI<Anime>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
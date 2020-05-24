package com.aji.kerjain;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Home_fragment extends Fragment {
    ImageSlider imageSlider;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<List_Item> list_items;
    public static final String URL_DATA = "https://apopomade.000webhostapp.com/tampil_home.php";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSlider=view.findViewById(R.id.slider_home);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://picsum.photos/id/1/600/400"));
        slideModels.add(new SlideModel("https://apopomade.000webhostapp.com/gambar2.jpg"));
        slideModels.add(new SlideModel ("https://apopomade.000webhostapp.com/gambar3.jpg"));
        imageSlider.setImageList(slideModels,true);

        recyclerView = view.findViewById(R.id.rc_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list_items = new ArrayList<>();
        loadRecyclerViewData();
    }//onViewCreated
    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        final StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                           JSONArray array = new JSONArray(s);
                            for (int i=0; i<array.length(); i++ ){
                                JSONObject o = array.getJSONObject(i);
                                List_Item item = new List_Item(
                                        o.getString("nama_pekerjaan"),
                                        "Bayaran : Rp. "+o.getString("bayaran"),
                                        "Lokasi : "+ o.getString("kabupaten")
                                );
                                list_items.add(item);
                            }//endFOR
                            adapter = new MyAdapter(list_items,getContext().getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }//onResponse
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getContext().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }



}

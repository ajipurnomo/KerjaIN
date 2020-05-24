package com.aji.kerjain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class tambah_lowongan extends AppCompatActivity implements View.OnClickListener {
        Spinner bid_kerja;
        Spinner sp_prov;
        Spinner sp_kab;
    ImageView btnBack;
    EditText nama_kerja;
    EditText gaji;
    EditText detail_alamat;
    EditText deskripsi_kerja;
    Button btnTambah;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lowongan);

        progressDialog = new ProgressDialog(tambah_lowongan.this);
        nama_kerja = findViewById(R.id.input_namaPekerjaan);
        bid_kerja = findViewById(R.id.bidang_pekerjaan);
        sp_prov = findViewById(R.id.spin_prov);
        sp_kab = findViewById(R.id.spin_kab);
        gaji = findViewById(R.id.input_gaji);
        detail_alamat = findViewById(R.id.detail_alamat);
        deskripsi_kerja = findViewById(R.id.deskripsi_kerja);
        btnBack =  findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnTambah = findViewById(R.id.btn_tambahkan);
        btnTambah.setOnClickListener(this);



        final String provinsi[] = {"-pilih Provinsi-","Banten","DKI Jakarta","Jawa Barat", "Jawa Tengah", "Jawa Timur"};
        final String bidang[] = {"-pilih bidang-","Admin","Energi & Pertambangan","Keuangan", "Pendidikan", "Media","Teknologi Infomasi","Pemerintahan",
                                "Marketing", "Hukum","Pariwisata","Kesenian", "Manajemen","lainnya.."};
        final String banten[]={"-pilih Kabupaten/Kota-",
                "Kota Cilegon",
                "Kota Tangerang",
                "Kab. Serang",
                "Kab. Tangerang",
                "Kab. Lebak",
                "Kab. Pandeglang"};
        final String dki[]={"-pilih Kabupaten/Kota-","Jakarta Timur",
                "Jakarta Selatan",
                "Jakarta Barat",
                "Jakarta Utara",
                "Jakarta Pusat",
                "Kab.kep.seribu"};
        final String jabar[]={"-pilih Kabupaten/Kota-","Kota Banjar",
                "Kota Tasikmalaya",
                "Kota Cimahi",
                "Kota Depok",
                "Kota Bekasi",
                "Kota Cirebon",
                "Kota Bandung",
                "Kota Sukabumi",
                "Kota Bogor",
                "Kab. Bekasi",
                "Kab. Karawang",
                "Kab. Purwakarta",
                "Kab. Subang",
                "Kab. Indramayu",
                "Kab. Sumedang",
                "Kab. Majalengka",
                "Kab. Cirebon",
                "Kab. Kuningan",
                "Kab. Ciamis",
                "Kab. Tasikmalaya",
                "Kab. Garut",
                "Kab. Bandung",
                "Kab. Cianjur",
                "Kab. Sukabumi",
                "Kab. Bogor"};
        final String jateng[]={"-pilih Kabupaten/Kota-","Kota Tegal",
                "Kota Pekalongan","Kota Semarang", "Kota Salatiga",
                "Kota Surakarta",
                "Kota Magelang",
                "Kab. Brebes",
                "Kab. Tegal",
                "Kab. Pemalang",
                "Kab. Pekalongan","Kab. Batang", "Kab. Kendal",
                "Kab. Temanggung",
                "Kab. Semarang",
                "Kab. Demak",
                "Kab. Jepara",
                "Kab. Kudus",
                "Kab. Pati",
                "Kab. Rembang","Kab. Blora", "Kab. Grobogan",
                "Kab. Sragen",
                "Kab. Karanganyar",
                "Kab. Wonogiri",
                "Kab. Sukoharjo",
                "Kab. Klaten",
                "Kab. Boyolali",
                "Kab. Magelang",
                "Kab. Wonosobo",
                "Kab. Purworejo",
                "Kab. Kebumen",
                "Kab. Banjarnegara",
                "Kab. Purbalingga","Kab. Banyumas", "Kab. Cilacap"};
        final String jatim[]={"-pilih Kabupaten/Kota-","Kota Batu",
                "Kota Surabaya",
                "Kota Madiun",
                "Kota Mojokerto",
                "Kota Pasuruan",
                "Kota Probolinggo",
                "Kota Malang",
                "Kota Blitar",
                "Kota Kediri",
                "Kab. Sumenep",
                "Kab. Pamekasan",
                "Kab. Sampang",
                "Kab. Bangkalan",
                "Kab. Gresik",
                "Kab. Lamongan",
                "Kab. Tuban",
                "Kab. Bojonegoro",
                "Kab. Ngawi",
                "Kab. Magetan",
                "Kab. Madiun",
                "Kab. Nganjuk",
                "Kab. Jombang",
                "Kab. Mojokerto",
                "Kab. Sidoarjo",
                "Kab. Pasuruan",
                "Kab. Probolinggo",
                "Kab. Situbondo",
                "Kab. Bondowoso","Kab. Banyuwangi","Kab. Jember",
                "Kab. Lumajang",
                "Kab. Malang",
                "Kab. Kediri",
                "Kab. Blitar",
                "Kab. Tulungagung",
                "Kab. Trenggalek",
                "Kab. Ponorogo",
                "Kab. Pacitan"};
        final String pilih[]={"-pilih Kabupaten/Kota-"};


        ArrayAdapter<String> adapter_prov = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,provinsi);
        sp_prov.setAdapter(adapter_prov);
        ArrayAdapter<String> adapter_bidang = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,bidang);
        bid_kerja.setAdapter(adapter_bidang);

        sp_prov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String prov_dipilih = provinsi[position];
                if (position==0) {
                    ArrayAdapter<String> suruh_pilih = new ArrayAdapter<String>(
                            tambah_lowongan.this, R.layout.support_simple_spinner_dropdown_item,pilih);
                    sp_kab.setAdapter(suruh_pilih);
                }
                if (position==1) {
                    ArrayAdapter<String> data_banten = new ArrayAdapter<String>(
                            tambah_lowongan.this, R.layout.support_simple_spinner_dropdown_item, banten);
                    sp_kab.setAdapter(data_banten);
                }
                if (position==2){
                    ArrayAdapter<String> data_dki = new ArrayAdapter<String>(
                            tambah_lowongan.this,R.layout.support_simple_spinner_dropdown_item,dki);
                    sp_kab.setAdapter(data_dki);
                }//endIF
                if (position==3){
                    ArrayAdapter<String> data_jabar = new ArrayAdapter<String>(
                            tambah_lowongan.this,R.layout.support_simple_spinner_dropdown_item,jabar);
                    sp_kab.setAdapter(data_jabar);
                }//endIF
                if (position==4){
                    ArrayAdapter<String> data_jateng = new ArrayAdapter<String>(
                            tambah_lowongan.this,R.layout.support_simple_spinner_dropdown_item,jateng);
                    sp_kab.setAdapter(data_jateng);
                }//endIF
                if (position==5){
                    ArrayAdapter<String> data_jatim = new ArrayAdapter<String>(
                            tambah_lowongan.this,R.layout.support_simple_spinner_dropdown_item,jatim);
                    sp_kab.setAdapter(data_jatim);
                }//endIF
            }//on Item Selected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }//override Nothing
        });//on Item Selected Listener
    }//onCreate


   // public void RegisterKerja(View v){

   // }//end VOID

    @Override
    public void onClick(View v) {
        if(v == btnBack){
            onBackPressed();
        }else if(v== btnTambah){
            progressDialog.setMessage("Menambahkan Lowongan...");
            showDialog();
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    "https://apopomade.000webhostapp.com/insert_data.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("success");
                                if (success.equals("1")){
                                    hideDialog();
                                    nama_kerja.setText("");
                                    gaji.setText("");
                                    detail_alamat.setText("");
                                    deskripsi_kerja.setText("");
                                    Toast.makeText(getApplicationContext(),"Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                                }else{
                                    hideDialog();
                                    Toast.makeText(getApplicationContext(),"GAGAL Ditambahkan", Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    hideDialog();
                    Toast.makeText(getApplicationContext(), "Eror : "+error.getMessage(), Toast.LENGTH_LONG).show();
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("nama_kerja",nama_kerja.getText().toString());
                    params.put("bid_kerja",bid_kerja.getSelectedItem().toString());
                    params.put("gaji",gaji.getText().toString());
                    params.put("sp_prov",sp_prov.getSelectedItem().toString());
                    params.put("sp_kab",sp_kab.getSelectedItem().toString());
                    params.put("detail_alamat",detail_alamat.getText().toString());
                    params.put("deskripsi_kerja",deskripsi_kerja.getText().toString());
                    return params;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);










            /*
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    "http://192.168.1.14/kerjain/insert_data.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                //Log.e("anyText",response);
                                String success = jsonObject.getString("success");
                                if (success.equals("1")){
                                    nama_kerja.setText("");
                                    gaji.setText("");
                                    detail_alamat.setText("");
                                    deskripsi_kerja.setText("");
                                    Toast.makeText(getApplicationContext(),"Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(getApplicationContext(),"GAGAL Ditambahkan", Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Eror : "+error.getMessage(), Toast.LENGTH_LONG).show();
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<>();
                    params.put("nama_kerja",nama_kerja.getText().toString());
                    params.put("bid_kerja",bid_kerja.getSelectedItem().toString());
                    params.put("gaji",gaji.getText().toString());
                    params.put("sp_prov",sp_prov.getSelectedItem().toString());
                    params.put("sp_kab",sp_kab.getSelectedItem().toString());
                    params.put("detail_alamat",detail_alamat.getText().toString());
                    params.put("deskripsi",deskripsi_kerja.getText().toString());
                    return params;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);*/
        }
    }//end ON CLICK

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}

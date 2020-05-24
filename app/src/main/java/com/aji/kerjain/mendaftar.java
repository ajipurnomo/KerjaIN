package com.aji.kerjain;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class mendaftar extends AppCompatActivity {
    Spinner spinProv, spinKab;
    EditText email, nama, password, no_ktp;
    RadioGroup rd_jk;
    RadioButton rd_button;
    Button btn_register;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mendaftar);

        progressDialog = new ProgressDialog(mendaftar.this);
        spinProv = findViewById(R.id.spin_prov);
        spinKab = findViewById(R.id.spin_kab);
        email = findViewById(R.id.input_email);
        nama = findViewById(R.id.input_nama);
        password = findViewById(R.id.input_password);
        no_ktp = findViewById(R.id.input_ktp);
        rd_jk = findViewById(R.id.grup_jk);
        btn_register = (Button) findViewById(R.id.btn_daftarkan);


        final String provinsi[] = {"-pilih Provinsi-","Banten","DKI Jakarta","Jawa Barat", "Jawa Tengah", "Jawa Timur"};
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,provinsi);
        spinProv.setAdapter(adapter);
        spinProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String prov_dipilih = provinsi[position];
                if (position==0) {
                    ArrayAdapter<String> suruh_pilih = new ArrayAdapter<String>(
                            mendaftar.this, R.layout.support_simple_spinner_dropdown_item,pilih);
                    spinKab.setAdapter(suruh_pilih);
                }
                if (position==1) {
                    ArrayAdapter<String> data_banten = new ArrayAdapter<String>(
                            mendaftar.this, R.layout.support_simple_spinner_dropdown_item, banten);
                    spinKab.setAdapter(data_banten);
                }
                if (position==2){
                    ArrayAdapter<String> data_dki = new ArrayAdapter<String>(
                            mendaftar.this,R.layout.support_simple_spinner_dropdown_item,dki);
                    spinKab.setAdapter(data_dki);
                }//endIF
                if (position==3){
                    ArrayAdapter<String> data_jabar = new ArrayAdapter<String>(
                            mendaftar.this,R.layout.support_simple_spinner_dropdown_item,jabar);
                    spinKab.setAdapter(data_jabar);
                }//endIF
                if (position==4){
                    ArrayAdapter<String> data_jateng = new ArrayAdapter<String>(
                            mendaftar.this,R.layout.support_simple_spinner_dropdown_item,jateng);
                    spinKab.setAdapter(data_jateng);
                }//endIF
                if (position==5){
                    ArrayAdapter<String> data_jatim = new ArrayAdapter<String>(
                            mendaftar.this,R.layout.support_simple_spinner_dropdown_item,jatim);
                    spinKab.setAdapter(data_jatim);
                }//endIF

            }//on ITEM SELECTED

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }//on Create

    public void Register(View v){
        int selected_jk = rd_jk.getCheckedRadioButtonId();
        String cek_email = email.getText().toString();
        String cek_nama = nama.getText().toString();
        String cek_pass = password.getText().toString();
        String cek_ktp = no_ktp.getText().toString();
        if((selected_jk < 0) || (cek_email==null) || (cek_nama == null) || (cek_pass == null) || (cek_ktp==null)  ){
            Toast.makeText(getApplicationContext(),"Isi Form dengan Benar !", Toast.LENGTH_LONG).show();
        }else{
        progressDialog.setMessage("Sedang Mendaftarkan...");
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://apopomade.000webhostapp.com/daftar.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                hideDialog();
                                nama.setText("");
                                email.setText("");
                                password.setText("");
                                no_ktp.setText("");
                                Toast.makeText(getApplicationContext(),"Anda Berhasil Mendaftar !", Toast.LENGTH_LONG).show();
                            }else{
                                hideDialog();
                                Toast.makeText(getApplicationContext(),"GAGAL Mendaftar !", Toast.LENGTH_LONG).show();
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
                int selected_jk = rd_jk.getCheckedRadioButtonId();
                rd_button = findViewById(selected_jk);

                Map<String,String> params = new HashMap<>();
                params.put("nama",nama.getText().toString());
                params.put("email",email.getText().toString());
                params.put("jk",rd_button.getText().toString());
                params.put("pass",password.getText().toString());
                params.put("prov",spinProv.getSelectedItem().toString());
                params.put("kab",spinKab.getSelectedItem().toString());
                params.put("ktp",no_ktp.getText().toString());
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
        }//end IF VALIDASI
    }//end void REGISTER

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}

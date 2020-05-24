package com.aji.kerjain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Cari_kerja extends AppCompatActivity implements View.OnClickListener{
    Spinner s_prov,s_kab,s_bidang;
    ImageView btn_kembali;
    Button btn_cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_kerja);
        btn_kembali = findViewById(R.id.btn_back);
        s_prov = findViewById(R.id.pilih_prov);
        s_kab = findViewById(R.id.pilih_kab);
        s_bidang = findViewById(R.id.pilih_bidang);
        btn_cari = findViewById(R.id.btn_cari);
        btn_cari.setOnClickListener(this);

        final String provinsi[] = {"-pilih Provinsi-", "Banten", "DKI Jakarta", "Jawa Barat", "Jawa Tengah", "Jawa Timur"};
        final String bidang[] = {"Semua Bidang", "Admin", "Energi & Pertambangan", "Keuangan", "Pendidikan", "Media", "Teknologi Infomasi", "Pemerintahan",
                "Marketing", "Hukum", "Pariwisata", "Kesenian", "Manajemen"};
        final String banten[] = {"Semua Kab/Kota di Banten",
                "Kota Cilegon",
                "Kota Tangerang",
                "Kab. Serang",
                "Kab. Tangerang",
                "Kab. Lebak",
                "Kab. Pandeglang"};
        final String dki[] = {"Semua Kab/Kota di DKI", "Jakarta Timur",
                "Jakarta Selatan",
                "Jakarta Barat",
                "Jakarta Utara",
                "Jakarta Pusat",
                "Kab.kep.seribu"};
        final String jabar[] = {"Semua Kab/Kota di Jawa Barat", "Kota Banjar",
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
        final String jateng[] = {"Semua Kab/Kota di Jawa Tengah", "Kota Tegal",
                "Kota Pekalongan", "Kota Semarang", "Kota Salatiga",
                "Kota Surakarta",
                "Kota Magelang",
                "Kab. Brebes",
                "Kab. Tegal",
                "Kab. Pemalang",
                "Kab. Pekalongan", "Kab. Batang", "Kab. Kendal",
                "Kab. Temanggung",
                "Kab. Semarang",
                "Kab. Demak",
                "Kab. Jepara",
                "Kab. Kudus",
                "Kab. Pati",
                "Kab. Rembang", "Kab. Blora", "Kab. Grobogan",
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
                "Kab. Purbalingga", "Kab. Banyumas", "Kab. Cilacap"};
        final String jatim[] = {"Semua Kab/Kota di Jawa Timur", "Kota Batu",
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
                "Kab. Bondowoso", "Kab. Banyuwangi", "Kab. Jember",
                "Kab. Lumajang",
                "Kab. Malang",
                "Kab. Kediri",
                "Kab. Blitar",
                "Kab. Tulungagung",
                "Kab. Trenggalek",
                "Kab. Ponorogo",
                "Kab. Pacitan"};
        final String pilih[] = {"-pilih Kabupaten/Kota-"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, provinsi);
        ArrayAdapter<String> adapter_prov = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,provinsi);
        s_prov.setAdapter(adapter_prov);
        ArrayAdapter<String> adapter_bidang = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,bidang);
        s_bidang.setAdapter(adapter_bidang);

        s_prov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String prov_dipilih = provinsi[position];
                if (position==0) {
                    ArrayAdapter<String> suruh_pilih = new ArrayAdapter<String>(
                            Cari_kerja.this, R.layout.support_simple_spinner_dropdown_item,pilih);
                    s_kab.setAdapter(suruh_pilih);
                }
                if (position==1) {
                    ArrayAdapter<String> data_banten = new ArrayAdapter<String>(
                            Cari_kerja.this, R.layout.support_simple_spinner_dropdown_item, banten);
                    s_kab.setAdapter(data_banten);
                }
                if (position==2){
                    ArrayAdapter<String> data_dki = new ArrayAdapter<String>(
                            Cari_kerja.this,R.layout.support_simple_spinner_dropdown_item,dki);
                    s_kab.setAdapter(data_dki);
                }//endIF
                if (position==3){
                    ArrayAdapter<String> data_jabar = new ArrayAdapter<String>(
                            Cari_kerja.this,R.layout.support_simple_spinner_dropdown_item,jabar);
                    s_kab.setAdapter(data_jabar);
                }//endIF
                if (position==4){
                    ArrayAdapter<String> data_jateng = new ArrayAdapter<String>(
                            Cari_kerja.this,R.layout.support_simple_spinner_dropdown_item,jateng);
                    s_kab.setAdapter(data_jateng);
                }//endIF
                if (position==5){
                    ArrayAdapter<String> data_jatim = new ArrayAdapter<String>(
                            Cari_kerja.this,R.layout.support_simple_spinner_dropdown_item,jatim);
                    s_kab.setAdapter(data_jatim);
                }//endIF
            }//on Item Selected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }//override Nothing
        });//on Item Selected Listener

        btn_kembali.setOnClickListener(this);
    }//onCreate
    @Override
    public void onClick(View v) {
        if(v == btn_kembali){
            onBackPressed();
        }else if (v == btn_cari){
            Toast.makeText(Cari_kerja.this, "Maaf, Belum Berfungsi", Toast.LENGTH_LONG).show();
        }
    }

}

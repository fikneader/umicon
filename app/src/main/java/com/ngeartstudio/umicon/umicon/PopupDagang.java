package com.ngeartstudio.umicon.umicon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by fikneader on 2/5/2017.
 */

public class PopupDagang  extends AppCompatActivity{

//    EditText jumlahProduk, hargaBeli, biayaTransportasi, keuntungan;
    TextView txtHasil;

    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.popupdagang);
//
//            jumlahProduk = (EditText) findViewById(R.id.jumlahProduk);
//            hargaBeli = (EditText) findViewById(R.id.hargaBeli);
//            biayaTransportasi = (EditText) findViewById(R.id.biayaTransportasi);
//            keuntungan = (EditText) findViewById(R.id.keuntungan);
//              txtHasil = (TextView) findViewById(R.id.txt_hasil);
//
//                String jumlahproduk = jumlahProduk.getText().toString().trim();
//                String hargabeli = hargaBeli.getText().toString().trim();
//                String biayatransportasi = biayaTransportasi.getText().toString().trim();
//                String untung = keuntungan.getText().toString().trim();
//
//                long jp = Long.parseLong(jumlahproduk);
//                long hb = Long.parseLong(hargabeli);
//                long bt = Long.parseLong(biayatransportasi);
//                long u = Long.parseLong(untung);
//                long a = hb + bt;
//                long b = a * (u/100);
//                long c = (a + b) /jp;
//
//                txtHasil.setText("Harga Jual :" + c);


    }
}

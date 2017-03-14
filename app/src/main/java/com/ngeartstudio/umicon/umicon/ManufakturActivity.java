package com.ngeartstudio.umicon.umicon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ManufakturActivity extends AppCompatActivity {
    private EditText biayaKeluar,jumlahProduk, upahTenaga,biayaTransportasi, keuntungan;
    private Button tombolProses;
    private TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufaktur);

        jumlahProduk = (EditText) findViewById(R.id.jumlahProduk);
        if (jumlahProduk.getText().toString().length() == 0)
            jumlahProduk.setError("Jumlah Produk Harus Diisi");
        biayaKeluar = (EditText) findViewById(R.id.biayaKeluar);
        if (biayaKeluar.getText().toString().length() == 0)
            biayaKeluar.setError("Biaya Yang Dikeluarkan Harus Diisi");
        biayaTransportasi = (EditText) findViewById(R.id.biayaTransportasi);
        if (biayaTransportasi.getText().toString().length() == 0)
            biayaTransportasi.setError("Biaya Transportasi Harus Diisi");
        upahTenaga = (EditText) findViewById(R.id.upahTenaga);
        if (upahTenaga.getText().toString().length() == 0)
            upahTenaga.setError("Upah Tenaga Kerja Harus Diisi");
        keuntungan = (EditText) findViewById(R.id.keuntungan);
        if (keuntungan.getText().toString().length() == 0)
            keuntungan.setError("Keuntungan Yang Diharapkan Harus Diisi");
        tombolProses = (Button) findViewById(R.id.tombolProses);
        txtHasil = (TextView) findViewById(R.id.txt_hasil);


        tombolProses.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String jumlahproduk = jumlahProduk.getText().toString().trim();
                String biayakeluar = biayaKeluar.getText().toString().trim();
                String upahtenaga = upahTenaga.getText().toString().trim();
                String biayatransportasi = biayaTransportasi.getText().toString().trim();
                String untung = keuntungan.getText().toString().trim();

                if (TextUtils.isEmpty(jumlahproduk)) {
                    Toast.makeText(getApplicationContext(), "Masukan Jumlah Produk !", Toast.LENGTH_SHORT).show();
                    requestFocus(jumlahProduk);
                    return;
                }

                if (TextUtils.isEmpty(biayakeluar)) {
                    Toast.makeText(getApplicationContext(), "Masukan Biaya Keluar !", Toast.LENGTH_SHORT).show();
                    requestFocus(biayaKeluar);
                    return;
                }
                if (TextUtils.isEmpty(upahtenaga)) {
                    Toast.makeText(getApplicationContext(), "Masukan Upah Tenaga !", Toast.LENGTH_SHORT).show();
                    requestFocus(upahTenaga);
                    return;
                }
                if (TextUtils.isEmpty(biayatransportasi)) {
                    Toast.makeText(getApplicationContext(), "Masukan Biaya Transportasi !", Toast.LENGTH_SHORT).show();
                    requestFocus(biayaTransportasi);
                    return;
                }
                if (TextUtils.isEmpty(untung)) {
                    Toast.makeText(getApplicationContext(), "Masukan Keuntungan !", Toast.LENGTH_SHORT).show();
                    requestFocus(keuntungan);
                    return;
                }

                long jp = Long.parseLong(jumlahproduk);
                long bk = Long.parseLong(biayakeluar);
                long ut = Long.parseLong(upahtenaga);
                long bt = Long.parseLong(biayatransportasi);
                long u = Long.parseLong(untung);
                long a = bk + ut + bt;
                long b = a * (u / 100);
                long c = (a + b) / jp;

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        ManufakturActivity.this);
                builder.setTitle("Hasil Perhitungan");
                builder.setMessage("Harga Jual Produk Adalah Rp " + c);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Log.e("info", "OK");
                                jumlahProduk.setText("");
                                biayaKeluar.setText("");
                                upahTenaga.setText("");
                                biayaTransportasi.setText("");
                                keuntungan.setText("");
                            }
                        });
                builder.show();

                //txtHasil.setText("Harga Jual : Rp " + c);

            }
        });


    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}

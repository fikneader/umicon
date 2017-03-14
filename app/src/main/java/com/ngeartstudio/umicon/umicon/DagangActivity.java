package com.ngeartstudio.umicon.umicon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DagangActivity extends AppCompatActivity {
    private EditText jumlahProduk, hargaBeli, biayaTransportasi, keuntungan;
    private Button tombolProses;
    private TextView txtHasil;
    private Context mContext;
    private Activity mActivity;
    private RelativeLayout mRelativeLayout;
    private PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagang);

        mContext = getApplicationContext();
        mActivity = DagangActivity.this;

        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_dagang);
        jumlahProduk = (EditText) findViewById(R.id.jumlahProduk);
        if (jumlahProduk.getText().toString().length() == 0)
            jumlahProduk.setError("Jumlah Produk Harus Diisi");
        hargaBeli = (EditText) findViewById(R.id.hargaBeli);
        if (hargaBeli.getText().toString().length() == 0)
            hargaBeli.setError("Harga Beli Harus Diisi");
        biayaTransportasi = (EditText) findViewById(R.id.biayaTransportasi);
        if (biayaTransportasi.getText().toString().length() == 0)
            biayaTransportasi.setError("Biaya Transportasi Harus Diisi");
        keuntungan = (EditText) findViewById(R.id.keuntungan);
        if (keuntungan.getText().toString().length() == 0)
            keuntungan.setError("Keuntungan Yang Diharapkan Harus Diisi");
        tombolProses = (Button) findViewById(R.id.tombolProses);
        txtHasil = (TextView) findViewById(R.id.txt_hasil);


        tombolProses.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
//                LayoutInflater layoutInflater
//                        = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
//
//                View customView = layoutInflater.inflate(R.layout.popupdagang, null);
//
//                        mPopupWindow = new PopupWindow(
//                        customView,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT);
//
//                // Call requires API level 21
//                if(Build.VERSION.SDK_INT>=21){
//                    mPopupWindow.setElevation(5.0f);
//                }

//               Button btnClose = (Button) customView.findViewById(R.id.ib_close);
//
//               btnClose.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        mPopupWindow.dismiss();
//                 }});

                String jumlahproduk = jumlahProduk.getText().toString().trim();
                String hargabeli = hargaBeli.getText().toString().trim();
                String biayatransportasi = biayaTransportasi.getText().toString().trim();
                String untung = keuntungan.getText().toString().trim();

                if (TextUtils.isEmpty(jumlahproduk)) {
                    Toast.makeText(getApplicationContext(), "Masukan Jumlah Produk !", Toast.LENGTH_SHORT).show();
                    requestFocus(jumlahProduk);
                    return;
                }

                if (TextUtils.isEmpty(hargabeli)) {
                    Toast.makeText(getApplicationContext(), "Masukan Harga Beli !", Toast.LENGTH_SHORT).show();
                    requestFocus(hargaBeli);
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
                long hb = Long.parseLong(hargabeli);
                long bt = Long.parseLong(biayatransportasi);
                long u = Long.parseLong(untung);
                long a = hb + bt;
                long b = a * (u/100);
                long c = (a + b) /jp;

              //  txtHasil.setText("Harga Jual : Rp " + c);
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        DagangActivity.this);
                builder.setTitle("Hasil Perhitungan");
                builder.setMessage("Harga Jual Produk Adalah Rp " + c);
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Log.e("info", "OK");
                                jumlahProduk.setText("");
                                hargaBeli.setText("");
                                biayaTransportasi.setText("");
                                keuntungan.setText("");
                            }
                        });
                builder.show();

//             mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);

            }
        });

            }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}

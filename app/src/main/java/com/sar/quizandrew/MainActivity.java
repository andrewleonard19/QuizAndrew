package com.sar.quizandrew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nilai_tugas, nilai_quis, nilai_uts, nilai_uas;
    Button hitung, bersihkan;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nilai_tugas = (EditText) findViewById(R.id.nilai_tugas);
        nilai_quis = (EditText) findViewById(R.id.nilai_quis);
        nilai_uts = (EditText) findViewById(R.id.nilai_uts);
        nilai_uas = (EditText) findViewById(R.id.nilai_uas);

        hitung = (Button)findViewById(R.id.hitung);
        bersihkan = (Button) findViewById(R.id.bersihkan);

        hasil = (TextView) findViewById(R.id.hasil);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    int ntg = Integer.parseInt(nilai_tugas.getText().toString());
                    int nqu = Integer.parseInt(nilai_quis.getText().toString());
                    int nut = Integer.parseInt(nilai_uts.getText().toString());
                    int nua = Integer.parseInt(nilai_uas.getText().toString());


                    int tg = (int) (((double) ntg) * 0.20);
                    int qu = (int) (((double) nqu) * 0.20);
                    int ut = (int) (((double) nut) * 0.30);
                    int ua = (int) (((double) nua) * 0.30);

                    int result = tg + qu + ut + ua;
                    hasil.setText(String.valueOf(result));

                } catch (Throwable e){

                    Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan semua nilai!", Toast.LENGTH_LONG);
                    toast.show();

                    e.printStackTrace();
                }
            }
        });

        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai_tugas.setText("");
                nilai_quis.setText("");
                nilai_uts.setText("");
                nilai_uas.setText("");
                hasil.setText("0");
                nilai_tugas.requestFocus();
            }
        });
    }
}

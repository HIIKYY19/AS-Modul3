package com.example.modul3;

import android.content.DialogInterface;
import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    AutoCompleteTextView ac;
    EditText lv;
    String[] stringdatafak = {"Fakultas Ekonomi", "Fakultas Kehutanan", "Fakultas Ilmu Komputer", "Fakultas Hukum", "Fakultas Keguruan dan Ilmu Pendidikan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        lv = (EditText) findViewById(R.id.datalistview);

        ac.addTextChangedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak);
        ac.setAdapter(adapter);

        ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lv.setText(stringdatafak[position]);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void pilihFakultas(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Fakultas Universitas Kuningan");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    protected void onPause() {
        super.onPause();

        // Set the background drawable to the blur drawable
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
    }
}

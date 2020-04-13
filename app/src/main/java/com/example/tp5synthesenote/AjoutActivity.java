package com.example.tp5synthesenote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Hashtable;

public class AjoutActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_article, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sv: Sauvegarder();
                          break;
            case R.id.rt: startActivity(new Intent(this,MainActivity.class));
                          Toast.makeText(this, "Retour", Toast.LENGTH_LONG).show();
                          break;
            case R.id.qt: Quitter();
                          break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void Quitter() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(AjoutActivity.this);
        builder.setMessage("VOULEZ VOUS VRAIEMENT QUITTER L'APPLICATION ?");
        builder.setCancelable(false);
        builder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("OK ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void Sauvegarder() {
        Hashtable<String,String> Element;
        Element = new Hashtable<String,String>();
        Element.put("article",e1.getText().toString());
        Element.put("prix",e2.getText().toString());
        MainActivity.rt=false;
        MainActivity.Articles.add(Element);

    }
}

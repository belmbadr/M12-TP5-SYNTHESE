package com.example.tp5synthesenote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    EditText e3;
    TextView t1;
    TextView t2;
    ListView liste;
    Button b1;
    Button b2;
    static final ArrayList<Hashtable<String,String>> Articles = new ArrayList<Hashtable<String,String>>();
    static boolean rt=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e3=(EditText)findViewById(R.id.e3);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        liste=(ListView)findViewById(R.id.liste);
        if (rt == true) {
        Hashtable<String,String> Element;

        Element = new Hashtable<String,String>();
        Element.put("article","T-Shirt Noir");
        Element.put("prix","260.5");
        Articles.add(Element);

        Element = new Hashtable<String,String>();
        Element.put("article","Bottes Noirs");
        Element.put("prix","460.5");
        Articles.add(Element);

        Element = new Hashtable<String,String>();
        Element.put("article","Bottines");
        Element.put("prix","360.5");
        Articles.add(Element);

        Element = new Hashtable<String,String>();
        Element.put("article","Pants");
        Element.put("prix","300.5");
        Articles.add(Element);

        Element = new Hashtable<String,String>();
        Element.put("article","Chemise");
        Element.put("prix","500.0");
        Articles.add(Element);

        Element = new Hashtable<String,String>();
        Element.put("article","Jellaba");
        Element.put("prix","1260.5");
        Articles.add(Element);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,Articles,
                                                           R.layout.display,
                                                           new String[]{"article","prix"},
                                                           new int[]{R.id.t1,R.id.t2});
         liste.setAdapter(adapter);


        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(getApplicationContext(),AjoutActivity.class);
                In.putExtra("array",Articles);
                startActivity(In);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rech;
                boolean trouver=false;
                rech=e3.getText().toString();
                for (int i=0; i<MainActivity.Articles.size(); i++){
                    if (MainActivity.Articles.get(i).containsValue(rech)) {
                        trouver = true;
                        break;
                    }
                }
                if (!trouver){
                    Toast.makeText(getApplicationContext(),"NON TROUVER",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "TROUVER", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}



package com.example.adilshaikh.arbasedautomativeengineering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainhome extends AppCompatActivity {
    private Button AR,Help,Engine,Con,Sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);
        AR=(Button)findViewById(R.id.ar);
        Help=(Button)findViewById(R.id.help);
        Engine=(Button)findViewById(R.id.engine);
        Con=(Button)findViewById(R.id.con);
        Sign=(Button)findViewById(R.id.signout);

        AR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Mainhome.this, armodels.class);
                startActivity(homeIntent);

            }
        });

        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Mainhome.this, help.class);
                startActivity(homeIntent);


            }
        });

        Engine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Mainhome.this, armodels.class);
                startActivity(homeIntent);


            }
        });

        Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Mainhome.this, contact.class);
                startActivity(homeIntent);

            }
        });

        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }
}

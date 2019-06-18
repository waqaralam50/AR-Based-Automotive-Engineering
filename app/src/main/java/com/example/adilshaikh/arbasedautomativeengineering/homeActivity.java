package com.example.adilshaikh.arbasedautomativeengineering;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class homeActivity extends AppCompatActivity {
    private EditText txtemailaddress, txtpassword;
    private FirebaseAuth firebaseAuth;
private TextView texiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtemailaddress = (EditText) findViewById(R.id.editext);
        txtpassword = (EditText) findViewById(R.id.editext2);
        firebaseAuth = FirebaseAuth.getInstance();
        texiew=(TextView)findViewById(R.id.textiew);
        texiew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(homeActivity.this,Signin.class);


                startActivity(i);

            }
        });
    }
    public void btnlogin(View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(homeActivity.this, "Please wait.....", "Processing...", true);
        firebaseAuth.createUserWithEmailAndPassword(txtemailaddress.getText().toString(), txtpassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(homeActivity.this, "Register Sucessfull ", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(homeActivity.this, Mainhome.class);
                            i.putExtra("user",txtemailaddress.getText().toString());

                            startActivity(i);

                        } else {
                            Toast.makeText(homeActivity.this, "insert email and password", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}

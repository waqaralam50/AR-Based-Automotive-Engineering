package com.example.adilshaikh.arbasedautomativeengineering;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    private EditText txtemailaddress,txtpassword;
    public FirebaseAuth firebaseAuth;
    public TextView textView;
    private Button login2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        txtemailaddress=(EditText)findViewById(R.id.editText);
        txtpassword=(EditText)findViewById(R.id.editText2);
        login2=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        firebaseAuth =FirebaseAuth.getInstance();
        String strUserName = txtemailaddress.getText().toString();


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Signin.this,homeActivity.class);


                startActivity(i);


            }
        });
    }
    public  void  btnlogin(View view){
        final String Name=txtemailaddress.getText().toString();


        final ProgressDialog progressDialog=ProgressDialog.show(Signin.this,"Please wait.....","Processing...",true);
        firebaseAuth.signInWithEmailAndPassword(txtemailaddress.getText().toString(),txtpassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(Signin.this,"Login Sucessful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(Signin.this,Mainhome.class);


                            startActivity(i);

                        }
                        else {

                            Toast.makeText(Signin.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });
        }



    }


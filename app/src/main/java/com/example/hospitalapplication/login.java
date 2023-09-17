package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalapplication.databinding.ActivityLoginBinding;

public class login extends AppCompatActivity {

    ActivityLoginBinding binding;
    /*EditText name,pass;
    Button login;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        //name = (EditText)findViewById(R.id.username);
        //pass = (EditText)findViewById(R.id.pass);
        //login = (Button) findViewById(R.id.btnlogin);
        DBhospital dBhospital = new DBhospital(this);

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e = binding.email.getEditText().getText().toString();
                String p = binding.pass.getEditText().getText().toString();

                if(e.equals("")||p.equals(""))
                {
                    Toast.makeText(login.this, "Please enter all fields..!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkemailpass = dBhospital.checkemailpass(e,p);
                    if(checkemailpass==true)
                    {
                        Toast.makeText(login.this, "Login Successfully..!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),home_page.class);
//                        intent.putExtra("email",e);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    /*public void onBackPressed(){
        finish();
    }*/
}
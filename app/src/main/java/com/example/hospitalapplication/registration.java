package com.example.hospitalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hospitalapplication.databinding.ActivityRegistrationBinding;

public class registration extends AppCompatActivity {

    ActivityRegistrationBinding binding;
   /* EditText name ,gender, dob, pno, pass, confpass;
    Button reg;*/
    DBhospital dBhospital;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistrationBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        /*name= findViewById(R.id.name);
        gender= findViewById(R.id.gender);
        dob= findViewById(R.id.dob);
        pno= findViewById(R.id.pno);
        pass= findViewById(R.id.pass);
        confpass= findViewById(R.id.confpass);
        reg= findViewById(R.id.btnreg);*/
        dBhospital = new DBhospital(this);

        binding.btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = binding.name.getEditText().getText().toString();
                String e  = binding.email.getEditText().getText().toString();
                String pa  = binding.pass.getEditText().getText().toString();
                String cp  = binding.confpass.getEditText().getText().toString();

                if(n.equals("")||e.equals("")||pa.equals("")||cp.equals("")){
                    Toast.makeText(registration.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pa.equals(cp))
                    {
                        Boolean checkemail = dBhospital.checkemail(e);
                        if(checkemail==false)
                        {
                            Boolean insert = dBhospital.insertData(n,e,pa,cp);
                            if(insert==true)
                            {
                                Toast.makeText(registration.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username",n);
                                editor.apply();
                                Intent intent = new Intent(getApplicationContext(),home_page.class);
                                startActivity(intent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(registration.this, "User Already Exists Please login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(registration.this, "Password not matching..!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void onBackPressed(){
        //finish();
        startActivity(new Intent(registration.this,MainActivity.class));
    }

}
package com.example.dataverifyvalidate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class validationsuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validationsuccess);

        Intent intent = getIntent();

        String empname = intent.getStringExtra("urname");
        TextView name = (TextView) findViewById(R.id.personname);
        name.setText(empname);

        String empsal = intent.getStringExtra("ursal");
        TextView salary = (TextView) findViewById(R.id.personsalary);
        salary.setText(empsal);


        String urdept = intent.getStringExtra("urdept");
        TextView department = (TextView) findViewById(R.id.persondepartment);
        department.setText(urdept);


        String urrole = intent.getStringExtra("urrole");
        TextView role = (TextView) findViewById(R.id.personrole);
        role.setText(urrole);

        Button email = (Button) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onemail();
            }
        });
        Button sms = (Button) findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onsms();
            }
        });
    }
    protected void onemail(){

        Intent mailintent = new Intent(Intent.ACTION_SEND);
        mailintent.setData(Uri.parse("mailto:"));
        startActivity(mailintent);

    }
    protected void onsms(){
        Intent smsintent = new Intent(Intent.ACTION_SEND);
        smsintent.setData(Uri.parse("sms:"));
        startActivity(smsintent);

    }

}

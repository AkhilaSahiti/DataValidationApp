package com.example.dataverifyvalidate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

    }
}

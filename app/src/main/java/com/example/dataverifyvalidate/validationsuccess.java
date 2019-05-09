package com.example.dataverifyvalidate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class validationsuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validationsuccess);

        Bundle b =getIntent().getExtras();
        Intent intent = getIntent();

        String empname = intent.getStringExtra("urname");
        TextView name = (TextView) findViewById(R.id.personname);
        name.setText(empname);

        /*int empsal = getIntent().getExtras().getInt("ursal");
        int empsal = getIntent().getIntExtra("ursal",0);
        TextView salary = (TextView) findViewById(R.id.salary);
        salary.setText(empsal);*/



        TextView department = (TextView) findViewById(R.id.persondepartment);
        //TextView role = (TextView) findViewById(R.id.personrole);

        //int empsal = intent.getIntExtra("ursal",0);
        // int empsal = b.getInt("ursal",0);


        department.setText(b.getCharSequence("urdept"));

        //role.setText(b.getCharSequence("personrole"));


    }
}

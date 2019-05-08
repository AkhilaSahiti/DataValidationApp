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
        TextView name = (TextView) findViewById(R.id.personname);
        TextView department = (TextView) findViewById(R.id.persondepartment);
        TextView role = (TextView) findViewById(R.id.personrole);
        TextView salary = (TextView) findViewById(R.id.salary);

        name.setText(b.getCharSequence("personname"));
        department.setText(b.getCharSequence("persondepartment"));
        role.setText(b.getCharSequence("personrole"));
        salary.setText(b.getCharSequence("salary"));

    }
}

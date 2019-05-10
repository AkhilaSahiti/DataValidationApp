package com.example.dataverifyvalidate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner dept, roles;
    Button dispbtn;
    private EditText entername, sal;
    private double salary;
    private String vname, vdept, vrole, vsal, currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDisplay(View view) {

        entername = (EditText) findViewById(R.id.enter_name);
        dept = (Spinner) findViewById(R.id.dept);
        roles = (Spinner) findViewById(R.id.roles);
        sal = (EditText) findViewById(R.id.sal);


        dispbtn = (Button) findViewById(R.id.display);
        dispbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDataEntered()) {
                    aftervalidation();
                } else {
                    checkDataEntered();
                }
            }
        });

    }

    public boolean checkDataEntered() {
        boolean valid = true;

        vname = entername.getText().toString();
        vdept = dept.getSelectedItem().toString().trim();
        vrole = roles.getSelectedItem().toString().trim();
        vsal = sal.getText().toString();


        if (vname.length() < 3 || vname.isEmpty()) {
            Toast toast = Toast.makeText(this, "Name should contain atleast 3 letters!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (vdept.equalsIgnoreCase("Choose any") || vdept.isEmpty()) {
            Toast toast = Toast.makeText(this, "Choose any Department!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else if (vrole.equalsIgnoreCase("Choose any") || vrole.isEmpty()) {
            Toast toast = Toast.makeText(this, "Choose any one Role!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        } else {
            if (vsal.isEmpty()) {
                Toast toast = Toast.makeText(this, "Enter valid amount!", Toast.LENGTH_SHORT);
                toast.show();
                valid = false;
            } else {
                salary = Double.parseDouble(vsal);
                if (salary < 20000 || salary > 25000 || salary == 0) {
                    Toast toast = Toast.makeText(this, "Enter valid amount!", Toast.LENGTH_SHORT);
                    toast.show();
                    valid = false;
                } else {
                    Locale locale = Locale.US;
                    Currency currencyx = Currency.getInstance(locale);
                    String getSymbol = currencyx.getSymbol(locale);
                    currency = NumberFormat.getInstance(Locale.US).format(salary).concat(getSymbol);
                }
            }
        }
        return valid;
    }


    public void aftervalidation() {
        Intent intent = new Intent(getApplicationContext(), validationsuccess.class);
        intent.setType("text/plain");
        intent.putExtra("urname", entername.getText().toString());
        intent.putExtra("urdept", dept.getSelectedItem().toString());
        intent.putExtra("urrole", roles.getSelectedItem().toString());
        intent.putExtra("ursal", currency);
        startActivity(intent);


    }


}




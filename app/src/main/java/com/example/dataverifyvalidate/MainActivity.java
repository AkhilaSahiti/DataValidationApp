package com.example.dataverifyvalidate;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int currentitem1=0;
    int currentitem2=0;
    private EditText entername,sal;
    private String vname, vdept, vrole, vsal;
    Spinner dept,roles;
    Button dispbtn;

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

                if(checkDataEntered()){
                    aftervalidation();
                }
                else{
                    checkDataEntered();
                }
            }
        });

    }
    public void aftervalidation() {
        Intent intent = new Intent(getApplicationContext(), validationsuccess.class);
        intent.setType("text/plain");
        intent.putExtra("urname", entername.getText().toString());
        /*int ursal=Integer.valueOf(vsal);
        vsal = sal.getText().toString().trim();
        int vsall=Integer.parseInt(vsal);
        intent.putExtra("ursal",vsall);*/
        startActivity(intent);
        spinnervalidation();
    }

    public void spinnervalidation(){
        dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentitem1==position){
                    return;
                }
                else{
                    String urdept =dept.getSelectedItem().toString();
                    Intent intent= new Intent(MainActivity.this,validationsuccess.class);
                    intent.putExtra("urdept",urdept);
                    startActivity(intent);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*roles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentitem2==position){
                    return;
                }
                else{

                    Intent intent= new Intent(MainActivity.this,validationsuccess.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    public boolean checkDataEntered(){
        boolean valid = true;

        vname = entername.getText().toString().trim();
        vdept = dept.getSelectedItem().toString().trim();
        vrole = roles.getSelectedItem().toString().trim();
        vsal = sal.getText().toString().trim();

        if (vname.length()<3|| vname.isEmpty()) {
            Toast toast = Toast.makeText(this, "Name should contain atleast 3 letters!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        }
        if (vdept.equalsIgnoreCase("Choose any")) {
            Toast toast = Toast.makeText(this, "Choose any Department!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        }
        if (vrole.equalsIgnoreCase("Choose any")) {
            Toast toast = Toast.makeText(this, "Choose any one Role!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        }
        if (Integer.valueOf(vsal) < 20000 || Integer.valueOf(vsal) > 25000) {
            Toast toast = Toast.makeText(this, "Enter valid amount!", Toast.LENGTH_SHORT);
            toast.show();
            valid = false;
        }
        return valid;
    }
}

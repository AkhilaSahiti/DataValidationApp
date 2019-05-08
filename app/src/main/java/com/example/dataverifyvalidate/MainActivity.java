package com.example.dataverifyvalidate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private String vname, vdept, vrole, vsal;
    Button ondisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ondisplay = (Button) findViewById(R.id.display);
       // ondisplay.setOnClickListener(new View.OnClickListener() {
            //@Override
                // });
    }

    public void onDisplay(View view) {
        TextView name = (TextView) findViewById(R.id.name);
        EditText enter_name = (EditText) findViewById(R.id.enter_name);

        TextView department = (TextView) findViewById(R.id.department);
        Spinner dept = (Spinner) findViewById(R.id.dept);
        String deptType = String.valueOf(dept.getSelectedItem());

        TextView role = (TextView) findViewById(R.id.role);
        Spinner roles = (Spinner) findViewById(R.id.roles);
        String roleType = String.valueOf(roles.getSelectedItem());

        TextView salary = (TextView) findViewById(R.id.salary);
        EditText sal = (EditText) findViewById(R.id.sal);

        vname = enter_name.getText().toString().trim();
        vdept = department.getText().toString().trim();
        vrole = role.getText().toString().trim();
        vsal = sal.getText().toString().trim();

        checkDataEntered();
    }

    void checkDataEntered(){
            if (vname.isEmpty() || vname.length() < 3) {
                Toast toast = Toast.makeText(this, "Name should contain atleast 3 letters!", Toast.LENGTH_SHORT);
                toast.show();
               // valid = false;
            }
            if (vdept.equalsIgnoreCase("Choose any")) {
                Toast toast = Toast.makeText(this, "Can`t be empty!", Toast.LENGTH_SHORT);
                toast.show();
                //valid = false;
            }
            if (vrole.equalsIgnoreCase("Choose any")) {
                Toast toast = Toast.makeText(this, "Cannot be empty!", Toast.LENGTH_SHORT);
                toast.show();
                //valid = false;
            }
            if (Integer.valueOf(vsal) < 20000 || Integer.valueOf(vsal) > 25000) {
                Toast toast = Toast.makeText(this, "Enter valid amount!", Toast.LENGTH_SHORT);
                toast.show();
                //valid = false;
            }
            //return valid;
        }
}

package com.example.sushamapatekar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class AddCustomerActivity extends AppCompatActivity {

    EditText FName, lName , contactN, updateold, updatenew, delete;;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        FName = (EditText) findViewById(R.id.etFirstName);
        lName= (EditText) findViewById(R.id.lastName);
        contactN= (EditText) findViewById(R.id.contactNo);

        helper = new myDbAdapter(this);
        //addUser();
    }

    public void addUser(View view)
    {
        String t1 = FName.getText().toString();
        String t2 = lName.getText().toString();
        String t3 = contactN.getText().toString();
        if(t1.isEmpty() || t2.isEmpty() || t3.isEmpty())
        {
           // Toast.makeText(AddCustomerActivity.this, "Enter First name and last name", Toast.LENGTH_SHORT);

            Message.message(getApplicationContext(),"Enter all firstName, lastName and Contact Number");
        }
        else {
            long id = helper.insertData(t1, t2, t3);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                FName.setText("");
                lName.setText("");
                contactN.setText("");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
                FName.setText("");
                lName.setText("");
                contactN.setText("");
            }
        }
    }

    public void viewdata(View view)
    {
       // String data = helper.getData();
        //Message.message(this,data);
    }

    public void update( View view)
    {
        String u1 = updateold.getText().toString();
        String u2 = updatenew.getText().toString();
        if(u1.isEmpty() || u2.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Data");
        }
        else
        {
            int a= helper.updateName( u1, u2);
            if(a<=0)
            {
                Message.message(getApplicationContext(),"Unsuccessful");
                updateold.setText("");
                updatenew.setText("");
            } else {
                Message.message(getApplicationContext(),"Updated");
                updateold.setText("");
                updatenew.setText("");
            }
        }

    }

    public void delete( View view)
    {
        String uname = delete.getText().toString();
        if(uname.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Data");
        }
        else{
            int a= helper.delete(uname);
            if(a<=0)
            {
                Message.message(getApplicationContext(),"Unsuccessful");
                delete.setText("");
            }
            else
            {
                Message.message(this, "DELETED");
                delete.setText("");
            }
        }
    }
}

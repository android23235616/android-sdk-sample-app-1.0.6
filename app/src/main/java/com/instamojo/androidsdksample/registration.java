package com.instamojo.androidsdksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.InetAddress;

public class registration extends AppCompatActivity {

    EditText name,adhar,phone;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initialize();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_internet())
                {
                    register_python();
                }
            }
        });

    }

    private void register_python() {
    }

    private boolean check_internet() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    private void initialize() {
        name=(EditText)findViewById(R.id.name);
        adhar=(EditText)findViewById(R.id.aadhar);
        phone=(EditText)findViewById(R.id.phone);
        register=(Button)findViewById(R.id.register);
    }
}

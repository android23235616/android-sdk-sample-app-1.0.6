package com.instamojo.androidsdksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.InetAddress;

public class login extends AppCompatActivity {
    //phone number
    //email
    //name
    //mobile number
    TextView phone,email,name,password;Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_internet_connection())
                {

                }
            }
        });

    }

    private boolean check_internet_connection() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }

    }

    private void initialize() {
        phone=(TextView) findViewById(R.id.phone);
        email=(TextView) findViewById(R.id.email);
        name=(TextView) findViewById(R.id.name);
        password=(TextView) findViewById(R.id.password);
        register=(Button) findViewById(R.id.Register);

    }
}

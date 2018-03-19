package com.instamojo.androidsdksample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.net.InetAddress;

public class login extends AppCompatActivity {
    //phone number
    //email
    //name
    //mobile number
    EditText name,password;
    Button register;

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
                    String ssoid=name.getText().toString();
                    String pass=password.getText().toString();
                    if(ssoid.trim().length()>0 && pass.trim().length()>0)
                    {
                        register_python(ssoid,pass);
                    }
                    else
                    {
                        Toast.makeText(login.this, "Kindly enter the proper details", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    private void register_python(String ssoid, String pass) {


        StringRequest strngrqst=new StringRequest(Request.Method.GET, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue a= Volley.newRequestQueue(getApplicationContext());
        a.add(strngrqst);

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

        name=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.password);
        register=(Button) findViewById(R.id.Register);

    }
}

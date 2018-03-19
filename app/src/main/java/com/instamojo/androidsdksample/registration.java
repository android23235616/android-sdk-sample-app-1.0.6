package com.instamojo.androidsdksample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.InetAddress;

public class registration extends AppCompatActivity {

    EditText name,adhar,phone,username;
    Button register;
    ProgressDialog progress;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Account");

        initialize();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check_internet())
                {

                    Toast.makeText(registration.this, "Processing", Toast.LENGTH_SHORT).show();
                    String uname=username.getText().toString();
                    String nme=name.getText().toString();
                    String phn=phone.getText().toString();
                    String adha=adhar.getText().toString();
                    register_python(uname,nme,phn,adha);
                    progress.show();
                }
            }
        });

    }

    private void register_python(String uname, String nme, String phn, String adha) {

        StringRequest st=new StringRequest(Request.Method.GET, Constants.url_registration+"?username="+uname+"&name="+nme+"&mobile="+phn+"&ssos="+adha+"&pwd="+"1234", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(progress.isShowing())
                {
                    progress.dismiss();
                }
                Toast.makeText(registration.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(progress.isShowing())
                {
                    progress.dismiss();
                }
                Toast.makeText(registration.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue as= Volley.newRequestQueue(getApplicationContext());
        as.add(st);
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
        username=(EditText) findViewById(R.id.username);
        register=(Button)findViewById(R.id.register);
        progress=new ProgressDialog(getApplicationContext());
        progress.setMessage("Please Wait");
    }
}

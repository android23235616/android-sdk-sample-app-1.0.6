package com.instamojo.androidsdksample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.InetAddress;

public class login extends AppCompatActivity {
    //phone number
    //email
    //name
    //mobile number
    EditText etMobile,etUserName,etOTP;
    Button btnLogin, btnVerifyOTP;

    RelativeLayout loginLayout, otpLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_internet_connection())
                {   final String username, mobile;
                    username = etUserName.getText().toString();
                    mobile = etMobile.getText().toString();

                    AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                    builder.setTitle("Message");
                    builder.setMessage("OTP will be sent to +91-"+mobile+" for verification. Do you want to continue?");
                    builder.setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startLogin(username, mobile);
                        }
                    });

                    builder.setNegativeButton("CANCEL", null);

                    builder.show();

                }
            }
        });


        btnVerifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = etOTP.getText().toString();
                verifyOTP(otp);
            }
        });

    }

    private void startLogin(String username, String mobile) {
        ///////////////////To Do: CODE TO SEND OTP///////////////////



    }

    private void verifyOTP(String otp){
        //////////////////To Do: CODE TO VERIFY OTP///////////////////


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

        etUserName=(EditText) findViewById(R.id.name);
        etMobile = (EditText) findViewById(R.id.mobile);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        etOTP = (EditText) findViewById(R.id.otp);
        btnVerifyOTP = (Button) findViewById(R.id.btnVerifyOTP);
        loginLayout = (RelativeLayout)findViewById(R.id.login_details_layout);
        otpLayout = (RelativeLayout)findViewById(R.id.otp_layout);

        // Set visibilities:
        loginLayout.setVisibility(View.VISIBLE);
        otpLayout.setVisibility(View.GONE);
    }
    
}

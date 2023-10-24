package com.example.androidproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<UserModel> UserModelArrayList;
    EditText userEmail;
    EditText userPassword;
    Button loginBtn,registerBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userEmail=findViewById(R.id.user_email);
        userPassword=findViewById(R.id.user_password);
        loginBtn=findViewById(R.id.login_btn);
        UserModelArrayList = new ArrayList<>();
        registerBtn=findViewById(R.id.redirect_to_registeration);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler = new DBHandler(MainActivity2.this);
                // getting our course array
                // list from db handler class.
                UserModelArrayList = dbHandler.readUsers();
                String user="";
                int loginFlag=0;
                for (int i = 0; i < UserModelArrayList.size(); i++) {
                    UserModel model = UserModelArrayList.get(i);
                    if (userEmail.getText().toString().equals(model.getUserEmail().toString()) && userPassword.getText().toString().equals(model.getUserPassword().toString())) {
                        user=userEmail.getText().toString();

                        loginFlag = 1;
                        break;
                    }
                }
                if(loginFlag==1){
                    Log.d("", "onClick: "+user);
                    Toast.makeText(MainActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(MainActivity2.this, MainActivity3.class);
                    i2.putExtra("user", user);
                    startActivity(i2);}
                else
                    Toast.makeText(MainActivity2.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();}

        });
    }
}
package com.example.androidproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText newNameEdt, newEmailEdt , newPasswordEdt, newMobilenoEdt;
    private Button newUserBtn,loginPageBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        newNameEdt=findViewById(R.id.new_name);
        newEmailEdt=findViewById(R.id.new_email);
        newPasswordEdt=findViewById(R.id.new_password);
        newMobilenoEdt=findViewById(R.id.new_mobileno);
        newUserBtn = findViewById(R.id.new_user_btn);
        loginPageBtn=findViewById(R.id.login_page_btn);
        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String Name = newNameEdt.getText().toString();
                String Email = newEmailEdt.getText().toString();
                String Password = newPasswordEdt.getText().toString();
                String Mobileno = newMobilenoEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (Name.isEmpty() && Email.isEmpty() && Password.isEmpty() && Mobileno.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(Name, Email, Password,Mobileno);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                newNameEdt.setText("");
                newEmailEdt.setText("");
                newPasswordEdt.setText("");
                newMobilenoEdt.setText("");
            }
        });

        loginPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}

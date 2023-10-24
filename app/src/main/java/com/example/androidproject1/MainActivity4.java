package com.example.androidproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText InputBookName;
    EditText InputAuthor;
    EditText InputQuantity;
    EditText InputPrice;
    Button SubmitBookBtn,cancelBtn;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent=getIntent();
        String user= intent.getStringExtra("user");
        InputBookName=findViewById(R.id.enter_bookname);
        InputAuthor=findViewById(R.id.enter_author);
        InputQuantity=findViewById(R.id.enter_quantity);
        InputPrice=findViewById(R.id.enter_price);
        SubmitBookBtn=findViewById(R.id.submit_Book_btn);
        cancelBtn=findViewById(R.id.cancel_add_book);
        dbHandler = new DBHandler(MainActivity4.this);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome = new Intent(MainActivity4.this, MainActivity5.class);
                backtohome.putExtra("user", user);
                startActivity(backtohome);
            }
        });
        SubmitBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BookName = InputBookName.getText().toString();
                String Author = InputAuthor.getText().toString();
                String Quantity = InputQuantity.getText().toString();
                String Price = InputPrice.getText().toString();

                // validating if the text fields are empty or not.
                if (BookName.isEmpty() && Author.isEmpty() && Quantity.isEmpty() && Price.isEmpty()) {
                    Toast.makeText(MainActivity4.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewBook(BookName,Author,Integer.parseInt(Quantity),Integer.parseInt(Price),user);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity4.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                InputBookName.setText("");
                InputAuthor.setText("");
                InputQuantity.setText("");
                InputPrice.setText("");
                Intent backtohome = new Intent(MainActivity4.this, MainActivity3.class);
                backtohome.putExtra("user", user);
                startActivity(backtohome);
            }
        });
    }
}
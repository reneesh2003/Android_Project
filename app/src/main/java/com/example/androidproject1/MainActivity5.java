package com.example.androidproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity5 extends AppCompatActivity {

    private ArrayList<BookModel> BookModelArrayList;
    private DBHandler dbHandler;
    private BookRVAdapter1 BookRVAdapter1;
    private RecyclerView BookRV;
    Button backtohomebtn,addbooksbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent=getIntent();
        String user= intent.getStringExtra("user");
        Log.d("", "onCreate5: "+user);
        // initializing our all variables.
        BookModelArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity5.this);

        // getting our course array
        // list from db handler class.
        BookModelArrayList = dbHandler.readSellerBooks(user);
        // on below line passing our array list to our adapter class.
        BookRVAdapter1 = new BookRVAdapter1(BookModelArrayList, MainActivity5.this);
        BookRV = findViewById(R.id.RVBooks1);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity5.this, RecyclerView.VERTICAL, false);
        BookRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        BookRV.setAdapter(BookRVAdapter1);
        addbooksbtn=findViewById(R.id.add_book_btn);
        addbooksbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(MainActivity5.this, MainActivity4.class);
                add.putExtra("user",user);
                startActivity(add);
            }
        });
        backtohomebtn=findViewById(R.id.sellbooks_to_home);
        backtohomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome = new Intent(MainActivity5.this, MainActivity3.class);
                backtohome.putExtra("user",user);
                startActivity(backtohome);
            }
        });
    }
}
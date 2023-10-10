package com.example.androidproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<BookModel> BookModelArrayList;
    private DBHandler dbHandler;
    private BookRVAdapter BookRVAdapter;
    private RecyclerView BookRV;
    Button sellBookbtn,myOrdersbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        String user= intent.getStringExtra("user");
        Log.d("", "onCreate: "+user);


        // initializing our all variables.
        BookModelArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity3.this);

        // getting our course array
        // list from db handler class.
        BookModelArrayList = dbHandler.readBooks();
        // on below line passing our array list to our adapter class.
        BookRVAdapter = new BookRVAdapter(BookModelArrayList, MainActivity3.this,user);
        BookRV = findViewById(R.id.RVBooks);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity3.this, RecyclerView.VERTICAL, false);
        BookRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        BookRV.setAdapter(BookRVAdapter);
        sellBookbtn=findViewById(R.id.sell_books);
        sellBookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SellBooks = new Intent(MainActivity3.this, MainActivity5.class);
                SellBooks.putExtra("user",user);
                Log.d("", "onCreate: "+user);
                startActivity(SellBooks);
            }
        });
        myOrdersbtn=findViewById(R.id.my_orders);
        myOrdersbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myorders = new Intent(MainActivity3.this, MainActivity6.class);
                myorders.putExtra("user",user);
                startActivity(myorders);
            }
        });
    }
}

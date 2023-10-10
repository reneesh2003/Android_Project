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


public class MainActivity6 extends AppCompatActivity {

    private ArrayList<OrderModel> OrderModelArrayList;
    private DBHandler dbHandler;
    private OrderRVAdapter OrderRVAdapter;
    private RecyclerView BookRV;
    Button backtohomebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent intent=getIntent();
        String user= intent.getStringExtra("user");
        // initializing our all variables.
        OrderModelArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity6.this);

        // getting our course array
        // list from db handler class.
        OrderModelArrayList = dbHandler.readUserOrders(user);

        // on below line passing our array list to our adapter class.
        OrderRVAdapter = new OrderRVAdapter(OrderModelArrayList, MainActivity6.this);
        BookRV = findViewById(R.id.RVBooks2);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity6.this, RecyclerView.VERTICAL, false);
        BookRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        BookRV.setAdapter(OrderRVAdapter);
        backtohomebtn=findViewById(R.id.myorder_to_home_btn);
        backtohomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome = new Intent(MainActivity6.this, MainActivity3.class);
                backtohome.putExtra("user",user);
                startActivity(backtohome);
            }
        });
    }
}
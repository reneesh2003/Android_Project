package com.example.androidproject1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRVAdapter extends RecyclerView.Adapter<OrderRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<OrderModel> OrderModelArrayList;
    private Context context;

    // constructor
    public OrderRVAdapter(ArrayList<OrderModel> OrderModelArrayList, Context context) {
        this.OrderModelArrayList = OrderModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_item3, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        OrderModel modal = OrderModelArrayList.get(position);
        holder.bookName.setText(modal.getBookBookname());
        holder.bookAuthor.setText(modal.getBookAuthor());
        holder.bookPrice.setText(""+modal.getBookPrice());

        holder.removeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dbHandler.deleteOrder(""+modal.getOrderId());
            OrderModelArrayList.remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());}
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return OrderModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView bookName,bookAuthor,bookPrice;
        Button removeOrder;
        DBHandler dbHandler=new DBHandler(context);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            bookName = itemView.findViewById(R.id.bookName);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookPrice = itemView.findViewById(R.id.bookPrice);
            removeOrder=itemView.findViewById(R.id.removeOrder);

        }

    }
}

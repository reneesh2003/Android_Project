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

public class BookRVAdapter extends RecyclerView.Adapter<BookRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<BookModel> BookModelArrayList;
    private Context context;
    String user;

    // constructor
    public BookRVAdapter(ArrayList<BookModel> BookModelArrayList, Context context,String user) {
        this.BookModelArrayList = BookModelArrayList;
        this.context = context;
        this.user=user;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        BookModel modal = BookModelArrayList.get(position);
        holder.bookName.setText(modal.getBookBookname());
        holder.bookAuthor.setText(modal.getBookAuthor());
        holder.bookQuantity.setText(""+modal.getBookQuantity());
        holder.bookPrice.setText(""+modal.getBookPrice());

        holder.buyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dbHandler.BuyBook(modal.getBookBookname(), modal.getBookAuthor(), modal.getBookQuantity(), modal.getBookPrice(),user);
                BookModelArrayList.get(holder.getAdapterPosition()).setBookQuantity(modal.getBookQuantity()-1);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return BookModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView bookName,bookAuthor,bookQuantity,bookPrice;
        Button buyBook;
        DBHandler dbHandler=new DBHandler(context);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            bookName = itemView.findViewById(R.id.bookName);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookPrice = itemView.findViewById(R.id.bookPrice);
            bookQuantity = itemView.findViewById(R.id.bookQuantity);
            buyBook=itemView.findViewById(R.id.buyBook);

        }

    }
}

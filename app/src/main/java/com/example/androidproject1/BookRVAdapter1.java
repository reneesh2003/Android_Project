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

public class BookRVAdapter1 extends RecyclerView.Adapter<BookRVAdapter1.ViewHolder> {

    // variable for our array list and context
    private ArrayList<BookModel> BookModelArrayList;
    private Context context;

    // constructor
    public BookRVAdapter1(ArrayList<BookModel> BookModelArrayList, Context context) {
        this.BookModelArrayList = BookModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_item2, parent, false);
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

        holder.removeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.dbHandler.deleteBook(""+modal.getBookId());
                BookModelArrayList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
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
        Button removeBook;
        DBHandler dbHandler=new DBHandler(context);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            bookName = itemView.findViewById(R.id.bookName);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookPrice = itemView.findViewById(R.id.bookPrice);
            bookQuantity = itemView.findViewById(R.id.bookQuantity);
            removeBook=itemView.findViewById(R.id.removeBook);

        }

    }
}

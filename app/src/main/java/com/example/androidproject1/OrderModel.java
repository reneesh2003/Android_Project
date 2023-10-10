package com.example.androidproject1;
public class OrderModel {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String Bookname;
    private String Author;
    private int Price;
    private int id;
    private String owner;

    // creating getter and setter methods
    public String getBookBookname() { return Bookname; }

    public void setBookBookName(String Bookname)
    {
        this.Bookname = Bookname;
    }

    public String getBookAuthor()
    {
        return Author;
    }

    public void setBookAuthor(String Author)
    {
        this.Author = Author;
    }



    public int getBookPrice()
    {
        return Price;
    }

    public void setBookPrice(int Price)
    {
        this.Price = Price;
    }

    public int getOrderId() { return id; }

    public void setOrderId(int id) { this.id = id; }

    public String getowner() {
        return owner;
    }
    public void setowner(String id){
        this.owner=owner;
    }

    // constructor
    public OrderModel(int id,
                     String Bookname,
                     String Author,
                     int Price,
                     String owner)
    {
        this.id=id;
        this.Bookname = Bookname;
        this.Author = Author;
        this.Price = Price;
        this.owner=owner;
    }
}

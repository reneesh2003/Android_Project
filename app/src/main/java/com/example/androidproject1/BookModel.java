package com.example.androidproject1;
public class BookModel {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String Bookname;
    private String Author;
    private int Quantity;
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

    public int getBookQuantity() { return Quantity; }

    public void setBookQuantity(int Quantity)
    {
        this.Quantity = Quantity;
    }

    public int getBookPrice()
    {
        return Price;
    }

    public void setBookPrice(int Price)
    {
        this.Price = Price;
    }

    public int getBookId() { return id; }

    public void setBookId(int id) { this.id = id; }

    public String getowner() {
        return owner;
    }
    public void setowner(String id){
        this.owner=owner;
    }

    // constructor
    public BookModel(int id,
                     String Bookname,
                     String Author,
                     int Quantity,
                     int Price,
                     String owner)
    {
        this.id=id;
        this.Bookname = Bookname;
        this.Author = Author;
        this.Quantity = Quantity;
        this.Price = Price;
        this.owner=owner;
    }
}

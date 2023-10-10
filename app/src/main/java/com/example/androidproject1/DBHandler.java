package com.example.androidproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "MyDatabase";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "Users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String EMAIL_COL = "email";

    // below variable for our course description column.
    private static final String PASSWORD_COL = "password";

    // below variable is for our course tracks column.
    private static final String MOBILENO_COL = "mobileno";

    // creating a constructor for our database handler.
    private static final String TABLE_NAME1 = "Books";

    private static final String BOOKNAME_COL = "bookname";
    private static final String AUTHOR_COL = "author";
    private static final String QUANTITY_COL = "quantity";
    private static final String PRICE_COL = "price";
    private static final String BOOKOWNER_COL = "owner";


    private static final String TABLE_NAME2 = "Orders";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + MOBILENO_COL + " TEXT)";

        String query1 = " CREATE TABLE " + TABLE_NAME1 + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BOOKNAME_COL + " TEXT,"
                + AUTHOR_COL + " TEXT,"
                + QUANTITY_COL + " INTEGER,"
                + PRICE_COL + " INTEGER,"
                + BOOKOWNER_COL + " TEXT)";
        String query2 = " CREATE TABLE " + TABLE_NAME2 + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BOOKNAME_COL + " TEXT,"
                + AUTHOR_COL + " TEXT,"
                + PRICE_COL + " INTEGER,"
                + BOOKOWNER_COL + " TEXT)";
        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query2);
        db.execSQL(query1);
        db.execSQL(query);



    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String Name, String Email, String Password, String Mobilno) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, Name);
        values.put(EMAIL_COL, Email);
        values.put(PASSWORD_COL, Password);
        values.put(MOBILENO_COL, Mobilno);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public void addNewBook(String Bookname, String Author, int quantity, int price,String owner) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(BOOKNAME_COL, Bookname);
        values.put(AUTHOR_COL, Author);
        values.put(QUANTITY_COL, quantity);
        values.put(PRICE_COL, price);
        values.put(BOOKOWNER_COL, owner);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME1, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public void addNewOrder(String Bookname, String Author, int price,String owner) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(BOOKNAME_COL, Bookname);
        values.put(AUTHOR_COL, Author);
        values.put(PRICE_COL, price);
        values.put(BOOKOWNER_COL, owner);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME2, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<UserModel> readUsers()
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorUsers
                = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<UserModel> UserModelArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorUsers.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                UserModelArrayList.add(new UserModel(
                        cursorUsers.getString(1),
                        cursorUsers.getString(2),
                        cursorUsers.getString(3),
                        cursorUsers.getString(4)));
            } while (cursorUsers.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorUsers.close();
        return UserModelArrayList;
    }
    public ArrayList<BookModel> readBooks()
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorBooks
                = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);

        // on below line we are creating a new array list.
        ArrayList<BookModel> BookModelArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorBooks.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                BookModelArrayList.add(new BookModel(
                        cursorBooks.getInt(0),
                        cursorBooks.getString(1),
                        cursorBooks.getString(2),
                        cursorBooks.getInt(3),
                        cursorBooks.getInt(4),
                        cursorBooks.getString(5)));
            } while (cursorBooks.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorBooks.close();
        return BookModelArrayList;
    }
    public ArrayList<BookModel> readSellerBooks(String user)
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorBooks
                = db.rawQuery("SELECT * FROM " + TABLE_NAME1+" where owner=?", new String[]{user});

        // on below line we are creating a new array list.
        ArrayList<BookModel> BookModelArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorBooks.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                BookModelArrayList.add(new BookModel(
                        cursorBooks.getInt(0),
                        cursorBooks.getString(1),
                        cursorBooks.getString(2),
                        cursorBooks.getInt(3),
                        cursorBooks.getInt(4),
                        cursorBooks.getString(5)));
            } while (cursorBooks.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorBooks.close();
        return BookModelArrayList;
    }
    public ArrayList<OrderModel> readOrders()
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorOrders
                = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);

        // on below line we are creating a new array list.
        ArrayList<OrderModel> OrderModelArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorOrders.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                OrderModelArrayList.add(new OrderModel(
                        cursorOrders.getInt(0),
                        cursorOrders.getString(1),
                        cursorOrders.getString(2),
                        cursorOrders.getInt(3),
                        cursorOrders.getString(4)));
            } while (cursorOrders.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorOrders.close();
        return OrderModelArrayList;
    }
    public ArrayList<OrderModel> readUserOrders(String user)
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorOrders
                = db.rawQuery("SELECT * FROM " + TABLE_NAME2+" where owner=?", new String[]{user});

        // on below line we are creating a new array list.
        ArrayList<OrderModel> OrderModelArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorOrders.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                OrderModelArrayList.add(new OrderModel(
                        cursorOrders.getInt(0),
                        cursorOrders.getString(1),
                        cursorOrders.getString(2),
                        cursorOrders.getInt(3),
                        cursorOrders.getString(4)));
            } while (cursorOrders.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorOrders.close();
        return OrderModelArrayList;
    }

    public void BuyBook(String BookName, String Author, int Quantity,
                             int price,String owner) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(BOOKNAME_COL, BookName);
        values.put(AUTHOR_COL,  Author);
        values.put(PRICE_COL, price);
        values.put(BOOKOWNER_COL, owner);
        db.insert(TABLE_NAME2, null, values);
        values.put(QUANTITY_COL, Quantity-1);



        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME1, values, "bookname=?", new String[]{BookName});
        db.close();
    }

    // we have created a new method for reading all the courses.
    public void deleteBook(String BookID) {
        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("a", "deleteBook: "+BookID);
        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME1, "id=?", new String[]{BookID});
        db.close();
    }
    public void deleteOrder(String OrderID) {
        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME2, "id=?", new String[]{OrderID});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }
}

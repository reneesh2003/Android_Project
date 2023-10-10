package com.example.androidproject1;
public class UserModel {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String Name;
    private String Email;
    private String Password;
    private String Mobileno;
    private int id;

    // creating getter and setter methods
    public String getUserName() { return Name; }

    public void setUserName(String Name)
    {
        this.Name = Name;
    }

    public String getUserEmail()
    {
        return Email;
    }

    public void setUserEmail(String Email)
    {
        this.Email = Email;
    }

    public String getUserPassword() { return Password; }

    public void setUserPassword(String Password)
    {
        this.Password = Password;
    }

    public String getUserMobileno()
    {
        return Mobileno;
    }

    public void
    setUserMobileno(String Mobileno)
    {
        this.Mobileno = Mobileno;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public UserModel(String Name,
                       String Email,
                       String Password,
                       String Mobileno)
    {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Mobileno = Mobileno;
    }
}

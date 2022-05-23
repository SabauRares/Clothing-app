package com.example.clothingapp.user;

public class Users {
    public String username;
    public String password;
    public String role;

    public Users()
    {

    }

    public Users(String username, String password, String role)
    {
        this.username=username;
        this.password=password;
        this.role=role;
    }
    public String getUsername()
    {

        return username;
    }

    public void setUsername(String username)
    {

        this.username=username;
    }

    public String getPassword()
    {

        return password;
    }
    public void setPassword()
    {

        this.password=password;
    }
    public String getRole()
    {

        return role;
    }
    public void setRole()
    {

        this.role=role;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Users user=(Users) o;
        if(!username.equals(user.username))
            return false;
        if(!password.equals(user.password))
            return false;
        return role.equals(user.role);

    }
}

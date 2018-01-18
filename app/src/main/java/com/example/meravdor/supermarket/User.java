package com.example.meravdor.supermarket;

/**
 * Created by meravdor on 19/12/2017.
 */

public class User {

//    String userId;
    String userFirstName;
     String userLastName;
     String userStreet;
     String userCity;
     String userPassword;
     String userEmail;
    String Url;



    public User(String userFirstName, String userLastName, String userStreet, String userCity, String userPassword, String userEmail, String Url) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userStreet = userStreet;
        this.userCity = userCity;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.Url = Url;
    }

    public User(String userFirstName, String userLastName, String userStreet, String userCity, String userPassword, String userEmail) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userStreet = userStreet;
        this.userCity = userCity;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }


    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserStreet(String userStreet) {
        this.userStreet = userStreet;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUrl(String Url) {
        Url = Url;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserStreet() {
        return userStreet;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUrl() {
        return Url;
    }

    public User(){

    }

}

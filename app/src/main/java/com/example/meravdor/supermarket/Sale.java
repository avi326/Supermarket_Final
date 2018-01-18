package com.example.meravdor.supermarket;

/**
 * Created by meravdor on 09/01/2018.
 */

public class Sale {

    String nameofproduct;
    String price;

    public Sale(String nameofproduct, String price) {
        this.nameofproduct = nameofproduct;
        this.price = price;

    }

    public void setNameofproduct(String nameofproduct) {
        this.nameofproduct = nameofproduct;
    }

    public String getPrice() {
        return price;
    }

    public String getNameofproduct() {
        return nameofproduct;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}

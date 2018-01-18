package com.example.meravdor.supermarket;

/**
 * Created by meravdor on 26/12/2017.
 */

public class Product {

    String department;
    String shelf;
    String name;
    String barcode;
    String priceofunit;
    String capacity;

    public Product(String name, String barcode,String department, String shelf,  String priceofunit, String capacity) {

        this.department = department;
        this.shelf = shelf;
        this.name = name;
        this.barcode = barcode;
        this.priceofunit = priceofunit;
        this.capacity = capacity;
    }



    public String getDepartment() {
        return department;
    }

    public String getShelf() {
        return shelf;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPriceofunit() {
        return priceofunit;
    }

    public String getCapacity() {
        return capacity;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setPriceofunit(String priceofunit) {
        this.priceofunit = priceofunit;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    Product(){}
}

package com.example.codebar;

public class Product_detail {
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getPrice_currency() {
        return Price_currency;
    }

    public void setPrice_currency(String price_currency) {
        Price_currency = price_currency;
    }

    public String getManufactural() {
        return Manufactural;
    }

    public void setManufactural(String manufactural) {
        Manufactural = manufactural;
    }

    private String product_name;
    private String store_name;
    private String Price_currency;
    private String Manufactural;


    public Product_detail(String product_name, String store_name, String price_currency, String manufactural) {
        this.product_name = product_name;
        this.store_name = store_name;
        Price_currency = price_currency;
        Manufactural = manufactural;
    }


}

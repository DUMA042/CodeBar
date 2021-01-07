package com.example.codebar;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ProductDetails")
public class Product_detail implements Serializable {
    //Made it Serializable to be eble to move it object from One Activity to the another.

    /**
     *
     * @return product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     *
     * @param product_name
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     *
     * @return store_name
     */
    public String getStore_name() {
        return store_name;
    }

    /**
     *
     * @param store_name
     */
    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    /**
     *
     * @return price_currency
     */
    public String getPrice_currency() {
        return price_currency;
    }

    /**
     *
     * @param price_currency
     */
    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    /**
     *
     * @return String manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     *
     * @return Integer Product_id
     */
    public int getProduct_id() {
        return product_id;
    }

    /**
     *
     * @param product_id
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @PrimaryKey(autoGenerate = true)
    private  int product_id;
    private String product_name;
    private String store_name;
    private String price_currency;
    private String manufacturer;
    private String description;
    private String features;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return String feature
     */
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
    public Product_detail(int product_id,String product_name, String store_name, String price_currency, String manufacturer, String description, String features) {
        this.product_name = product_name;
        this.store_name = store_name;
        this.price_currency = price_currency;
        this.manufacturer = manufacturer;
        this.description=description;
        this.features=features;
        this.product_id=product_id;
    }


@Ignore
    public Product_detail(String product_name, String store_name, String price_currency, String manufacturer, String description, String features) {
        this.product_name = product_name;
        this.store_name = store_name;
        this.price_currency = price_currency;
        this.manufacturer = manufacturer;
        this.description=description;
        this.features=features;
    }


}

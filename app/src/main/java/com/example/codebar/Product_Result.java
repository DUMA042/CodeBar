package com.example.codebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Product_Result extends AppCompatActivity implements Product_Adapter.ListItemClickListener {


    private  Product_Adapter product_adapter;
    private RecyclerView product_List;
    private Toast toast=null;
    private List<Product_detail> product_details=new ArrayList<>();;
    private ProductDatabase mDb;
    ProgressBar mLoading;
    private String BarCode;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__result);
        //Initializing Variables
       product_List=findViewById(R.id.product_display) ;
       mLoading=findViewById(R.id.pb_loading);
       mDb=ProductDatabase.getInstance(getApplicationContext());//Initializing ProductDataBase.
        //Creating an Intent
        Intent intentThatStartedThisActivity = getIntent();
        //Getting the Data Contained In the Intent which is the Barcode Raw Numbers
         BarCode = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        product_List.setLayoutManager(layoutManager);
        product_List.setHasFixedSize(true);//allows recyclerView to do some optimization on the UI
       /*Pass Into the makeproductSearchQuery function :This is need to set up the data for the Http Request */
        makeproductSearchQuery();
    }
    /**
     * This is for the Query and URL Operation
     * Http AsynTask start and runs a Separate Thread
     */

    public class ProductQueryFun extends AsyncTask<URL,Void,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          mLoading.setVisibility(View.VISIBLE);
        }
/*The doInBackground Runs in the another thread and gets the JSON Tree from the request */
        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl=urls[0];
            String productSearchResults=null;

            try {
                productSearchResults=NetworkUtils.getResponseFromHttpUrl(searchUrl);

            } catch (IOException e) {
                e.printStackTrace();
            }
            /*Returns the JSON Tree to ProExecute*/
            return productSearchResults;
        }
//onPostExecute receives Data from the doInbackground
      /*Fuction need to go through the Tree and get Important details about Product*/
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            Product_detail product_data=null;

            String prod_fea="";
            try {
                //JSON object and Arrays Depending on the Tree Structure and Target Data need
                /*The movement along the tree will be done*/
                /*For this Data it returns  a Tree with only on Array called product So I start from that*/
                JSONObject jsObj = new JSONObject(s);;
                JSONArray jsProduct= jsObj.getJSONArray("products");
                JSONObject jsonlyobj=jsProduct.getJSONObject(0);
                JSONArray jsArray=jsonlyobj.getJSONArray("stores");
                JSONArray jsfe=jsonlyobj.getJSONArray("features");

                 //This will get the features
                for (int i = 0; i < jsfe.length(); i++){

                    prod_fea=prod_fea+jsfe.getString(i);
                }

                for (int i = 0; i < jsArray.length(); i++) {

                    JSONObject obj = jsArray.getJSONObject(i);


                     product_data=new Product_detail(jsonlyobj.getString("product_name"),obj.getString("store_name"),obj.getString("store_price")+obj.getString("currency_code"),jsonlyobj.getString("manufacturer"),jsonlyobj.getString("description"),prod_fea);
                    product_details.add(product_data);
                   mDb.productDao().insertProduct(product_data);

                }




            } catch (JSONException e) {
                e.printStackTrace();
            }
/*Call the mLoading to Invisible to stop the Progress Bar from showing*/
mLoading.setVisibility(View.INVISIBLE);
/*Set up the Product Details to the Adapter to Display to the User in makeRecycle*/
makeRecycle();






        }
    }
private  void makeRecycle(){
    product_adapter=new Product_Adapter(product_details,this);//this is where the product_detail is passed to the Recycle view
    product_List.setAdapter(product_adapter);//this will set the adapter
}


    private  void makeproductSearchQuery(){


        URL productSearchUrl= NetworkUtils.buildUrl(BarCode);
        new ProductQueryFun().execute(productSearchUrl);
        //check_recy();


    }

    /**
     * This fuction also set the Data to be displayed when you click on an Item in the RecycleView
     * @param clickItemIndex
     */
    @Override
    public void onListItemClick(int clickItemIndex) {

        String ans=String.valueOf(clickItemIndex);
        Product_detail product_info=product_details.get(clickItemIndex);//Get the description and Features  from the class object
        Intent intent = new Intent(getApplicationContext(), MoreInfo.class);
        intent.putExtra("INFO", product_info);//INFO is Key Word for the Intent will be used to view the get the data
        startActivity(intent);

    }

}
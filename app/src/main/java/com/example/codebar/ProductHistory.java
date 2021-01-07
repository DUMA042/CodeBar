package com.example.codebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Connect the DataBase(Client(Phone)) to the Class
 */
public class ProductHistory extends AppCompatActivity implements Product_Adapter.ListItemClickListener {

private ProductDatabase mDb;
private List<Product_detail> product_details;
RecyclerView recyclerView_history;
Product_Adapter product_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__result);
        recyclerView_history=findViewById(R.id.product_display) ;
        mDb=ProductDatabase.getInstance(getApplicationContext());
        product_details=new ArrayList<Product_detail>();
        //product_details.get(1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView_history.setLayoutManager(layoutManager);
        recyclerView_history.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
   //recyclerView_history.s
        product_adapter=new Product_Adapter(mDb.productDao().loadAllProduct(),this);//this is where the product_detail is passed to the Recycle view
        recyclerView_history.setAdapter(product_adapter);//this will set the adapter
    }
    /**
     * This fuction also set the Data to be displayed when you click on an Item in the RecycleView
     * @param clickItemIndex
     */
    @Override
    public void onListItemClick(int clickItemIndex) {

        String ans=String.valueOf(clickItemIndex);
        List<Product_detail> product_details=mDb.productDao().loadAllProduct();
        Product_detail product_info=product_details.get(clickItemIndex);
        Intent intent = new Intent(getApplicationContext(), MoreInfo.class);
        intent.putExtra("INFO", product_info);//INFO is Key Word for the Intent will be used to view the get the data
        startActivity(intent);


    }
}
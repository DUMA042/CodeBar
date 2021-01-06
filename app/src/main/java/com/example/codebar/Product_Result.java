package com.example.codebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Product_Result extends AppCompatActivity implements Product_Adapter.ListItemClickListener {

    private  static final  int produt_list_number=100;
    private  Product_Adapter product_adapter;
    private RecyclerView product_List;
    private Toast toast=null;
    private ArrayList<Product_detail> product_details;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__result);
       product_List=findViewById(R.id.product_display) ;
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        product_List.setLayoutManager(layoutManager);
        product_List.setHasFixedSize(true);//allows recyclerView to do some optimization on the UI
        product_adapter=new Product_Adapter(produt_list_number,this);
        product_List.setAdapter(product_adapter);//this will set the adapter

    }

    @Override
    public void onListItemClick(int clickItemIndex) {
        if(toast!=null){
            toast.cancel();
        }
        toast.makeText(this,"It works",Toast.LENGTH_LONG).show();

    }
}
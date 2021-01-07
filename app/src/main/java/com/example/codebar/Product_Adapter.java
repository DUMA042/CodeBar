package com.example.codebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.NumberViewHolder> {

  private List<Product_detail> product_details;//List Containing Product Details
final private ListItemClickListener mOnclickListener;//Object of ListItemClickListener to enable clickListener

    public Product_Adapter(List<Product_detail> product_details, ListItemClickListener mOnclickListener) {
        this.product_details = product_details;
        this.mOnclickListener = mOnclickListener;  //Pass it to the view holder to be invoke
    }

public  interface  ListItemClickListener{
        void onListItemClick(int clickItemIndex);

}

    /**
     *
     * @param parent
     * @param viewType
     * @return NumberViewHolder
     */
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      Context context=parent.getContext();
      int product_recycle_id=R.layout.product_recyclic;//Get the product Id for the Recycle XMl File
      LayoutInflater inflater=LayoutInflater.from(context);
      boolean ShouldAttachtoParent=false;
      View view=inflater.inflate(product_recycle_id,parent,ShouldAttachtoParent);//Takes in layout xml

//returns a view.
        return new NumberViewHolder(view);
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     *      *
     * @param position Get the position of the Item within the Adapter
     *  OnBindViewHolder is called by the RecyclerView to display the data at the specified position.
     *
     */
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Product_detail per_product=product_details.get(position);
        holder.productName.setText(per_product.getProduct_name());
        holder.store_name.setText(per_product.getStore_name());
        holder.price_currency.setText(per_product.getPrice_currency());
        holder.manufact.setText(per_product.getManufacturer());

       // holder.bind(position);
    }

    /**
     *
     * @return int The number of View to be Displayed
     */
    @Override
    public int getItemCount() {
//Returns n number
      return product_details.size() ;
    }

    /**
     * Cache of the children views for a list item.
     */
    
    class NumberViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
  TextView productName;
  TextView store_name;
  TextView price_currency;
  TextView manufact;

      /**
       * Constructor for our ViewHolder. Within this constructor, we get a reference to our
       * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
       * onClick method below.
       * @param itemView The View that you inflated in
       *                 {@link Product_Adapter#onCreateViewHolder(ViewGroup, int)}
       */


      public NumberViewHolder(@NonNull View itemView) {
        super(itemView);
        productName=itemView.findViewById(R.id.Product_name);
        store_name=itemView.findViewById(R.id.Store_name);
        price_currency=itemView.findViewById(R.id.Price_and_Currency);
        manufact=itemView.findViewById(R.id.manufactural_id);
        itemView.setOnClickListener(this);



      }



        @Override
        public void onClick(View v) {
            int clickedPosition=getAdapterPosition();
            mOnclickListener.onListItemClick(clickedPosition);
        }
    }
    
}

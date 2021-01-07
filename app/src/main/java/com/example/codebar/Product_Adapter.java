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

  private List<Product_detail> product_details;
final private ListItemClickListener mOnclickListener;

    public Product_Adapter(List<Product_detail> product_details, ListItemClickListener mOnclickListener) {
        this.product_details = product_details;
        this.mOnclickListener = mOnclickListener;  //Pass it to the view holder to be invoke
    }

public  interface  ListItemClickListener{
        void onListItemClick(int clickItemIndex);

}

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      Context context=parent.getContext();
      int product_recycle_id=R.layout.product_recyclic;
      LayoutInflater inflater=LayoutInflater.from(context);
      boolean ShouldAttachtoParent=false;
      View view=inflater.inflate(product_recycle_id,parent,ShouldAttachtoParent);//Takes in layout xml
      //NumberViewHolder viewHolder=new NumberViewHolder(view);//Pass to NumberViewHolder
//returns a view.
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Product_detail per_product=product_details.get(position);
        holder.productName.setText(per_product.getProduct_name());
        holder.store_name.setText(per_product.getStore_name());
        holder.price_currency.setText(per_product.getPrice_currency());
        holder.manufact.setText(per_product.getManufacturer());

       // holder.bind(position);
    }

    @Override
    public int getItemCount() {
//Returns n number
      return product_details.size() ;
    }

    
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
      /**
       * A method we wrote for convenience. This method will take an integer as input and
       * use that integer to display the appropriate text within a list item.
       * @param position Position of the item in the list
       */

      public void bind(int position) {

         notifyDataSetChanged();

      }


        @Override
        public void onClick(View v) {
            int clickedPosition=getAdapterPosition();
            mOnclickListener.onListItemClick(clickedPosition);
        }
    }
    
}

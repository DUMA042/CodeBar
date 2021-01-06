package com.example.codebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.NumberViewHolder> {
  private  int number_of_product_dispaly;
final private ListItemClickListener mOnclickListener;
    public Product_Adapter(int number_of_product_dispaly,ListItemClickListener mOnclickListener) {
        this.number_of_product_dispaly = number_of_product_dispaly;
        this.mOnclickListener = mOnclickListener;  //Pass it to the view holder to be invoke
    }

public  interface  ListItemClickListener{
        void onListItemClick(int clickItemIndex);

}

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      Context context=parent.getContext();
      int product_recycle_id=R.layout.product_recyclic;
      LayoutInflater inflater=LayoutInflater.from(context);
      boolean ShouldAttachtoParent=false;
      View view=inflater.inflate(product_recycle_id,parent,ShouldAttachtoParent);//Takes in layout xml
      NumberViewHolder viewHolder=new NumberViewHolder(view);//Pass to NumberViewHolder
//returns a view.
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
 holder.bind(position);
    }

    @Override
    public int getItemCount() {
//Returns n number
      return number_of_product_dispaly ;
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


      }

        @Override
        public void onClick(View v) {
            int clickedPosition=getAdapterPosition();
            mOnclickListener.onListItemClick(clickedPosition);
        }
    }
    
}

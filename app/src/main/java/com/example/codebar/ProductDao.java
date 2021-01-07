package com.example.codebar;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM ProductDetails ORDER BY product_id")
    List<Product_detail> loadAllProduct();
    @Insert
    void insertProduct(Product_detail product);

    @Update(onConflict= OnConflictStrategy.REPLACE)
    void updateProduct(Product_detail product);

}

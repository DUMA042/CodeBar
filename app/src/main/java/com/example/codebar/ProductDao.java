package com.example.codebar;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

/**
 * The whole function follows the Room androidx API
 */
@Dao
public interface ProductDao {
    /**
     * This set a SQllite query to get all data from the Database(Client(Phone))
     * @return List
     */
    @Query("SELECT * FROM ProductDetails ORDER BY product_id")
    List<Product_detail> loadAllProduct();
    @Insert
    void insertProduct(Product_detail product);//@Insert to generate an Insert funtion

    @Update(onConflict= OnConflictStrategy.REPLACE)
    void updateProduct(Product_detail product);

}

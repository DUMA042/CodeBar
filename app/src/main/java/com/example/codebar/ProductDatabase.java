package com.example.codebar;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
@Database(entities ={Product_detail.class},version=1,exportSchema =false)
public abstract class ProductDatabase extends RoomDatabase {
    private static  final  Object lock =new Object();
    private static final String DATABASE_NAME="Products";
    private static  ProductDatabase sInstance;

//Using the Singleton Pattern
    public  static  ProductDatabase getInstance(Context context){
        if (sInstance==null){
            synchronized (lock){
                sInstance= Room.databaseBuilder(context.getApplicationContext(),
                        ProductDatabase.class,ProductDatabase.DATABASE_NAME)
                        //To be removed
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return  sInstance;
    }
    public abstract  ProductDao productDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}

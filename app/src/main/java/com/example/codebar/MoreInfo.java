package com.example.codebar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoreInfo extends AppCompatActivity {
TextView descript;//TextView to get the description
TextView features;//TexetView to get the Feature
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        //giving the view an ID
descript=findViewById(R.id.Description_info);
features=findViewById(R.id.fe_info);
//Collecting the sent data from the Intent(Extra).
        Product_detail info_details = (Product_detail) getIntent().getSerializableExtra("INFO");
        descript.setText(info_details.getDescription());
        features.setText(info_details.getFeatures());
    }
}
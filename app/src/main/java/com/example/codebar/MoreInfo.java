package com.example.codebar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoreInfo extends AppCompatActivity {
TextView descript;
TextView features;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
descript=findViewById(R.id.Description_info);
features=findViewById(R.id.fe_info);
        Product_detail info_details = (Product_detail) getIntent().getSerializableExtra("INFO");
        descript.setText(info_details.getDescription());
        features.setText(info_details.getFeatures());
    }
}
package com.hfad.nwhacks_food_expiration_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Recently_Added_Screen extends AppCompatActivity {
    ImageView imgview_item_photo;
    EditText et_this_item_name;
    EditText et_this_expiration_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recently__added__screen);


        Intent intent = getIntent();
//        Bitmap photo = (Bitmap) intent.getParcelableExtra("photo");
        int expiryTime = intent.getIntExtra("expiryTime", 0);
        String itemName = intent.getStringExtra("itemName");

//        imgview_item_photo = (ImageView) findViewById(R.id.imgview_photo);
        et_this_item_name = (EditText) findViewById(R.id.et_item_name);
        et_this_expiration_date = (EditText) findViewById(R.id.et_expiration_date);

//        imgview_item_photo.setImageBitmap(photo);
        et_this_item_name.setText(itemName);
        et_this_expiration_date.setText(Integer.toString(expiryTime));

    }

}

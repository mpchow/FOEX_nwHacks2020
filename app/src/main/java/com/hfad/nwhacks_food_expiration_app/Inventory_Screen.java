package com.hfad.nwhacks_food_expiration_app;

//import android.icu.text.Edits;
import android.os.Bundle;

//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory_Screen extends AppCompatActivity {
    TextView tv_item1;
    TextView tv_item2;
    TextView tv_item3;
    TextView tv_item4;
    TextView tv_item5;
    TextView tv_item6;
    TextView tv_item7;
    TextView tv_item8;
    TextView tv_item9;
    TextView tv_item10;
    TextView tv_item11;
    TextView tv_item12;
    TextView tv_item13;
    TextView tv_item14;
    TextView tv_item15;
    TextView tv_item16;

    TextView tv_expiry1;
    TextView tv_expiry2;
    TextView tv_expiry3;
    TextView tv_expiry4;
    TextView tv_expiry5;
    TextView tv_expiry6;
    TextView tv_expiry7;
    TextView tv_expiry8;
    TextView tv_expiry9;
    TextView tv_expiry10;
    TextView tv_expiry11;
    TextView tv_expiry12;
    TextView tv_expiry13;
    TextView tv_expiry14;
    TextView tv_expiry15;
    TextView tv_expiry16;

    List<TextView> tv_items = new ArrayList<TextView>();
    List<TextView> tv_expiry_dates = new ArrayList<TextView>();
    FoodList foodList = new FoodList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory__screen);

        init_items();
        init_expiry_dates();
        display_data();
    }

    public void init_items() {
        tv_item1 = (TextView) findViewById(R.id.tv_item1);
        tv_item2 = (TextView) findViewById(R.id.tv_item2);
        tv_item3 = (TextView) findViewById(R.id.tv_item3);
        tv_item4 = (TextView) findViewById(R.id.tv_item4);
        tv_item5 = (TextView) findViewById(R.id.tv_item5);
        tv_item6 = (TextView) findViewById(R.id.tv_item6);
        tv_item7 = (TextView) findViewById(R.id.tv_item7);
        tv_item8 = (TextView) findViewById(R.id.tv_item8);
        tv_item9 = (TextView) findViewById(R.id.tv_item9);
        tv_item10 = (TextView) findViewById(R.id.tv_item10);
        tv_item11 = (TextView) findViewById(R.id.tv_item11);
        tv_item12 = (TextView) findViewById(R.id.tv_item12);
        tv_item13 = (TextView) findViewById(R.id.tv_item13);
        tv_item14 = (TextView) findViewById(R.id.tv_item14);
        tv_item15 = (TextView) findViewById(R.id.tv_item15);
        tv_item16 = (TextView) findViewById(R.id.tv_item16);

        tv_items.add(tv_item1);
        tv_items.add(tv_item2);
        tv_items.add(tv_item3);
        tv_items.add(tv_item4);
        tv_items.add(tv_item5);
        tv_items.add(tv_item6);
        tv_items.add(tv_item7);
        tv_items.add(tv_item8);
        tv_items.add(tv_item9);
        tv_items.add(tv_item10);
        tv_items.add(tv_item11);
        tv_items.add(tv_item12);
        tv_items.add(tv_item13);
        tv_items.add(tv_item14);
        tv_items.add(tv_item15);
        tv_items.add(tv_item16);
    }
    public void init_expiry_dates() {
        tv_expiry1 = (TextView) findViewById(R.id.tv_expiry1);
        tv_expiry2 = (TextView) findViewById(R.id.tv_expiry2);
        tv_expiry3 = (TextView) findViewById(R.id.tv_expiry3);
        tv_expiry4 = (TextView) findViewById(R.id.tv_expiry4);
        tv_expiry5 = (TextView) findViewById(R.id.tv_expiry5);
        tv_expiry6 = (TextView) findViewById(R.id.tv_expiry6);
        tv_expiry7 = (TextView) findViewById(R.id.tv_expiry7);
        tv_expiry8 = (TextView) findViewById(R.id.tv_expiry8);
        tv_expiry9 = (TextView) findViewById(R.id.tv_expiry9);
        tv_expiry10 = (TextView) findViewById(R.id.tv_expiry10);
        tv_expiry11 = (TextView) findViewById(R.id.tv_expiry11);
        tv_expiry12 = (TextView) findViewById(R.id.tv_expiry12);
        tv_expiry13 = (TextView) findViewById(R.id.tv_expiry13);
        tv_expiry14 = (TextView) findViewById(R.id.tv_expiry14);
        tv_expiry15 = (TextView) findViewById(R.id.tv_expiry15);
        tv_expiry16 = (TextView) findViewById(R.id.tv_expiry16);

        tv_expiry_dates.add(tv_expiry1);
        tv_expiry_dates.add(tv_expiry2);
        tv_expiry_dates.add(tv_expiry3);
        tv_expiry_dates.add(tv_expiry4);
        tv_expiry_dates.add(tv_expiry5);
        tv_expiry_dates.add(tv_expiry6);
        tv_expiry_dates.add(tv_expiry7);
        tv_expiry_dates.add(tv_expiry8);
        tv_expiry_dates.add(tv_expiry9);
        tv_expiry_dates.add(tv_expiry10);
        tv_expiry_dates.add(tv_expiry11);
        tv_expiry_dates.add(tv_expiry12);
        tv_expiry_dates.add(tv_expiry13);
        tv_expiry_dates.add(tv_expiry14);
        tv_expiry_dates.add(tv_expiry15);
        tv_expiry_dates.add(tv_expiry16);
    }
    public void display_data() {
        Map<String, String> foodListMap = foodList.getStringPairs();

        // asssign all 'items'
        Iterator foodsIterator = foodListMap.keySet().iterator();

        for (TextView item: tv_items) {
            if (foodsIterator.hasNext()) {
                item.setText(foodsIterator.next().toString());
            }
        }

        // assign all 'dates'
        Iterator expiryDatesIterator = foodListMap.values().iterator();

        for (TextView item: tv_expiry_dates) {
            if (expiryDatesIterator.hasNext()) {
                item.setText(expiryDatesIterator.next().toString());
            }
        }
    }
}

package com.example.foobapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foobapp.Adapter.CategoryAdapter;
import com.example.foobapp.Adapter.RecommendedAdapter;
import com.example.foobapp.Domain.CategoryDomain;
import com.example.foobapp.Domain.FoodDomain;
import com.example.foobapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class ));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.View1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Hotdog","cat_3"));
        categoryList.add(new CategoryDomain("drink","cat_4"));
        categoryList.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.View2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foobList = new ArrayList<>();
        foobList.add(new FoodDomain("Pepperoni pizza","pizza1"," mozzarela chesse, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,400 ));
        foobList.add(new FoodDomain("Chesse Burger","burger","slices pepperoni, mozzarela chesse, fresh oregano, ground black pepper, burger sauce",15.0,5,20,300 ));
        foobList.add(new FoodDomain("Vegatable pizzza","pizza3","slices pepperoni, mozzarela chesse, fresh oregano, ground black pepper, pizza sauce, Vegatable ",20.0,5,20,350 ));

        adapter2 = new RecommendedAdapter(foobList);
        recyclerViewPopularList.setAdapter(adapter2);


    }
}
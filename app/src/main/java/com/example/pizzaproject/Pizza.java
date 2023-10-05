package com.example.pizzaproject;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

public class Pizza {
    private String name;
    private String desc;
    private Double price;
    private int imageID;



        public static final Pizza[] pizza={
                new Pizza("Small", "pizza", 7.50,R.drawable.pizzach),
                new Pizza("Medium", "pizza", 9.50,R.drawable.pizzapep),
                new Pizza("Large", "pizza", 11.50,R.drawable.pizzav)
        };
        private Pizza(String name, String desc, double price, int imageID){
            this.name = name;
            this.desc = desc;
            this.price = price;
            this.imageID = imageID;
        }
        public String getName() {
            return name;
        }
        public String getDesc(){
            return desc;
        }
        public double getPrice(){
            return price;
        }
        public int getImageID(){
            return imageID;
        }

        public String toString(){
            return name;
        }




    }



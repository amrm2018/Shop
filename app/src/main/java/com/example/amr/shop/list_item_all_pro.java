package com.example.amr.shop;

/**
 * Created by amr on 10/9/2019.
 */

public class list_item_all_pro {


    public list_item_all_pro(String img_pro, String pro_name, String pro_color, String pro_brand, String pro_price, String pro_des) {
        this.img_pro = img_pro;
        this.pro_name = pro_name;
        this.pro_color = pro_color;
        this.pro_brand = pro_brand;
        this.pro_price = pro_price;
        this.pro_des = pro_des;
    }

    public String img_pro;

    public String pro_name;
    public String pro_color;
    public String pro_brand;

    public String pro_price;
    public String pro_des;


    public String getImg_pro() {
        return img_pro;
    }

    public void setImg_pro(String img_pro) {
        this.img_pro = img_pro;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_color() {
        return pro_color;
    }

    public void setPro_color(String pro_color) {
        this.pro_color = pro_color;
    }

    public String getPro_brand() {
        return pro_brand;
    }

    public void setPro_brand(String pro_brand) {
        this.pro_brand = pro_brand;
    }

    public String getPro_price() {
        return pro_price;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_des() {
        return pro_des;
    }

    public void setPro_des(String pro_des) {
        this.pro_des = pro_des;
    }



}
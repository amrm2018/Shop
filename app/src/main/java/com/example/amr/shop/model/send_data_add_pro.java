package com.example.amr.shop.model;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amr on 10/8/2019.
 */

public class send_data_add_pro  extends StringRequest {

    private static final String SEND_DATA_URL = "http://192.168.1.3/shop/add_product.php";
    private Map<String, String> MapData;

    public send_data_add_pro(String pro_name  ,  String pro_color ,String pro_brand ,
                             String pro_price ,  String pro_des ,  String pro_img,
                             Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();

        MapData.put("Pro_name", pro_name);
        MapData.put("Pro_color", pro_color);
        MapData.put("Pro_brand", pro_brand);

        MapData.put("Pro_price", pro_price);
        MapData.put("Pro_des", pro_des);
        MapData.put("Pro_img", pro_img);
    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}
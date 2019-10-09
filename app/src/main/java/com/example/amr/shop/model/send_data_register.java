package com.example.amr.shop.model;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amr on 10/7/2019.
 */

public class send_data_register extends StringRequest {

    private static final String SEND_DATA_URL = "http://192.168.1.3/shop/register.php";
    private Map<String, String> MapData;

    public send_data_register(String shop_name,  String password ,String phone, Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();

        MapData.put("shop_name", shop_name);
        MapData.put("password", password);
        MapData.put("shop_phone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}
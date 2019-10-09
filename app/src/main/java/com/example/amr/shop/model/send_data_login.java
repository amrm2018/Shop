package com.example.amr.shop.model;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amr on 10/8/2019.
 */

public class send_data_login extends StringRequest{

    private static final String SEND_DATA_URL = "http://192.168.1.3/shop/login.php";
    private Map<String, String> MapData;

    public send_data_login(String shop_name,  String password , Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener, null);
        MapData = new HashMap<>();

        MapData.put("Login_email", shop_name);
        MapData.put("Login_password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return MapData;
    }
}

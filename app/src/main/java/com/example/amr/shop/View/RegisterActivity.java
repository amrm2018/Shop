package com.example.amr.shop.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.amr.shop.R;
import com.example.amr.shop.model.send_data_register;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText shop_name , password , shop_phone ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        shop_name = findViewById(R.id.ed_name);
        password = findViewById(R.id.ed_pass);
        shop_phone = findViewById(R.id.ed_phone);

    }

    public void btn_register(View view){
        String Shop_name = shop_name.getText().toString();
        String Pass = password.getText().toString().trim();
        String Shop_phone = shop_phone.getText().toString().trim();
        Response.Listener<String> responseLisener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                         Toast.makeText( RegisterActivity.this , "تم التسجيل بنجاح,أذهب و سجل دخول", Toast.LENGTH_SHORT).show();
                      //  dialog.dismiss();
                    } else {
                        Toast.makeText( RegisterActivity.this , "يوجد خطأ ( تاكد من البريد او التليفون )", Toast.LENGTH_SHORT).show();
                       // dialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "error is : " + e, Toast.LENGTH_SHORT).show();
                   // dialog.dismiss();
                }
            }
        };
        send_data_register Registration_send_Data= new send_data_register(Shop_name, Pass , Shop_phone, responseLisener);
        RequestQueue queue_reg = Volley.newRequestQueue(getApplicationContext());
        queue_reg.add(Registration_send_Data);
    }

    public void go_login(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}



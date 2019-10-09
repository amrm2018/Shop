package com.example.amr.shop.View;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.amr.shop.R;
import com.example.amr.shop.model.send_data_login;
import com.example.amr.shop.model.send_data_register;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText Ed_gmail_login, Ed_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Ed_gmail_login =findViewById(R.id.ed_gmail);
        Ed_pass =findViewById(R.id.ed_pass_l);


    }

    public void btn_Login(View view){

        String S_Gmail_login = Ed_gmail_login.getText().toString();
        String S_Pass = Ed_pass.getText().toString().trim();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success) {
                        final Toast toast = Toast.makeText(LoginActivity.this, "تمام", Toast.LENGTH_SHORT);
                        View bg =toast.getView();
                        bg.setBackgroundColor(Color.RED);
                        toast.show();

                        startActivity(new Intent(getApplicationContext(),Add_product_Activity.class));

                    } else {
                        final Toast toast = Toast.makeText(LoginActivity.this, "البيانات غير صحيحة", Toast.LENGTH_SHORT);
                        View bg =toast.getView();
                        bg.setBackgroundColor(Color.RED);
                        toast.show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "error is : " + e, Toast.LENGTH_LONG).show();

                }
            }
        };

        send_data_login login_send_data = new send_data_login(S_Gmail_login, S_Pass, responseListener);
        RequestQueue queue_login = Volley.newRequestQueue(LoginActivity.this);
        queue_login.add(login_send_data);
    }

}

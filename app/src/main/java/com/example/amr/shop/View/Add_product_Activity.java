package com.example.amr.shop.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.amr.shop.R;
import com.example.amr.shop.model.send_data_add_pro;
import com.example.amr.shop.model.send_data_register;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class Add_product_Activity extends AppCompatActivity {

    EditText ed_name , ed_color , ed_brand , ed_price , ed_des ;
    ImageView img_pro ;
    String encodeimg_img_add_pro ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        ed_name = findViewById(R.id.ed_name_pro);
        ed_color = findViewById(R.id.ed_color);
        ed_brand = findViewById(R.id.ed_brand);
        ed_price = findViewById(R.id.ed_price);
        ed_des = findViewById(R.id.ed_des);

        img_pro =findViewById(R.id.imgv);

    }

    public void btn_add_product(View view) {

        String Pro_name = ed_name.getText().toString();
        String Pro_color = ed_color.getText().toString().trim();
        String Pro_brand = ed_brand.getText().toString().trim();
        String Pro_price = ed_price.getText().toString().trim();
        String Pro_des = ed_des.getText().toString().trim();

        Bitmap Bimg = ((BitmapDrawable) img_pro.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bimg.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        encodeimg_img_add_pro= Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
        // encodeimg  هو دا المتغير اللي شايل الصورة


        Response.Listener<String> responseLisener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Toast.makeText( Add_product_Activity.this , "تم اضافة المنتج", Toast.LENGTH_SHORT).show();
                        //  dialog.dismiss();
                    } else {
                        Toast.makeText( Add_product_Activity.this , "يوجد خطأ ( تاكد من البيانات )", Toast.LENGTH_SHORT).show();
                        // dialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "error is : " + e, Toast.LENGTH_SHORT).show();
                    // dialog.dismiss();
                }
            }
        };

        send_data_add_pro Registration_send_Data= new send_data_add_pro(Pro_name, Pro_color , Pro_brand, Pro_price , Pro_des , encodeimg_img_add_pro, responseLisener);
        RequestQueue queue_reg = Volley.newRequestQueue(getApplicationContext());
        queue_reg.add(Registration_send_Data);

    }

    public void btn_pick_photo(View view) {
        Intent intent=new  Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK)
        { Uri uri = data.getData();
            img_pro.setImageURI(uri); //  هتحوط الصورة فين
        }
    }


}

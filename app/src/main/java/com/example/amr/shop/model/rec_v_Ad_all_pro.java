package com.example.amr.shop.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amr.shop.R;
import com.example.amr.shop.all_pro_Activity;
import com.example.amr.shop.list_item_all_pro;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amr on 10/9/2019.
 */

public class rec_v_Ad_all_pro extends RecyclerView.Adapter {

    private int previousPosition = 0;
    private List<list_item_all_pro> List_Item ;
    private Context context ;
    String S_code_p_f ;

    public rec_v_Ad_all_pro(List<list_item_all_pro> list_Item, Context context) {
        List_Item = list_Item ;
        this.context = context ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View menu1 = LayoutInflater.from(parent.getContext()).inflate( R.layout.row_item_pro, parent, false);
        return new rec_v_Ad_all_pro.MenuItemViewHolder(menu1);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        rec_v_Ad_all_pro.MenuItemViewHolder menuItemHolder = (rec_v_Ad_all_pro.MenuItemViewHolder) holder;

        menuItemHolder.tv_pro_name.setText(List_Item.get(position).getPro_name());
        menuItemHolder.tv_color.setText(List_Item.get(position).getPro_color());
        menuItemHolder.tv_pro_brand.setText(List_Item.get(position).getPro_brand());
        menuItemHolder.tv_pro_price.setText(List_Item.get(position).getPro_price());
        menuItemHolder.tv_pro_des.setText(List_Item.get(position).getPro_des());

      //  S_code_p_f = menuItemHolder.tv_code_post_f_rec_v.getText().toString();

        Picasso.with(context).load("http://192.168.1.4/atfalna_app/img_found/" + List_Item
                .get(position).getImg_pro())
                .into(menuItemHolder.img_pro);

//        menuItemHolder.img_f_rec_v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, List_Item.get(position).getUser_name_f()
//                        + List_Item.get(position).getCode_p_f(), Toast.LENGTH_SHORT).show();
//            }
//        });

        menuItemHolder.img_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context , "خطا الاتصال بالخادم" , Toast.LENGTH_SHORT).show();

//                Intent openPost = new Intent(context , Post_found.class);
//
//                openPost.putExtra("text_code_p_f", List_Item.get(position).getCode_p_f());
//                openPost.putExtra("text_date_p_f", List_Item.get(position).getDate_p_f());
//                openPost.putExtra("text_time_p_f", List_Item.get(position).getTime_p_f());
//
//                openPost.putExtra("text_city_f"  , List_Item.get(position).getCity_f());
//
//                openPost.putExtra("text_day_f", List_Item.get(position).getDay_f());
//                openPost.putExtra("text_month_f", List_Item.get(position).getMonth_f());
//                openPost.putExtra("text_year_f", List_Item.get(position).getYear_f());
//
//                openPost.putExtra("text_gender_f", List_Item.get(position).getGender_f());
//                openPost.putExtra("text_phone_f", List_Item.get(position).getPhone_f());
//
//                openPost.putExtra("text_place_case_f", List_Item.get(position).getPlace_case_f());
//                openPost.putExtra("text_info_case_f", List_Item.get(position).getInfo_case_f());
//
//                openPost.putExtra("text_img_f", List_Item.get(position).getImg_f());
//
//                openPost.putExtra("text_us_id_f", List_Item.get(position).getUs_id_f());
//                openPost.putExtra("text_user_name_f", List_Item.get(position).getUser_name_f());
//
//                openPost.putExtra("text_lat_f", List_Item.get(position).getLat_f());
//                openPost.putExtra("text_lng_f", List_Item.get(position).getLng_f());
//
//                context.startActivity(openPost);
//                CustomIntent.customType(context, "left-to-right");

            }
        });


//        if (position > previousPosition) { //scrolling DOWN
//            AnimationUtil.animate(menuItemHolder, true);
//        } else { // scrolling UP
//            AnimationUtil.animate(menuItemHolder, false);
//        }
//        previousPosition = position;

    }

    @Override
    public int getItemCount() {
        return (null != List_Item ? List_Item.size() : 0);
    }

    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_pro_name, tv_color, tv_pro_brand, tv_pro_price , tv_pro_des;
        ImageView img_pro;

        public MenuItemViewHolder(View view) {
            super(view);
            tv_pro_name = view.findViewById(R.id.tv_pro_name);
            tv_color = view.findViewById(R.id.tv_color);
            tv_pro_brand = view.findViewById(R.id.tv_pro_brand);
            tv_pro_price = view.findViewById(R.id.tv_pro_price);
            tv_pro_des = view.findViewById(R.id.tv_pro_des);
            img_pro = view.findViewById(R.id.img_pro);



        }
    }
}

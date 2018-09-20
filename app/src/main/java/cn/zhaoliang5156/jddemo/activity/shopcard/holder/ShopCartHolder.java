package cn.zhaoliang5156.jddemo.activity.shopcard.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.zhaoliang5156.jddemo.R;

public class ShopCartHolder extends RecyclerView.ViewHolder {

    public ImageView ivShopCartShopSel;
    public TextView tvShopCartShopName;
    public TextView tvShopCartClothName;
    public TextView tvShopCartClothPrice;
    public TextView etShopCartClothNum;
    public TextView tvShopCartClothColor;
    public TextView tvShopCartClothSize;
    public ImageView ivShopCartClothSel;
    public ImageView ivShopCartClothMinus;
    public ImageView ivShopCartClothAdd;
    public ImageView ivShopCartClothDelete;
    public ImageView ivShopCartClothPic;
    public LinearLayout llShopCartHeader;

    public ShopCartHolder(View itemView) {
        super(itemView);
        llShopCartHeader = itemView.findViewById(R.id.ll_shopcart_header);
        ivShopCartShopSel = itemView.findViewById(R.id.iv_item_shopcart_shopselect);
        tvShopCartShopName = itemView.findViewById(R.id.tv_item_shopcart_shopname);
        tvShopCartClothName = itemView.findViewById(R.id.tv_item_shopcart_clothname);
        tvShopCartClothPrice = itemView.findViewById(R.id.tv_item_shopcart_cloth_price);
        etShopCartClothNum = itemView.findViewById(R.id.et_item_shopcart_cloth_num);
        tvShopCartClothColor = itemView.findViewById(R.id.tv_item_shopcart_cloth_color);
        tvShopCartClothSize = itemView.findViewById(R.id.tv_item_shopcart_cloth_size);
        ivShopCartClothSel = itemView.findViewById(R.id.tv_item_shopcart_clothselect);
        ivShopCartClothMinus = itemView.findViewById(R.id.iv_item_shopcart_cloth_minus);
        ivShopCartClothAdd = itemView.findViewById(R.id.iv_item_shopcart_cloth_add);
        ivShopCartClothPic = itemView.findViewById(R.id.iv_item_shopcart_cloth_pic);
        ivShopCartClothDelete = itemView.findViewById(R.id.iv_item_shopcart_cloth_delete);
    }
}

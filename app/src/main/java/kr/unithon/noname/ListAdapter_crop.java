package kr.unithon.noname;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by yunjiseon on 2018. 1. 28..
 */

public class ListAdapter_crop extends BaseAdapter {
    Context context;
    TextView textView_nickname;
    TextView textView_farmname;
    TextView textView_Dday;
    ImageView farm_imageView;
    ArrayList<list_cropItem> list_itemArrayList;
    int profile_number;

    public ListAdapter_crop(Context context, ArrayList<list_cropItem> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;

    }

    @Override
    public int getCount() {
        return this.list_itemArrayList.size();

    }

    @Override
    public Object getItem(int position) {
        return list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.mycrop_item,null);
            textView_Dday = (TextView)convertView.findViewById(R.id.Item_Dday);
            textView_farmname= (TextView)convertView.findViewById(R.id.Item_farmName);
            farm_imageView = (ImageView)convertView.findViewById(R.id.ItemImage); // dlalwl
            textView_nickname =(TextView)convertView.findViewById(R.id.Item_nickname);
        }
        textView_Dday.setText("재배까지 D-"+String.valueOf(list_itemArrayList.get(position).getDday()));
        textView_nickname.setText(list_itemArrayList.get(position).getNickname());
        textView_farmname.setText(list_itemArrayList.get(position).getFarmname());

        Glide.with(context)
                .load(list_itemArrayList.get(position).getProfile_image())
                .apply(new RequestOptions().centerCrop())
                .into(farm_imageView);
        return convertView;
    }

}

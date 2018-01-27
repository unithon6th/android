package kr.unithon.noname;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yunjiseon on 2018. 1. 27..
 *
 * private String cropname;
 private int profile_image;
 public String farmname;
 private String content;
 */

public class ListAdapter_farm extends BaseAdapter {
    Context context;
    TextView farmname_textView;
    TextView cropname_textView;
    TextView content_textView;
    ImageView farm_imageView;
    ArrayList<list_farmItem> list_itemArrayList;
    int profile_number;

    public ListAdapter_farm(Context context, ArrayList<list_farmItem> list_itemArrayList) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.farm_item,null);
            farmname_textView = (TextView)convertView.findViewById(R.id.Item_farmName);
            content_textView = (TextView)convertView.findViewById(R.id.ItemComment);

            farm_imageView = (ImageView)convertView.findViewById(R.drawable.cabbage);
            cropname_textView =(TextView)convertView.findViewById(R.id.Item_cropname);
        }
        farmname_textView.setText(list_itemArrayList.get(position).getFarmname());
        content_textView.setText(list_itemArrayList.get(position).getContent());
        cropname_textView.setText(list_itemArrayList.get(position).getContent());
        profile_number=list_itemArrayList.get(position).getProfile_image();
        if(profile_number==1) {
            farm_imageView.setImageResource(R.drawable.cabbage);
        }
        return convertView;
    }

}

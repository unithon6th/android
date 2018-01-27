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

import org.w3c.dom.Text;

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
    TextView Sort_textView;
    TextView cropname_textView;
    TextView content_textView;
    TextView price_textView;
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
            Sort_textView = (TextView)convertView.findViewById(R.id.Item_sort);
           // content_textView = (TextView)convertView.findViewById(R.id.ItemComment);
            price_textView= (TextView)convertView.findViewById(R.id.price);
            farm_imageView = (ImageView)convertView.findViewById(R.id.ItemImage);
            cropname_textView =(TextView)convertView.findViewById(R.id.Item_cropname);
        }
        Sort_textView.setText(list_itemArrayList.get(position).getSort());
        // content_textView.setText(list_itemArrayList.get(position).getContent());
        cropname_textView.setText(list_itemArrayList.get(position).getContent());
        Glide.with(context)
                .load(list_itemArrayList.get(position).getProfile_image())
                .apply(new RequestOptions().centerCrop())
                .into(farm_imageView);

        price_textView.setText(
                String.valueOf(
                list_itemArrayList.get(position).getPrice()
                )
        );

        return convertView;
    }

}

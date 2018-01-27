package kr.unithon.noname.MyList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.animation.content.Content;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import kr.unithon.noname.R;

/**
 * Created by HANSUNG on 2018-01-28.
 */

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private ArrayList<Product> mItems;
    Context context;

    public MyListAdapter(ArrayList<Product> mItems, Context context) {
        this.mItems = mItems;
        this.context = context;
    }

    //ViewHolder는 사용자 정의 클레스다. 상속된 클레스로 하면 안된다. 내가 직접 만들어야 함.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView Dday;
        public TextView title;
        public TextView content;

        public ViewHolder(View v) {
            super(v);
            img = (ImageView) v.findViewById(R.id.img);
            Dday = (TextView) v.findViewById(R.id.Dday);
            title = (TextView) v.findViewById(R.id.title);
            content = (TextView) v.findViewById(R.id.content);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    //보여줄 Layout을 생성함.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    //View에 보여줄 데이터를 묶어줌
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Dday.setText(mItems.get(position).getDday());
        holder.title.setText(mItems.get(position).getTitle());
        holder.content.setText(mItems.get(position).getContent());
        String url = mItems.get(position).getImageUrl();

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().centerCrop())
                .into(holder.img);
    }

    //item 갯수
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
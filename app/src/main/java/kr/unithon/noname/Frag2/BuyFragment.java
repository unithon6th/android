package kr.unithon.noname.Frag2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.unithon.noname.MyList.MyListAdapter;
import kr.unithon.noname.MyList.Product;
import kr.unithon.noname.R;

/**
 * Created by user on 2018-01-27.
 */

public class BuyFragment extends Fragment {
    private static final String TAG = "BuyFragment";
    Context mcontext;
    public ArrayList<Product2> result2;
    RecyclerView.LayoutManager mGridLayoutManager;
    RecyclerView mRecyclerview;
    MyListAdapter2 myListAdapter2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mcontext = getActivity();
        result2 = new ArrayList<>();

        for(int i=0; i<10; i++){
            result2.add(new Product2("http://tong.visitkorea.or.kr/cms/resource/74/2018174_image2_1.JPG","1","1","1",5000));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mRecyclerview = rootView.findViewById(R.id.rView2);
        mRecyclerview.setHasFixedSize(true);
        mGridLayoutManager = new GridLayoutManager(mcontext,2);
        mRecyclerview.setLayoutManager(mGridLayoutManager);

        myListAdapter2 = new MyListAdapter2(result2,mcontext);
        mRecyclerview.setAdapter(myListAdapter2);
        return rootView;
    }
}

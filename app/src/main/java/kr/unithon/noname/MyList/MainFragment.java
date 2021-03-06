package kr.unithon.noname.MyList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.unithon.noname.R;

/**
 * Created by user on 2018-01-27.
 */

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private Context mContext;
    ArrayList<Product> result;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView mRecyclerview;
    MyListAdapter myListAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        result = new ArrayList<>();
        for(int i=0; i<10; i++){
            result.add(
                    new Product(
                            "http://www.farmtail.com/shopimages/farmtail/005019000006.jpg?1450922764",
                            "재배 까지 D-72",
                            "셀팜농장",
                            "내 배추 다섯포기"
                    )
            );
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);
        mRecyclerview = rootView.findViewById(R.id.vView);
        mRecyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerview.setLayoutManager(layoutManager);

        myListAdapter = new MyListAdapter(result,mContext);
        mRecyclerview.setAdapter(myListAdapter);
        return rootView;
    }
}

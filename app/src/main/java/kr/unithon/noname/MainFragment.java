package kr.unithon.noname;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by user on 2018-01-27.
 */

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";


    private Context mContext;

    GridView gridView;
    ListAdapter_crop myListAdapter;
    ArrayList<list_cropItem> list_itemArrayList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mycroplist, container, false);
        FarmMenu(rootView);
        return rootView;
    }

    public void FarmMenu(View view) {

        gridView = view.findViewById(R.id.cropGridlist);
        list_itemArrayList = new ArrayList<list_cropItem>();
        list_itemArrayList.add(
                new list_cropItem("http://cfile27.uf.tistory.com/image/2052E343504D53C106B2DC", "부락리배추", "쁘띠 농장 직거래 배추", 78));
        list_itemArrayList.add(
                new list_cropItem("http://cfile27.uf.tistory.com/image/2052E343504D53C106B2DC", "내 당근", "당근농장 당근 2년차 ", 100));
        list_itemArrayList.add(
                new list_cropItem("http://cfile27.uf.tistory.com/image/2052E343504D53C106B2DC", "부락리배추", "쁘띠 농장 직거래 배추", 78));
        list_itemArrayList.add(
                new list_cropItem("http://cfile27.uf.tistory.com/image/2052E343504D53C106B2DC", "내 당근", "당근농장 당근 2년차 ", 100));
        myListAdapter = new ListAdapter_crop(getActivity(), list_itemArrayList);
        gridView.setAdapter(myListAdapter);

    }
}

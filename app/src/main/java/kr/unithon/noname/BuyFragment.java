package kr.unithon.noname;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-01-27.
 */

public class BuyFragment extends Fragment {
    private static final String TAG = "BuyFragment";
    private Button BuyCrops;
    private Context mContext;
    ListView listView;
    ListAdapter_farm myListAdapter;
    ArrayList<list_farmItem> list_itemArrayList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);
        FarmMenu(rootView);
        return rootView;
    }

    public void FarmMenu(View view) {

       listView = view.findViewById(R.id.farmgridlist);
        list_itemArrayList = new ArrayList<list_farmItem>();
          list_itemArrayList.add(
                new list_farmItem("http://cfile27.uf.tistory.com/image/2052E343504D53C106B2DC", "배추", 50000, "쁘띠 농장 직거래 배추", "채소"));
        list_itemArrayList.add(
                new list_farmItem("http://cfile27.uf.tistory.com/image/2052E343504D53C106B2DC", "당근", 3000, "당근농장 당근 2년차 ", "채소"));

        myListAdapter = new ListAdapter_farm(getActivity(), list_itemArrayList);


    }

}

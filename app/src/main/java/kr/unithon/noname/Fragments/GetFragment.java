package kr.unithon.noname.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.unithon.noname.ListAdapter_crop;
import kr.unithon.noname.R;
import kr.unithon.noname.SearchAdapter;
import kr.unithon.noname.list_cropItem;

/**
 * Created by user on 2018-01-27.
 */

public class GetFragment extends Fragment {


    private Context mContext;

    ListView listView;
    ListAdapter_crop myListAdapter;
    ArrayList<list_cropItem> list_itemArrayList;
    private List<String> list;          // 데이터를 넣은 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
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
        listView = view.findViewById(R.id.cropGridlist);
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

      //  listView.setAdapter(myListAdapter);

}

}

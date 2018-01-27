package kr.unithon.noname;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by yunjiseon on 2018. 1. 27..
 */
 //분양 받을 농장 리스트 전체 페이지 (for page1)
public class fragment_farmContent extends Fragment {
    ListView FarmlistView;
    ArrayAdapter<String> adapter;
    TextView textView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview_farm_item, container, false);

        return rootView;
    }



}

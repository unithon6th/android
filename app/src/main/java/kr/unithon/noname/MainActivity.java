package kr.unithon.noname;

import android.app.Dialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GridView gridView;
    ListAdapter_farm myListAdapter;
    ArrayList<list_farmItem> list_itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_farm_item); // 첫페이지 임시로
        ShowDialog();

    }

    public void FarmMenu()
    {
        gridView= (GridView)findViewById(R.id.farmgridlist);
        list_itemArrayList = new ArrayList<list_farmItem>();
        list_itemArrayList.add(
                new list_farmItem(1,"배추",50000,"쁘띠 농장 직거래 배추","채소"));
        list_itemArrayList.add(
                new list_farmItem(2,"당근",3000,"당근농장 당근 2년차 ","채소"));

        myListAdapter = new ListAdapter_farm(MainActivity.this,list_itemArrayList);
        listView.setAdapter(myListAdapter);

    }
    public  void ShowDialog() // 인기작물 팝업 생성 // jiseon
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.favorite_popuptemp, null);
        final Dialog myDialog = new Dialog(this);

        myDialog.setContentView(dialogLayout);
        myDialog.show();

        Button btn_cancel = (Button)dialogLayout.findViewById(R.id.closeBtn);

        btn_cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myDialog.cancel();
            }
        });


    }


}




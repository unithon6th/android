package kr.unithon.noname;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListAdapter_farm myListAdapter;
    ArrayList<list_farmItem> list_itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowDialog();
/*
        listView = (ListView)findViewById(R.id.farmlist);
        list_itemArrayList = new ArrayList<list_farmItem>();
        list_itemArrayList.add(
                new list_farmItem(1,"배추","배추농장1","배추만 10년"));
        list_itemArrayList.add(
                new list_farmItem(2,"당근","당근농장1","당근 2년차 "));

        myListAdapter = new ListAdapter_farm(MainActivity.this,list_itemArrayList);
        listView.setAdapter(myListAdapter);*/

    }

    public  void ShowDialog() // 다이얼로그 생성하는 함수임. jiseon.
    {   int NameId;
        int InfoId;

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




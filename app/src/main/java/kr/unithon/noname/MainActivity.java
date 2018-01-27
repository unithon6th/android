package kr.unithon.noname;

import android.app.Dialog;
import android.support.design.widget.TabLayout;
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
        setContentView(R.layout.activity_main);
        setupViewPager();
        ShowDialog();


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


    /**
     * 탭들....
     */
    private void setupViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment());
        adapter.addFragment(new BuyFragment());
        adapter.addFragment(new ProfileFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("내 베지");
        tabLayout.getTabAt(1).setText("새 매치");
        tabLayout.getTabAt(2).setText("내 정보");
    }
}




package kr.unithon.noname;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Dialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.unithon.noname.Frag2.BuyFragment;
import kr.unithon.noname.Fragments.ProfileFragment;
import kr.unithon.noname.MyList.MainFragment;
import kr.unithon.noname.ui.base.BaseActivity;


public class MainActivity extends BaseActivity {
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

    public void ShowDialog() // 인기작물 팝업 생성 // jiseon
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.favorite_popuptemp, null);
        final Dialog myDialog = new Dialog(this);

        myDialog.setContentView(dialogLayout);
        myDialog.show();

        Button btn_cancel = (Button) dialogLayout.findViewById(R.id.closeBtn);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.cancel();
            }
        });


    }


    /**
     * 탭들....
     */
    private void setupViewPager() {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFragment());
        adapter.addFragment(new BuyFragment());
        adapter.addFragment(new ProfileFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TextView tab1 = findViewById(R.id.tab_1);
        TextView tab2 = findViewById(R.id.tab_2);
        TextView tab3 = findViewById(R.id.tab_3);

        tab1.setTag(1);
        tab2.setTag(2);
        tab3.setTag(3);

        View.OnClickListener onClickListener = view -> {
            tab1.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.pale_grey));
            tab2.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.pale_grey));
            tab3.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.pale_grey));
            switch ((int)view.getTag()){
                case 1:
                    tab1.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.aqua_marine));
                    viewPager.setCurrentItem(0);
                    break;
                case 2:
                    tab2.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.aqua_marine));
                    viewPager.setCurrentItem(1);
                    break;
                case 3:
                    tab3.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.aqua_marine));
                    viewPager.setCurrentItem(2);
                    break;
            }

        };

        tab1.setOnClickListener(onClickListener);
        tab2.setOnClickListener(onClickListener);
        tab3.setOnClickListener(onClickListener);

        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        tab1.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.pale_grey));
                        tab2.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.pale_grey));
                        tab3.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.pale_grey));
                        switch (position){
                            case 0:
                                tab1.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.aqua_marine));
                                break;
                            case 1:
                                tab2.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.aqua_marine));
                                break;
                            case 2:
                                tab3.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.aqua_marine));
                                break;

                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                }
        );
    }
}




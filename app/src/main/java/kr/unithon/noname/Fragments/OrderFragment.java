package kr.unithon.noname.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import kr.unithon.noname.R;

/**
 * Created by user on 2018-01-28.
 */

public class OrderFragment extends Fragment implements View.OnClickListener {
    private Context mContext;
    Button btnplus, btnminus;
    TextView quantity;
    TextView quantity2;
    int counter = 0;

Spinner typesofVeges, optionsVeges;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

String[] veges ={"배추", "토마토", "감귤", "오이", "피망", "양파"};
    String[] options = {"유기농", "오리케어", "농약"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ordercrop, container, false);

        typesofVeges=(Spinner)rootView.findViewById(R.id.spinner1);
        optionsVeges=(Spinner)rootView.findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, veges);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, options);
        typesofVeges.setAdapter(adapter);
        typesofVeges.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int sid = typesofVeges.getSelectedItemPosition();
                Toast.makeText(getContext(),veges[sid]+"를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        optionsVeges.setAdapter(adapter2);
        optionsVeges.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int sid2 = optionsVeges.getSelectedItemPosition();
                Toast.makeText(getContext(), veges[sid2]+"를 선택하셨습니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnplus = (Button)rootView.findViewById(R.id.plus);
        btnminus = (Button)rootView.findViewById(R.id.minus);
        quantity = (TextView)rootView.findViewById(R.id.textView8);
        quantity2 = (TextView)rootView.findViewById(R.id.textView9);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);

        quantity.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        quantity2.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(view==btnplus){
            counter+=5;
            quantity.setText(Integer.toString(counter));
            quantity2.setText(Integer.toString(counter));
        }
        if(view==btnminus){
            counter-=5;
            quantity.setText(Integer.toString(counter));
            quantity2.setText(Integer.toString(counter));
        }

    }
}

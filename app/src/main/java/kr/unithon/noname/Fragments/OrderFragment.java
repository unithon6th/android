package kr.unithon.noname.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import kr.unithon.noname.R;

/**
 * Created by user on 2018-01-28.
 */

public class OrderFragment extends Fragment {
    private Context mContext;
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
        return rootView;
    }
}

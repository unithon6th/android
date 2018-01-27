package kr.unithon.noname.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kr.unithon.noname.R;

/**
 * Created by user on 2018-01-27.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private Button EditProfile;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
       EditProfile= (Button)rootView.findViewById(R.id.edit_profile);
       EditProfile.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, EditProfileFragment.class);
        startActivity(intent);
    }
}

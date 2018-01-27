package kr.unithon.noname.ui.crop.detail.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import kr.unithon.noname.R;
import kr.unithon.noname.databinding.CardPhotoBinding;
import kr.unithon.noname.databinding.ViewCropPhotoBinding;
import kr.unithon.noname.ui.base.BaseCustomView;

public class CropPhotoView extends BaseCustomView<ViewCropPhotoBinding> {

    public CropPhotoView(Context context) {
        super(context);

        init();
    }

    public CropPhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        inflateView(R.layout.view_crop_photo);

        //더미 데이터
        ArrayList<String> dummyList = new ArrayList<>();
        dummyList.add("http://cfile5.uf.tistory.com/image/0138DA4A518369A51848A3");
        dummyList.add("http://cfile239.uf.daum.net/image/12300C174C8069D782F83F");
        dummyList.add("http://www.humantech2000.com/files/attach/images/166/097/086/02.jpg");
        setPhotoList(dummyList);
    }

    public void setPhotoList(ArrayList<String> photoList){
        binding.container.removeAllViews();

        for(String photoUrl : photoList){
            CardPhotoBinding photoBinding = createPhotoViewBinding();
            Glide.with(getContext())
                    .load(photoUrl)
                    .apply(new RequestOptions().centerCrop())
                    .into(photoBinding.image);
            binding.container.addView(photoBinding.getRoot());
        }
    }

    private CardPhotoBinding createPhotoViewBinding(){
        CardPhotoBinding photoBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.card_photo,
                null,
                false
        );
        return photoBinding;
    }

}

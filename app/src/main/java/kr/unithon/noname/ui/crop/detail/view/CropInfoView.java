package kr.unithon.noname.ui.crop.detail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import kr.unithon.noname.R;
import kr.unithon.noname.databinding.ViewCropInfoBinding;
import kr.unithon.noname.ui.base.BaseCustomView;

public class CropInfoView extends BaseCustomView<ViewCropInfoBinding> {

    public CropInfoView(Context context) {
        super(context);

        init();
    }

    public CropInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        inflateView(R.layout.view_crop_info);

        initViews();
    }

    private void initViews() {
        Glide.with(getContext())
                .load(R.drawable.background_detail)
                .apply(RequestOptions.centerCropTransform())
                .into(binding.background);

        startAnimation();
    }

    private void startAnimation(){
        ValueAnimator animator = ValueAnimator.ofFloat(
                0f,
                1f
        );
        animator.setDuration(800);
        animator.setStartDelay(3000);
        animator.addUpdateListener(valueAnimator -> {
            float value = (float) valueAnimator.getAnimatedValue();
            binding.dateContainer.setAlpha(value);
        });
        animator.start();
    }
}

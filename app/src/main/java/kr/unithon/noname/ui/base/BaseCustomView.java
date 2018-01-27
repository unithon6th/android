package kr.unithon.noname.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class BaseCustomView<T extends ViewDataBinding> extends FrameLayout {

    protected T binding;

    public BaseCustomView(Context context) {
        super(context);
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    protected void inflateView(@LayoutRes int layoutId) {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                layoutId,
                this,
                true
        );
    }

}

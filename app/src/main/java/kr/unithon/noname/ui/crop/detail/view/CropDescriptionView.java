package kr.unithon.noname.ui.crop.detail.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import kr.unithon.noname.R;
import kr.unithon.noname.databinding.ViewCropDescriptionBinding;
import kr.unithon.noname.ui.base.BaseCustomView;

public class CropDescriptionView extends BaseCustomView<ViewCropDescriptionBinding> {

    public CropDescriptionView(Context context) {
        super(context);

        init();
    }

    public CropDescriptionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        inflateView(R.layout.view_crop_description);
    }
}

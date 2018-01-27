package kr.unithon.noname.ui.crop.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import kr.unithon.noname.R;
import kr.unithon.noname.api.Api;
import kr.unithon.noname.api.NetworkRequest;
import kr.unithon.noname.ui.base.BaseActivity;
import kr.unithon.noname.ui.common.LoadingDialog;

public class CropDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_detail);

        init();
    }

    private void init() {
        requestCropDetail(null);
    }

    private void requestCropDetail(String cropId) {
        NetworkRequest.request(
                Api.getDummyInstance().getCropDetail(cropId),
                crop -> {
                    Log.i("hello", "crop : " + crop);
                }
        );
    }


}

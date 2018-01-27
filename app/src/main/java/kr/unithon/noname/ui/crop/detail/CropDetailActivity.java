package kr.unithon.noname.ui.crop.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.Single;
import kr.unithon.noname.APITTS;
import kr.unithon.noname.R;
import kr.unithon.noname.api.Api;
import kr.unithon.noname.api.NetworkRequest;
import kr.unithon.noname.model.Crop;
import kr.unithon.noname.ui.base.BaseActivity;
import kr.unithon.noname.ui.common.LoadingDialog;
import kr.unithon.noname.ui.crop.detail.view.CropInfoView;
import kr.unithon.noname.ui.crop.detail.view.ReadingListener;

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

    private void requestCropDetail(String cropJson) {
        Crop crop = new Crop();
        crop.sgid = 2;
        crop.pgid = 3;
        crop.nickname = "양파";
        crop.purchase_amount = 2;
        crop.purchase_date = "2018-01-26";

        NetworkRequest.request(
                Api.getDummyInstance().getCropDetail(
                        "application/json",
                        crop
                ),
                result -> {
                    ((CropInfoView)findViewById(R.id.car_info_view)).setTextList(
                            result.voiceTextList,
                            result.dday,
                            text -> {

                            }
                    );

                }
        );
    }


}

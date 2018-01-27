package kr.unithon.noname.util;

import java.util.ArrayList;
import java.util.Date;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kr.unithon.noname.api.ApiService;
import kr.unithon.noname.model.Crop;
import kr.unithon.noname.model.CropStatus;
import kr.unithon.noname.model.GroupType;
import kr.unithon.noname.model.RecommendGroup;

public class DummyNetwork implements ApiService {

    @Override
    public Single<ArrayList<RecommendGroup>> getRecommendCropList() {
        return Single.create(emitter -> {
            emitter.onSuccess(createDummyRecommendGroupList());
        });
    }

    @Override
    public Single<ArrayList<Crop>> getMyCropList(String userId) {
        return Single.create(emitter -> {
            emitter.onSuccess(createDummyCropList());
        });
    }

    @Override
    public Single<Crop> getCropDetail(String cropId) {
        return Single.create(emitter -> {
            emitter.onSuccess(createDummyCrop());
        });
    }

    private ArrayList<RecommendGroup> createDummyRecommendGroupList() {
        ArrayList<RecommendGroup> recommendGroupList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            recommendGroupList.add(createDummyRecommendGroup());
        }
        return recommendGroupList;
    }

    private RecommendGroup createDummyRecommendGroup() {
        RecommendGroup recommendGroup = new RecommendGroup();
        recommendGroup.name = "인기있는 작물";
        recommendGroup.groupType = GroupType.CROP;
        recommendGroup.cropList = createDummyCropList();
        return recommendGroup;
    }

    private ArrayList<Crop> createDummyCropList() {
        ArrayList<Crop> cropList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cropList.add(createDummyCrop());
        }
        return cropList;
    }

    private Crop createDummyCrop() {
        Crop crop = new Crop();
        crop.id = "12345678";
        crop.status = CropStatus.GROWING;
        crop.name = "양배추";
        crop.nickname = "김배추";
        crop.price = 3600;
        crop.description = "100% 국내산 토종 푸른 배추입니다. 개화까지 6개월이 소요됩니다.";
        crop.harvestDate = null;
        crop.startDate = null;
        crop.mainImageUrl = "http://www.ypsori.com/news/photo/201711/12231_11814_3730.jpg";
        return crop;
    }
}

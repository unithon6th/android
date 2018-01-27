package kr.unithon.noname.api;

import java.util.ArrayList;

import io.reactivex.Single;
import kr.unithon.noname.model.Crop;

public interface ApiService {

    // 내 작물 조회 API
    Single<ArrayList<Crop>> getMyCropList(String userId);

    // 작물 상세 API
    Single<Crop> getCropDetail(String cropId);

}

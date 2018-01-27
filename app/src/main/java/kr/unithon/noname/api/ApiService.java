package kr.unithon.noname.api;

import java.util.ArrayList;

import io.reactivex.Single;
import kr.unithon.noname.model.Crop;
import kr.unithon.noname.model.RecommendGroup;
import kr.unithon.noname.model.VoiceResponse;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    // 추천 작물 조회 API
    @GET("sales/findAll")
    Single<ArrayList<Crop>> getRecommendCropList();

    // 내 작물 조회 API
    Single<ArrayList<Crop>> getMyCropList(String userId);

    // 작물 상세 API
    @POST("purchase/detail")
    Single<VoiceResponse> getCropDetail(
            @Header("Content-Type") String contentType,
            @Body Crop body
    );

}

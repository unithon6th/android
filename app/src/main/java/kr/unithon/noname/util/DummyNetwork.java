package kr.unithon.noname.util;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kr.unithon.noname.api.ApiService;
import kr.unithon.noname.model.Crop;

public class DummyNetwork implements ApiService {

    @Override
    public Single<ArrayList<Crop>> getMyCropList(String userId) {
        return Single.create(emitter -> {
            ArrayList<Crop> dummyCropList = new ArrayList<>();
            dummyCropList.add(
                    new Crop()
            );
            dummyCropList.add(
                    new Crop()
            );

            emitter.onSuccess(dummyCropList);
        });
    }

    @Override
    public Single<Crop> getCropDetail(String cropId) {
        return Single.create(emitter -> {
            emitter.onSuccess(new Crop());
        });
    }
}

package kr.unithon.noname.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NetworkRequest {

    private static final long DUMMY_DELAY_MILLISECONDS = 1000 * 2;

    public static <T> Disposable request(Single<T> request, Consumer<T> consumer) {
        return request.delay(DUMMY_DELAY_MILLISECONDS, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        consumer,
                        throwable -> {
                            Log.e(NetworkRequest.class.getSimpleName(), throwable.getMessage());
                            throwable.printStackTrace();
                        }
                );
    }

}

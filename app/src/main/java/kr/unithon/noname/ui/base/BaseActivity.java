package kr.unithon.noname.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import kr.unithon.noname.ui.common.LoadingDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseActivity extends AppCompatActivity {

    private Handler uiHandler;
    private LoadingDialog loadingDialog;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiHandler = new Handler();
    }

    protected void post(Runnable runnable) {
        uiHandler.post(runnable);
    }

    protected void postDelayed(Runnable runnable, long delayMillis) {
        uiHandler.postDelayed(runnable, delayMillis);
    }

    protected void showToast(String text) {
        Toast.makeText(
                getBaseContext(),
                text,
                Toast.LENGTH_LONG
        ).show();
    }

    protected void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getBaseContext());
        }

        loadingDialog.show();
    }

    protected void hideLoadingDialog() {
        loadingDialog.hide();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

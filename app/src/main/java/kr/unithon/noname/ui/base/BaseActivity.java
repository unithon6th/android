package kr.unithon.noname.ui.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    private Handler uiHandler;

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

}

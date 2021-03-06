package kr.unithon.noname.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import kr.unithon.noname.DetailActivity;
import kr.unithon.noname.MainActivity;
import kr.unithon.noname.R;
import kr.unithon.noname.ui.base.BaseActivity;

import static com.nhn.android.naverlogin.OAuthLogin.mOAuthLoginHandler;

/**
 * Created by HANSUNG on 2018-01-27.
 */

public class LoginActivity extends BaseActivity {
    OAuthLogin mOAuthLoginModule;
    OAuthLoginButton authLoginButton;
    Context mContext;
    private static String OAUTH_CLIENT_ID = "dTTdkwEIOA4dIOTUexT1";
    private static String OAUTH_CLIENT_SECRET = "Q8dV9axjuG";
    private static String OAUTH_CLIENT_NAME = "네이버 아이디로 로그인";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

//        getSupportActionBar().hide();

        authLoginButton = findViewById(R.id.btn_login);
        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(
                LoginActivity.this
                , OAUTH_CLIENT_ID
                , OAUTH_CLIENT_SECRET
                , OAUTH_CLIENT_NAME

        );
        authLoginButton.setOnClickListener(v -> {
            OAuthLogin.getInstance().startOauthLoginActivity(LoginActivity.this, mOAuthLoginHandler);
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        });
        if (mOAuthLoginModule.getAccessToken(this) != null) {
            startActivity(new Intent(this,MainActivity.class));
        } else {
            authLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
            //위 코드가 네이버 아이디 로그인을 요청하는 코드입니다.
        }
    }

    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                final String accessToken = mOAuthLoginModule.getAccessToken(mContext);

                String refreshToken = mOAuthLoginModule.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginModule.getExpiresAt(mContext);
                String tokenType = mOAuthLoginModule.getTokenType(mContext);
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode
                        + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }
    };

}

package kr.unithon.noname;

import android.Manifest;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

/**
 * Created by HANSUNG on 2018-01-27.
 */

public class DetailActivity extends AppCompatActivity{
    private NaverTTSTask mNaverTTSTask;
    String[] mTextString;
    EditText etText;
    Button btTTS, btReset;
    ArrayList<String> ttsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etText = (EditText) findViewById(R.id.et_text);
        btTTS = (Button) findViewById(R.id.bt_tts);
        btReset = (Button) findViewById(R.id.bt_reset);
        ttsList = new ArrayList<>();

        ttsList.add("오늘은 비를 맞았어요");
        ttsList.add("저는 거의 다 익었어요");
        ttsList.add("오늘은 광합성 짱이에요");

        //버튼 클릭이벤트 - 클릭하면 에디터뷰에 있는 글자를 가져와서 네이버에 보낸다. MP3로 바꿔 달라고 ...
        btTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용자가 입력한 텍스트를 이 배열변수에 담는다.
                String mText;
                if (etText.getText().length() > 0) { //한글자 이상 1
                    mText = etText.getText().toString();
                    mTextString = new String[]{mText};

                    //AsyncTask 실행
                    mNaverTTSTask = new NaverTTSTask();
                    mNaverTTSTask.execute(mTextString);
                } else {
                    Toast.makeText(DetailActivity.this, "텍스트를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //리셋버튼
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etText.setText("");
                etText.setHint("텍스트를 입력하세요.");
            }
        });

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(DetailActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(DetailActivity.this, "권한이 거부되었습니다. 권한거부시 앱기능 일부분을 사용하실수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.with(DetailActivity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }
    private class NaverTTSTask extends AsyncTask<String[], Void, String> {

        @Override
        protected String doInBackground(String[]... strings) {
            //여기서 서버에 요청
            APITTS.main(mTextString);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //방금 받은 파일명의 mp3가 있으면 플레이 시키자. 맞나 여기서 하는거?
            //아닌가 파일을 만들고 바로 실행되게 해야 하나? AsyncTask 백그라운드 작업중에...?

        }
    }
}

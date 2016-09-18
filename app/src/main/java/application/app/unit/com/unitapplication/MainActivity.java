package application.app.unit.com.unitapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.utils.ScreenUtils;
import com.github.lazylibrary.util.DoubleClickExitDetector;
import com.github.lazylibrary.util.LogUtil;
import com.github.lazylibrary.util.ShortCutUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected Button mainButton1;
    protected Button mainButton2;
    protected Button mainButton3;
    DoubleClickExitDetector doubleClickExitDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenUtils.hideStatusBar(this);
        ScreenUtils.hideNotificationBar(this);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        doubleClickExitDetector = new DoubleClickExitDetector(this);
//        LogUtil.e("ShellUtils.isRoot()"+ShellUtils.isRoot(),true);
//        LogUtil.e("DeviceUtils.getMacAddress()"+ DeviceUtils.getMacAddress(),true);
        initView();
    }

    @Override
    public void onBackPressed() {


        doubleClickExitDetector.setEffectiveIntervalTime(2000);
        if (doubleClickExitDetector.click()) {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.main_button1) {
            if(ShortCutUtils.hasShortcut(this)) {
                LogUtil.e("存在", false);
            }else{
                LogUtil.e("不存在", false);

            }
        } else if (view.getId() == R.id.main_button2) {
            ShortCutUtils.delShortcut(this);
        } else if (view.getId() == R.id.main_button3) {
            ShortCutUtils.addShortcut(this,R.mipmap.ic_launcher);
        }
    }

    private void initView() {
        mainButton1 = (Button) findViewById(R.id.main_button1);
        mainButton1.setOnClickListener(MainActivity.this);
        mainButton2 = (Button) findViewById(R.id.main_button2);
        mainButton2.setOnClickListener(MainActivity.this);
        mainButton3 = (Button) findViewById(R.id.main_button3);
        mainButton3.setOnClickListener(MainActivity.this);
    }
}

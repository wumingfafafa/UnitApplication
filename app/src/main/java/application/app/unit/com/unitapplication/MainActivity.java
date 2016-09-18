package application.app.unit.com.unitapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.utils.ScreenUtils;
import com.github.lazylibrary.util.DoubleClickExitDetector;

public class MainActivity extends AppCompatActivity {
    DoubleClickExitDetector doubleClickExitDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenUtils.hideStatusBar(this);
        ScreenUtils.hideNotificationBar(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doubleClickExitDetector = new DoubleClickExitDetector(this);
//        LogUtil.e("ShellUtils.isRoot()"+ShellUtils.isRoot(),true);
//        LogUtil.e("DeviceUtils.getMacAddress()"+ DeviceUtils.getMacAddress(),true);
    }

    @Override
    public void onBackPressed() {


        doubleClickExitDetector.setEffectiveIntervalTime(2000);
        if(doubleClickExitDetector.click()){
            super.onBackPressed();
            finish();
        }
    }
}

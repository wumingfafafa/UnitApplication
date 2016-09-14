package application.app.unit.com.unitapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.utils.DeviceUtils;
import com.blankj.utilcode.utils.ShellUtils;

import application.app.unit.com.unitapplication.log.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.e("ShellUtils.isRoot()"+ShellUtils.isRoot(),true);
        LogUtil.e("DeviceUtils.getMacAddress()"+ DeviceUtils.getMacAddress(),true);
    }
}

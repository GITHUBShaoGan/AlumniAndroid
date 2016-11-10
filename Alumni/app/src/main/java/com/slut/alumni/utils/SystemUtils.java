package com.slut.alumni.utils;

import android.app.Activity;
import android.view.WindowManager;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class SystemUtils {

    /**
     * 隐藏状态栏
     *
     * @param activity
     */
    public static void hideStatusBar(Activity activity) {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 显示状态栏
     *
     * @param activity
     */
    public static void showStatusBar(Activity activity) {
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }

}

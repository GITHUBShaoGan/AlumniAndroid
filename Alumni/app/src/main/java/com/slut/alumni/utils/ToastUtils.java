package com.slut.alumni.utils;

import android.widget.Toast;

import com.slut.alumni.App;

/**
 * Created by 七月在线科技 on 2016/11/9.
 */

public class ToastUtils {

    /**
     * 显示短toast
     *
     * @param text
     */
    public static void showShort(String text) {
        if (StringUtils.isNullOrEmpty(text)) {
            return;
        }
        Toast.makeText(App.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示短toast
     *
     * @param text
     */
    public static void showLong(String text) {
        if (StringUtils.isNullOrEmpty(text)) {
            return;
        }
        Toast.makeText(App.getContext(), text, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示短toast
     *
     * @param text
     */
    public static void showShort(int text) {
        Toast.makeText(App.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示短toast
     *
     * @param text
     */
    public static void showLong(int text) {
        Toast.makeText(App.getContext(), text, Toast.LENGTH_LONG).show();
    }

}

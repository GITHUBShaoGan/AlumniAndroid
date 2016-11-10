package com.slut.alumni.utils;

import android.text.TextUtils;

import com.slut.alumni.App;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class StringUtils {

    public static String getStringFromRes(int id) {
        return App.getContext().getString(id);
    }

    /**
     * 判断字符串是否为空或为空串
     *
     * @param text
     * @return
     */
    public static boolean isNullOrEmpty(String text) {
        return text == null || TextUtils.equals("", text.trim());
    }

    /**
     * 校验密码位数是否合理
     *
     * @param text
     * @return
     */
    public static boolean isPasswordUseful(String text) {
        if (text == null) {
            return false;
        }
        return text.trim().length() >= 4 && text.trim().length() <= 128;
    }

    /**
     * md5加密字符串
     *
     * @param string
     * @return
     */
    public static String MD5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}

package com.slut.alumni.utils;

import android.content.Context;
import android.os.Environment;

import com.slut.alumni.App;

import java.io.File;

/**
 * Created by 七月在线科技 on 2016/11/11.
 */

public class FileUtils {

    /**
     * 创建图片缓存目录
     *
     * @return
     */
    public static File createImageCacheSavePath() {
        String path;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            path = App.getContext().getExternalCacheDir().getAbsolutePath() + File.separator + "imageCache" + File.separator;
        } else {
            path = File.separator + "imageCache" + File.separator;
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }


}

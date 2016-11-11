package com.slut.alumni;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.slut.alumni.bean.gson.LoginBean;
import com.slut.alumni.utils.FileUtils;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class App extends Application {

    private static Context context;
    private static LoginBean loginBean;
    private static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(getApplicationContext());
        initOKGo();
        setGson(new Gson());
        initUniversalImageLoader();
    }

    private void initOKGo() {
        OkGo.init(this);
        OkGo.getInstance()
                .debug("OkGo")
                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS);    //全局的写入超时时间
    }

    private void initUniversalImageLoader() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 2)//设置线程优先级
                .threadPoolSize(4)//线程池内加载的数量,推荐范围1-5内。
                .denyCacheImageMultipleSizesInMemory()//当同一个Uri获取不同大小的图片缓存到内存中时只缓存一个。不设置的话默认会缓存多个不同大小的图片
                .memoryCacheExtraOptions(480, 800)//内存缓存文件的最大长度
                .memoryCache(new LruMemoryCache(10 * 1024 * 1024))//内存缓存方式,这里可以换成自己的内存缓存实现。(推荐LruMemoryCache,道理自己懂的)
                .memoryCacheSize(10 * 1024 * 1024)//内存缓存的最大值
                .diskCache(new UnlimitedDiskCache(FileUtils.createImageCacheSavePath()))//可以自定义缓存路径
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//对保存的URL进行加密保存
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(getApplicationContext(), 5 * 1000, 30 * 1000))//设置连接时间5s,超时时间30s
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(configuration);
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        App.context = context;
    }

    public static LoginBean getLoginBean() {
        return loginBean;
    }

    public static void setLoginBean(LoginBean loginBean) {
        App.loginBean = loginBean;
    }

    public static Gson getGson() {
        return gson;
    }

    public static void setGson(Gson gson) {
        App.gson = gson;
    }
}

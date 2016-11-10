package com.slut.alumni;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.slut.alumni.bean.gson.LoginBean;

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
    }

    private void initOKGo() {
        OkGo.init(this);
        OkGo.getInstance()
                .debug("OkGo")
                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS);    //全局的写入超时时间
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

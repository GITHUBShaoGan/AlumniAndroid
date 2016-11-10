package com.slut.alumni.login.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.slut.alumni.App;
import com.slut.alumni.R;
import com.slut.alumni.api.ApiConst;
import com.slut.alumni.api.BodyUtils;
import com.slut.alumni.bean.gson.LoginBean;
import com.slut.alumni.utils.ErrorMessage;
import com.slut.alumni.utils.StringUtils;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class ILoginModelImpl implements ILoginModel {

    @Override
    public void login(String account, String password, final OnLocalLoginListener onLocalLoginListener) {
        //账户为空
        if (StringUtils.isNullOrEmpty(account)) {
            ErrorMessage errorMessage = new ErrorMessage(1000, StringUtils.getStringFromRes(R.string.error_login_account_null));
            onLocalLoginListener.onLocalLoginError(errorMessage);
            return;
        }
        //密码位数不符合要求
        if (!StringUtils.isPasswordUseful(password)) {
            ErrorMessage errorMessage = new ErrorMessage(1001, StringUtils.getStringFromRes(R.string.error_login_pwd_notuseful));
            onLocalLoginListener.onLocalLoginError(errorMessage);
            return;
        }
        OkGo
                .post(ApiConst.LOGIN)
                .params(BodyUtils.getLoginBody(account, StringUtils.MD5(password)), false)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int errno = jsonObject.getInt("errno");
                            String msg = jsonObject.getString("msg");
                            if (errno == 0) {
                                LoginBean loginBean = App.getGson().fromJson(s, LoginBean.class);
                                App.setLoginBean(loginBean);
                                onLocalLoginListener.onLocalLoginSuccess();
                            } else {
                                ErrorMessage errorMessage = new ErrorMessage(1002, msg);
                                onLocalLoginListener.onLocalLoginError(errorMessage);
                            }
                        } catch (Exception e) {
                            ErrorMessage errorMessage = new ErrorMessage(1003, StringUtils.getStringFromRes(R.string.error_common_notjson));
                            onLocalLoginListener.onLocalLoginError(errorMessage);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ErrorMessage errorMessage = new ErrorMessage(1004, StringUtils.getStringFromRes(R.string.error_login_noresp));
                        onLocalLoginListener.onLocalLoginError(errorMessage);
                    }
                });
    }
}

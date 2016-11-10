package com.slut.alumni.register.model;

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
 * Created by 七月在线科技 on 2016/11/10.
 */

public class RegModelImpl implements RegModel {
    @Override
    public void register(String nickname, String account, String password, final OnRegisterListener onRegisterListener) {
        if (StringUtils.isNullOrEmpty(nickname)) {
            ErrorMessage errorMessage = new ErrorMessage(1000, StringUtils.getStringFromRes(R.string.error_reg_nickname_null));
            onRegisterListener.onRegError(errorMessage);
            return;
        }
        if (StringUtils.isNullOrEmpty(account)) {
            ErrorMessage errorMessage = new ErrorMessage(1001, StringUtils.getStringFromRes(R.string.error_reg_account_null));
            onRegisterListener.onRegError(errorMessage);
            return;
        }
        if (!StringUtils.isPasswordUseful(password)) {
            ErrorMessage errorMessage = new ErrorMessage(1002, StringUtils.getStringFromRes(R.string.error_reg_password_notuseful));
            onRegisterListener.onRegError(errorMessage);
            return;
        }
        OkGo
                .post(ApiConst.REGISTER)
                .params(BodyUtils.getRegBody(nickname, account, password))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int errno = jsonObject.getInt("errno");
                            String msg = jsonObject.getString("msg");
                            if (errno == 0) {
                                onRegisterListener.onRegSuccess();
                            } else {
                                ErrorMessage errorMessage = new ErrorMessage(1003, msg);
                                onRegisterListener.onRegError(errorMessage);
                            }
                        } catch (Exception e) {
                            ErrorMessage errorMessage = new ErrorMessage(1004, StringUtils.getStringFromRes(R.string.error_common_notjson));
                            onRegisterListener.onRegError(errorMessage);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ErrorMessage errorMessage = new ErrorMessage(1005, StringUtils.getStringFromRes(R.string.error_login_noresp));
                        onRegisterListener.onRegError(errorMessage);
                    }
                });
    }
}

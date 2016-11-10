package com.slut.alumni.login.model;

import com.slut.alumni.utils.ErrorMessage;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public interface ILoginModel {

    interface OnLocalLoginListener {

        void onLocalLoginSuccess();

        void onLocalLoginError(ErrorMessage errorMessage);

    }

    void login(String account, String password, OnLocalLoginListener onLocalLoginListener);

}

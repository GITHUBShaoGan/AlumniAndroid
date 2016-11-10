package com.slut.alumni.register.model;

import com.slut.alumni.utils.ErrorMessage;

/**
 * Created by 七月在线科技 on 2016/11/10.
 */

public interface RegModel {

    interface OnRegisterListener {
        void onRegSuccess();

        void onRegError(ErrorMessage errorMessage);
    }

    void register(String nickname, String account, String password, OnRegisterListener onRegisterListener);

}

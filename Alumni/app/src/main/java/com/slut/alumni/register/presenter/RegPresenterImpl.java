package com.slut.alumni.register.presenter;

import com.slut.alumni.register.model.RegModel;
import com.slut.alumni.register.model.RegModelImpl;
import com.slut.alumni.register.view.RegView;
import com.slut.alumni.utils.ErrorMessage;

/**
 * Created by 七月在线科技 on 2016/11/10.
 */

public class RegPresenterImpl implements RegPresenter, RegModel.OnRegisterListener {

    private RegModel regModel;
    private RegView regView;

    public RegPresenterImpl(RegView regView) {
        this.regView = regView;
        this.regModel = new RegModelImpl();
    }

    @Override
    public void register(String nickname, String account, String password) {
        regModel.register(nickname, account, password, this);
    }

    @Override
    public void onRegSuccess() {
        regView.onRegSuccess();
    }

    @Override
    public void onRegError(ErrorMessage errorMessage) {
        regView.onRegError(errorMessage);
    }
}

package com.slut.alumni.login.presenter;

import com.slut.alumni.login.model.ILoginModel;
import com.slut.alumni.login.model.ILoginModelImpl;
import com.slut.alumni.login.view.ILoginView;
import com.slut.alumni.utils.ErrorMessage;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class ILoginPresenterImpl implements ILoginPresenter, ILoginModel.OnLocalLoginListener {

    private ILoginModel iLoginModel;
    private ILoginView iLoginView;

    public ILoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.iLoginModel = new ILoginModelImpl();
    }

    @Override
    public void login(String account, String password) {
        iLoginModel.login(account, password, this);
    }

    @Override
    public void onLocalLoginSuccess() {
        iLoginView.onLoginSuccess();
    }

    @Override
    public void onLocalLoginError(ErrorMessage errorMessage) {
        iLoginView.onLoginError(errorMessage);
    }
}

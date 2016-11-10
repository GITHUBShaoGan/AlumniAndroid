package com.slut.alumni.register.view;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.slut.alumni.R;
import com.slut.alumni.register.presenter.RegPresenter;
import com.slut.alumni.register.presenter.RegPresenterImpl;
import com.slut.alumni.utils.ErrorMessage;
import com.slut.alumni.utils.StringUtils;
import com.slut.alumni.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.til_nickname)
    TextInputLayout tilNickname;
    @BindView(R.id.til_account)
    TextInputLayout tilAccount;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.til_confirm)
    TextInputLayout tilConfirm;

    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        regPresenter = new RegPresenterImpl(this);
    }

    @OnClick(R.id.btn_reg)
    void onRegClick() {
        String nickname = tilNickname.getEditText().getText().toString().trim();
        String account = tilAccount.getEditText().getText().toString().trim();
        String password = StringUtils.MD5(tilPassword.getEditText().getText().toString().trim());
        regPresenter.register(nickname, account, password);
    }

    @OnClick(R.id.tv_go2rule)
    void onGo2Rule() {

    }

    @Override
    public void onRegSuccess() {
        ToastUtils.showShort(R.string.resp_reg_ok);
    }

    @Override
    public void onRegError(ErrorMessage errorMessage) {
        ToastUtils.showShort(errorMessage.getMsg());
    }
}

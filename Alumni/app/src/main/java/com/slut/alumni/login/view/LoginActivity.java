package com.slut.alumni.login.view;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.slut.alumni.R;
import com.slut.alumni.login.presenter.ILoginPresenter;
import com.slut.alumni.login.presenter.ILoginPresenterImpl;
import com.slut.alumni.main.view.MainActivity;
import com.slut.alumni.register.view.RegisterActivity;
import com.slut.alumni.utils.ErrorMessage;
import com.slut.alumni.utils.ScreenUtils;
import com.slut.alumni.utils.SystemUtils;
import com.slut.alumni.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.box_logo)
    LinearLayout boxLogo;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.til_account)
    TextInputLayout tilAccount;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;

    private EditText editAccount;
    private EditText editPassword;

    private ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        iLoginPresenter = new ILoginPresenterImpl(this);
        SystemUtils.hideStatusBar(this);

        //从textinputlayout中获取edittext
        editAccount = tilAccount.getEditText();
        editPassword = tilPassword.getEditText();

        //设置logo高度为屏幕高度的1/4
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) boxLogo.getLayoutParams();
        layoutParams.width = ScreenUtils.getScreenWidth();
        layoutParams.height = ScreenUtils.getScreenHeight() / 3;
        boxLogo.setLayoutParams(layoutParams);

    }

    @OnClick(R.id.btn_login)
    void onLoginClick() {
        String account = editAccount.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        iLoginPresenter.login(account, password);
    }

    @OnClick(R.id.tv_2_reg)
    void on2RegClick() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void onLoginSuccess() {
        ToastUtils.showShort(R.string.resp_login_ok);
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onLoginError(ErrorMessage errorMessage) {
        ToastUtils.showShort(errorMessage.getMsg());
    }
}

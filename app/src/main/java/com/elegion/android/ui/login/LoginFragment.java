package com.elegion.android.ui.login;

import android.support.v4.app.Fragment;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.elegion.android.R;
import com.elegion.android.data.Repository;
import com.elegion.android.ui.base.fragment.BaseNoInternetFragment;
import com.elegion.android.ui.features.FeaturesActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * @author Mike
 */

public class LoginFragment extends BaseNoInternetFragment implements LoginView {
    @BindView(R.id.content_layout)
    View mTopLayout;

    @InjectPresenter
    LoginPresenter mPresenter;

    @ProvidePresenter
    LoginPresenter providePresenter() {
        return new LoginPresenter(Repository.get(getActivity()));
    }

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fr_login;
    }

    @OnClick(R.id.login_btn)
    public void onLoginClick() {
        mPresenter.login();
    }

    @OnTextChanged(R.id.email)
    public void onEmailChanged(CharSequence text) {
        mPresenter.setEmail(text.toString());
    }

    @OnTextChanged(R.id.password)
    public void onPasswordChanged(CharSequence text) {
        mPresenter.setPassword(text.toString());
    }

    @Override
    protected View[] getViews() {
        return new View[] {mTopLayout};
    }

    @Override
    public void tryAgain() {
        mPresenter.login();
    }

    @Override
    public void loginSuccessful() {
        startActivity(FeaturesActivity.makeIntent(getActivity()));
        getActivity().finish();
    }
}

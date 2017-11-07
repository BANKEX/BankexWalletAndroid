package com.elegion.android.template.ui.splash;

import android.os.CountDownTimer;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.elegion.android.template.R;
import com.elegion.android.template.data.Repository;
import com.elegion.android.template.ui.base.activity.BaseActivity;
import com.elegion.android.template.ui.features.FeaturesActivity;
import com.elegion.android.template.ui.login.LoginActivity;

/**
 * @author mikhail barannikov
 */
public class SplashActivity extends BaseActivity implements SplashView {
    private static final int SPLASH_DURATION = 500;

    @InjectPresenter
    SplashPresenter mPresetner;

    private CountDownTimer mTimer;
    private boolean mTimerFinished;

    @ProvidePresenter
    SplashPresenter providePresenter() {
        return new SplashPresenter(Repository.get(this));
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_splash;
    }

    @Override
    protected void onResume() {
        super.onResume();
        cancelTimer();
        mTimer = getSplashTimer();
        mTimer.start();
    }

    @Override
    protected void onPause() {
        cancelTimer();
        super.onPause();
    }

    private void cancelTimer() {
        mTimerFinished = false;
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    private CountDownTimer getSplashTimer() {
        return new CountDownTimer(SPLASH_DURATION, SPLASH_DURATION) {
            @Override
            public void onTick(long millisUntilFinished) {
                // nothing
            }

            @Override
            public void onFinish() {
                mTimerFinished = true;
                openNextActivity();
            }
        };
    }

    private void openNextActivity() {
        if (mTimerFinished) {
            mPresetner.timerFinish();
        }
    }

    @Override
    public void openLogin() {
        startActivity(LoginActivity.makeIntent(this));
        supportFinishAfterTransition();
    }

    @Override
    public void openFeatures() {
        startActivity(FeaturesActivity.makeIntent(this));
        supportFinishAfterTransition();
    }
}
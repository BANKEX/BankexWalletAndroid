package com.elegion.android.template.ui.login

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.elegion.android.template.ui.base.view.ErrorView
import com.elegion.android.template.ui.base.view.LoadingView
import com.elegion.android.template.ui.base.view.NoInternetStubView

internal interface LoginView : LoadingView, NoInternetStubView, ErrorView, MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun loginSuccessful()
}
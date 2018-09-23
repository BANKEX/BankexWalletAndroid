package com.bankex.pay.presentation.ui.navigation.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.bankex.pay.presentation.ui.base.BaseFragment;

/**
 * @author Pavel Apanovskiy on 12.09.2018.
 */
public interface IHomeRouter {

    void goToWalletTab(FragmentActivity activity,
                       BaseFragment fragment);

    void goToHistoryTab(FragmentActivity activity,
                        BaseFragment fragment);

    void goToContactsTab(FragmentActivity activity,
                         BaseFragment fragment);

    void goToSettingsTab(FragmentActivity activity,
                         Fragment fragment);
}
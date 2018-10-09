package com.bankex.pay.ui.navigation.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.bankex.pay.R;
import com.bankex.pay.ui.navigation.base.BaseRouter;
import com.bankex.pay.ui.view.base.BaseFragment;
import com.bankex.pay.ui.view.transactionhistory.TransactionHistoryFragment;

/**
 * @author Pavel Apanovskiy on 12.09.2018.
 */
public class HomeRouter extends BaseRouter implements IHomeRouter {

    @Override
    public void goToWalletTab(FragmentActivity activity,
                              BaseFragment fragment) {
        runFragmentWithAnimation(activity,
                fragment,
                R.id.fragment_container);
    }

    @Override
    public void goToHistoryTab(FragmentActivity activity) {
        runFragmentWithAnimation(activity,
                TransactionHistoryFragment.newInstance(),
                R.id.fragment_container);
    }

    @Override
    public void goToContactsTab(FragmentActivity activity,
                                BaseFragment fragment) {
        runFragmentWithAnimation(activity,
                fragment,
                R.id.fragment_container);
    }

    @Override
    public void goToSettingsTab(FragmentActivity activity,
                                Fragment fragment) {
        runFragmentWithAnimation(activity,
                fragment,
                R.id.fragment_container);
    }
}
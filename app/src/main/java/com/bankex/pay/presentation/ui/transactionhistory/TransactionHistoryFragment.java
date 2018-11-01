package com.bankex.pay.presentation.ui.transactionhistory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bankex.pay.R;
import com.bankex.pay.di.transactionhistory.TransactionHistoryInjector;
import com.bankex.pay.presentation.presenter.transactionhistory.TransactionHistoryPresenter;
import com.bankex.pay.presentation.ui.base.BaseFragment;
import com.bankex.pay.presentation.navigation.transactionhistory.ITransactionHistoryRouter;

import javax.inject.Inject;

/**
 * Фрагмент экрана истории транзакций
 *
 * @author Pavel Apanovskiy on 27/09/2018.
 */
public class TransactionHistoryFragment extends BaseFragment implements ITransactionHistoryView {

    @Inject
    ITransactionHistoryRouter mTransactionHistoryRouter;

    @Inject
    @InjectPresenter
    TransactionHistoryPresenter mTransactionHistoryPresenter;

    @ProvidePresenter
    public TransactionHistoryPresenter providePresenter() {
        return mTransactionHistoryPresenter;
    }

    public static TransactionHistoryFragment newInstance() {
        return new TransactionHistoryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TransactionHistoryInjector.getTransactionHistoryComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.transaction_history_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTransactionHistoryPresenter.doMagic();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TransactionHistoryInjector.clearTransactionHistoryComponent();
    }

    @Override
    public void showToast() {
       // Toast.makeText(getActivity(), "TransactionHistory", Toast.LENGTH_SHORT).show();
    }
}

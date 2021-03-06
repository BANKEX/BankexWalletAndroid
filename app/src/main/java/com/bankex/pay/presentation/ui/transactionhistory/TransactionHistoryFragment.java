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
import com.bankex.pay.presentation.navigation.transactionhistory.ITransactionHistoryRouter;
import com.bankex.pay.presentation.presenter.TransactionHistoryPresenter;
import com.bankex.pay.presentation.ui.base.BaseFragment;
import javax.inject.Inject;

/**
 * View for transaction history screen.
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

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		TransactionHistoryInjector.getTransactionHistoryComponent().inject(this);
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return setAndBindContentView(inflater, container, R.layout.fragment_transaction_history);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		TransactionHistoryInjector.clearTransactionHistoryComponent();
	}
}

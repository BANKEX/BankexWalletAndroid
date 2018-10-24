package com.bankex.pay.presentation.presenter.contacts;

import com.arellomobile.mvp.InjectViewState;
import com.bankex.pay.data.entity.ContactModel;
import com.bankex.pay.presentation.presenter.base.BasePresenter;
import com.bankex.pay.presentation.ui.view.contacts.IContactsView;

/**
 * Presenter for Contacts screen
 */
@InjectViewState
public class ContactsPresenter extends BasePresenter<IContactsView> {

	ContactModel contact;

	public ContactsPresenter() {
	}

	public void doMagic() {
		getViewState().showMessage();
	}
}

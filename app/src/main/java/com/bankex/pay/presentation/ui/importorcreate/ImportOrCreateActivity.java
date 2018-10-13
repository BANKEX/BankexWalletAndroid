package com.bankex.pay.presentation.ui.importorcreate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bankex.pay.R;
import com.bankex.pay.presentation.ui.view.base.BaseActivity;

/**
 * Активити экрана Импорта Создания Кошелька
 *
 * @author Gevork Safaryan on 18.09.2018
 */
public class ImportOrCreateActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, ImportOrCreateActivity.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.import_or_create_activity);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ImportOrCreateFragment())
                .commit();
    }
}

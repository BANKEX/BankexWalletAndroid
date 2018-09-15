package com.bankex.pay.di.module;

import com.bankex.pay.domain.navigation.home.HomeRouter;
import com.bankex.pay.domain.navigation.home.IHomeRouter;
import com.bankex.pay.domain.navigation.settings.ISettingsRouter;
import com.bankex.pay.domain.navigation.settings.SettingsRouter;
import com.bankex.pay.domain.navigation.wallet.IWalletRouter;
import com.bankex.pay.domain.navigation.wallet.WalletRouter;
import com.bankex.pay.presentation.ui.navigation.BankexRouter;
import com.bankex.pay.presentation.ui.navigation.IBankexRouter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Модуль навигации
 *
 * @author Gevork Safaryan on 11.09.2018.
 */
@Module
public class NavigationModule {

    @Provides
    @Singleton
    IBankexRouter provideBankexRouter() {
        return new BankexRouter();
    }

    @Provides
    @Singleton
    IHomeRouter provideHomeRouter() {
        return new HomeRouter();
    }

    @Provides
    @Singleton
    IWalletRouter provideWalletRouter() {
        return new WalletRouter();
    }

    @Provides
    @Singleton
    ISettingsRouter provideSettingsRouter() {
        return new SettingsRouter();
    }
}
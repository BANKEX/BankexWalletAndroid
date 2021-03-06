package com.bankex.pay;

import android.app.Application;
import com.bankex.pay.di.application.ApplicationComponent;
import com.bankex.pay.di.application.DaggerApplicationComponent;
import com.bankex.pay.di.applicationmodules.AnalyticsModule;
import com.bankex.pay.di.applicationmodules.NavigationModule;
import com.bankex.pay.di.applicationmodules.NetworkModule;
import com.bankex.pay.di.applicationmodules.RealmModule;
import com.bankex.pay.di.applicationmodules.RxModule;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Application class for Bankex-Pay application.
 */
public class BankexPayApplication extends Application {
	private static BankexPayApplication sInstance;
	private static ApplicationComponent sApplicationComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;

		buildAppComponent();
		initRealm();
		initFabric();
	}

	private void buildAppComponent() {
		sApplicationComponent = DaggerApplicationComponent.builder()
				.networkModule(new NetworkModule())
				.rxModule(new RxModule())
				.realmModule(new RealmModule())
				.navigationModule(new NavigationModule())
				.analyticsModule(new AnalyticsModule())
				.build();
	}

	private void initRealm() {
		Realm.init(getApplicationContext());
		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
				.name("bankex-pay.realm")
				.schemaVersion(0)
				.build();
		Realm.setDefaultConfiguration(realmConfiguration);
	}

	private void initFabric() {
		Fabric.with(getApplicationContext(), new Crashlytics());
	}

	public static BankexPayApplication getInstance() {
		return sInstance;
	}

	public static ApplicationComponent getApplicationComponent() {
		return sApplicationComponent;
	}
}

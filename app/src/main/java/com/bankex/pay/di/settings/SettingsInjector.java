package com.bankex.pay.di.settings;

import com.bankex.pay.di.mainscreen.MainScreenInjector;

/**
 * Injector for {@link SettingsComponent}.
 */
public class SettingsInjector {
	private static SettingsComponent sSettingsComponent;

	public static SettingsComponent getSettingsComponent() {
		if (sSettingsComponent == null) {
			sSettingsComponent = MainScreenInjector.getMainScreenComponent()
					.plusSettingsComponent()
					.makeSettingsModule(new SettingsModule())
					.build();
		}
		return sSettingsComponent;
	}

	public static void clearSettingsComponent() {
		sSettingsComponent = null;
	}
}

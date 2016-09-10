package com.elegion.android.view;

import android.support.annotation.NonNull;

import com.elegion.android.model.GroupInfo;

/**
 * @author Nikita Bumakov
 */
public interface MainView {

    void showInfo(@NonNull GroupInfo groupInfo);
}

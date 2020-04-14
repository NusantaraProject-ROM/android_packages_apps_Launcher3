package com.android.launcher3.settings;

import android.content.Context;
import android.util.AttributeSet;

import androidx.preference.ListPreference;

public class ReloadingListPreference extends ListPreference {
    public interface OnReloadListener {
        void updateList(ListPreference pref);
    }

    private OnReloadListener mOnReloadListener;

    public ReloadingListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ReloadingListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ReloadingListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReloadingListPreference(Context context) {
        super(context);
    }

    @Override
    protected void onClick() {
        super.onClick();
        loadEntries();
    }

    public void setOnReloadListener(OnReloadListener onReloadListener) {
        mOnReloadListener = onReloadListener;
        loadEntries();
    }

    private void loadEntries() {
        if (mOnReloadListener != null) {
            mOnReloadListener.updateList(this);
        }
    }
}

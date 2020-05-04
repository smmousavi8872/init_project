package com.developer.smmmousavi.initialstructure.manager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

public class KeyboardManager {


    private static final String TAG = KeyboardManager.class.getSimpleName();

    public interface OnKeyboardListener {
        void onKeyboardVisible();

        void onKeyboardHidden();
    }

    public KeyboardManager(Context context) {
        mContext = context;
    }

    private Context mContext;
    private View mContentView;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private boolean mIsKeyboardVisible;

    public void registerKeyboardListener(final OnKeyboardListener listener, View view) {
        mContentView = view;
        unregisterKeyboardListener();
        mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mPreviousHeight;

            @Override
            public void onGlobalLayout() {
                int newHeight = mContentView.getHeight();
                if (mPreviousHeight != 0) {
                    if (mPreviousHeight < newHeight) {
                        // In this place keyboard is hidden but navigation bar is appeared
                        // will hide it
                        Log.d(TAG, "onLayoutChangedDown");
                        if (mIsKeyboardVisible) {
                            mIsKeyboardVisible = false;
                            hideNavigationBar();
                            if (listener != null) {
                                listener.onKeyboardHidden();
                            }
                        }
                    } else if (mPreviousHeight > newHeight) {
                        // This block will be called when navigation bar is appeared
                        // There are two cases:
                        // 1. When something modal view (like dialog) is appeared
                        // 2. When keyboard is appeared

                        Log.d(TAG, "onLayoutChangedUp");

                        // Will ask InputMethodManager.isAcceptingText() to detect if keyboard appeared or not.
                        InputMethodManager imm = (InputMethodManager) mContentView.getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                        boolean isAcceptingText = imm.isAcceptingText();
                        if (isAcceptingText) {
                            mIsKeyboardVisible = true;
                        }
                        if (mIsKeyboardVisible) {
                            if (listener != null) {
                                listener.onKeyboardVisible();
                            }
                        }
                    }
                }
                mPreviousHeight = newHeight;
            }
        };
        mContentView.getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
    }

    public void unregisterKeyboardListener() {
        if (mOnGlobalLayoutListener != null) {
            mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(mOnGlobalLayoutListener);
        }
    }

    private void hideNavigationBar() {
        if (mContext instanceof Activity) {
            ((Activity) mContext).getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }


    public void hide(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void show(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public boolean isKeyboardVisible() {
        return mIsKeyboardVisible;
    }
}

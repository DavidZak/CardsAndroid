package com.mradmin.yks13.base

import android.support.v7.app.AppCompatActivity
import android.app.Activity
import android.content.Context
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager


open class BaseActivity : AppCompatActivity() {

    override fun onPause() {
        super.onPause()
        hideKeyBoard()
    }

    protected fun hideKeyBoard() {
        val currentFocus = currentFocus ?: return

        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm!!.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}
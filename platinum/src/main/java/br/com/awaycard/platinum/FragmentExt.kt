package br.com.awaycard.platinum

import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(newColor: Int, useDarkIconStatusBar: Boolean = true) {
    requireActivity().window.decorView.systemUiVisibility =
        if (useDarkIconStatusBar) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            return
        } else 0
    requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), newColor)
}

fun Fragment.changeNavigationBarColor(newColor: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), newColor)
    }
}
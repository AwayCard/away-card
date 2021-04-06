package br.com.awaycard.platinum

import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.changeBackgroundStatusBar(newColor: Int, useDarkIconStatusBar: Boolean = true) {
        if (useDarkIconStatusBar) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            useDarkIconStatusBar()
        } else {
            return
        } else useLightIconStatusBar()

    requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), newColor)
}

fun Fragment.changeToTranslucent() {
    requireActivity().window.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
}

fun Fragment.useDarkIconStatusBar() {
    requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}

fun Fragment.useLightIconStatusBar() {
    requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    requireActivity().window.decorView.systemUiVisibility = 0
}

fun Fragment.changeNavigationBarColor(newColor: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), newColor)
    }
}

fun Fragment.hideNavigationBar() {
    requireActivity().window.decorView.apply {
        systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }
}

fun Fragment.enableFullscreenMode() {
    requireActivity().window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            // Hide the nav bar and status bar
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
}
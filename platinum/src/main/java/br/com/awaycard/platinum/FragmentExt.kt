package br.com.awaycard.platinum

import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.changeStatusBarColor(newColor: Int) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), newColor)
    }
}

fun Fragment.changeNavigationBarColor(newColor: Int) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), newColor)
    }
}
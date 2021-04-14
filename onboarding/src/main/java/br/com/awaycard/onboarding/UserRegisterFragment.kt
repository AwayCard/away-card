package br.com.awaycard.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.awaycard.onboarding.viewmodel.UserRegisterViewModel
import br.com.awaycard.platinum.ScreenIndicator
import br.com.awaycard.platinum.enableFullscreenMode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class UserRegisterFragment : Fragment() {
    private val viewmodel by viewModels<UserRegisterViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enableFullscreenMode()

        requireView().findViewById<ScreenIndicator>(R.id.userRegisterIndicator).setOnClickListener {
            val input = requireActivity().findViewById<AppCompatEditText>(R.id.userRegisterInput).text.toString()

            lifecycleScope.launch {
                viewmodel.execute(input)
                findNavController().navigate(UserRegisterFragmentDirections.actionUserRegisterBottomSheetToCardRegisterFragment())
            }
        }
    }
}
package br.com.awaycard.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.awaycard.platinum.changeToTranslucent
import br.com.awaycard.platinum.enableFullscreenMode
import br.com.awaycard.platinum.useDarkIconStatusBar

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enableFullscreenMode()

        requireActivity().findViewById<LinearLayoutCompat>(R.id.introLetsGo).setOnClickListener {
            findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToIntroTeaserFragment())
        }
    }
}
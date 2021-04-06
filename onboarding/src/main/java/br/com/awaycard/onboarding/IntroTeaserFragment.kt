package br.com.awaycard.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.navigation.fragment.findNavController
import br.com.awaycard.platinum.enableFullscreenMode

class IntroTeaserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro_teaser, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enableFullscreenMode()

        requireActivity().findViewById<LinearLayoutCompat>(R.id.teaserSkip).setOnClickListener {
            findNavController().navigate(IntroTeaserFragmentDirections.actionIntroTeaserFragmentToUserRegisterBottomSheet())
        }
    }
}
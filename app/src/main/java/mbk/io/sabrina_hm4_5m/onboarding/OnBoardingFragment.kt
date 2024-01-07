package mbk.io.sabrina_hm4_5m.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.sabrina_hm4_5m.Pref
import mbk.io.sabrina_hm4_5m.R
import mbk.io.sabrina_hm4_5m.databinding.FragmentOnBoardingBinding
import mbk.io.sabrina_hm4_5m.onboarding.adapter.OnBoardingAdapter
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private val adapter = OnBoardingAdapter(this::onClick)
    private lateinit var binding: FragmentOnBoardingBinding

    @Inject
    lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.circleIndicator.setViewPager(binding.viewPager)
    }

    private fun onClick() {
        pref.onBoardingShow()
        findNavController().navigate(R.id.mainFragment)
    }
}

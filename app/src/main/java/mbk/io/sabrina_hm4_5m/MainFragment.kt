package mbk.io.sabrina_hm4_5m

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.sabrina_hm4_5m.databinding.FragmentMainBinding
import mbk.io.sabrina_hm4_5m.databinding.FragmentOnBoardingBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var pref: Pref

    @Inject
    lateinit var utils: Utils

    @Inject
    lateinit var hero: Hero

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnHistory.setOnClickListener{
                //startActivity(Intent(this@MainFragment, SecondFragment::class.java))
                findNavController().navigate(R.id.secondFragment)
            }
            btnGet.setOnClickListener {
                /*utils.showToast(this@MainActivity, hero.name + "${hero.damage}")
                sharedPreferences.edit().putBoolean("as", true).apply()*/
                viewModel.getLoveLiveData(etFname.text.toString(), etSname.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        App.appDatabase.getDao().insert(it)
                        tvResult.text = it.toString()
                    })
            }
        }
    }
}
package mbk.io.sabrina_hm4_5m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import mbk.io.sabrina_hm4_5m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnGet.setOnClickListener {
                viewModel.getLoveLiveData(etFname.text.toString(), etSname.text.toString())
                    .observe(this@MainActivity, Observer {
                        tvResult.text = it.toString()
                    })
            }
        }
    }
}
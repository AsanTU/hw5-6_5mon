package mbk.io.sabrina_hm4_5m


import android.content.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Pref @Inject constructor (private val pref: SharedPreferences) {

    fun onShowed():Boolean{
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onBoardingShow() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object{
        const val SHOWED_KEY = "showed.key"
    }
}
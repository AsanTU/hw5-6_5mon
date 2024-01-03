package mbk.io.sabrina_hm4_5m

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class LoveViewModel : ViewModel() {
    private val repository = Repository()

    fun getLoveLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}
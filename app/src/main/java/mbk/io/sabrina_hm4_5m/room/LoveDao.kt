package mbk.io.sabrina_hm4_5m.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mbk.io.sabrina_hm4_5m.model.LoveModel

@Dao
interface LoveDao {

    @Query("SELECT * FROM `love-table` ORDER by firstName ASC")
    fun getAll(): List<LoveModel>

    @Insert
    fun insert(vararg model: LoveModel)
}